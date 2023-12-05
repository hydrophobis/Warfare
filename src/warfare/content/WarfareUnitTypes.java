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

public class MemeUnitTypes{

    public static @EntityDef({Unitc.class, Mechc.class}) UnitType dagger;


    public static void load(){
    assault = new UnitType("assault"){{
        aiController = GroundAi::new;

        speed = 0.7f;
        hitSize = 8f;
        health = 100f;
        weapons.add(new Weapon("assault-weapon"){{
            shootY = 12f;
            reload = 7f;
            x = 12f;
            warmupSpeed = 0.3f;
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
}};
