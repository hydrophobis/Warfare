package warfare.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.annotations.Annotations.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class WarfareUnitTypes{

    public static @EntityDef({Unitc.class, Mechc.class}) UnitType dagger;


    public static void load(){
    assault = new UnitType("assault"){{
        aiController = GroundAi::new;

        speed = 0.7f;
        hitSize = 8f;
        health = 100f;
        weapons.add(new Weapon("assault-weapon"){{
            shootY = 12f;
            mirror = false;
            reload = 7f;
            x = 12f;
            assaultBullet = new BulletType(){{
                lifetime = 90f;
                speed = 45f;
                damage = 12f;
                pierce = true;
                pierceCap = 3;
                pierceDamageFactor = 0.5f;
            }};
         }});
    }};

    artillery = new UnitType("artillery"){{
        aiController = GroundAi::new;

        speed = 0.2f;
        hitSize = 13f;
        rotateSpeed = 2f;
        targetAir = false;
        health = 600f;
        mechFrontSway = 0.55f;

        weapon.add = new Weapon("artillery-weapon"){{
            x = 18f;
            mirror = false;
            shootY = 18f;
            reload = 60f;
            range = 15f;
            artilleryBullet = new BulletType(){{
                lifetime = 300f;
                speed = 60f;
                splashDamage = 75f;
                splashDamageRadius = 40f;
            }};
        }};
    }};
    
    
    
    //Support Unit Tree

    //Repair Camp needs sprites still
    repairCamp = new UnitType("repair-camp"){{
        hitSize = 8f;
        speed = 1.5f;
        health = 75f;
        ability = new RegenAbility("camp-regen"){{
            percentAmount = 0.3f;
        }};

        weapon.add = new RepairBeamWeapon("repair-weak"){{
            x = 7f;
            shootY = 5f;
            repairSpeed = 1f;

        }};
    }};
}};
