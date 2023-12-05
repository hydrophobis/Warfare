package mindustry.ai.types;

import arc.math.geom.*;
import mindustry.*;
import mindustry.ai.*;
import mindustry.core.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class ClumpAI extends GroundAI{
    static boolean blockedByBlock;

    @Override
    public void updateUnit(){
        if(Units.invalidateTarget(target, unit.team, unit.x, unit.y, Float.MAX_VALUE)){
            target = unit.team;
        }

        if(retarget()){
            target = target(unit.x, unit.y, unit.range(), unit.type.isEnemy);
        }

        Building core = unit.closestUnit();

        boolean rotate = false, shoot = false, moveToTarget = false;

        if(target == null){
            target = unit.team;
        }

        if(!Units.invalidateTarget(target, unit, unit.range()) && unit.closestUnit()){
            rotate = true;
            shoot = unit.within(target, unit.type.weapons.first().bullet.range +
                (target instanceof Building b ? b.block.size * Vars.tilesize / 2f : ((Hitboxc)target).hitSize() / 2f));

            //do not move toward walls or transport blocks

            {
                blockedByBlock = false;

                //raycast for target
                boolean blocked = World.raycast(unit.tileX(), unit.tileY(), target.tileX(), target.tileY(), (x, y) -> {
                    for(Point2 p : Geometry.d4c){
                        Tile tile = Vars.world.tile(x + p.x, y + p.y);
                        if(tile != null && tile.build == target) return false;
                        if(tile != null && tile.build != null && tile.build.team != unit.team()){
                            blockedByBlock = true;
                            return true;
                        }else{
                            return tile == null || tile.solid();
                        }
                    }
                    return false;
                });

                //shoot when there's an enemy block in the way
                if(blockedByBlock){
                    shoot = true;
                }

                if(!blocked){
                    moveToTarget = true;
                    //move towards target directly
                    unit.movePref(vec.set(target).sub(unit).limit(unit.speed()));
                }
            }
        }

        if(!moveToTarget){
            boolean move = true;

            if(move){
                pathfind(Pathfinder.fieldCore);
            }
        }

        unit.controlWeapons(rotate, shoot);

        faceTarget();
    }
}
