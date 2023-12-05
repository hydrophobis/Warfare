package warfare.content;

import mindustry.core.*;

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

    public static @EntityDef({Unitc.class, Mechc.class}) UnitType assault, artillery;

    public static @EntityDef(value = {Unitc.class, Mechc.class}, legacy = true) UnitType repairCamp, repairOutpost, siege;


    public static void load(){ 
    
    //Attack A1
    assault = new UnitType("dagger"){{
        aiController = GroundAi::new;

        speed = 0.7f;
        hitSize = 8f;
        health = 100f;
        weapons.add(new Weapon("artillery"){{
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

    //Attack B1 
    artillery = new UnitType("fortress"){{
        aiController = GroundAi::new;

        speed = 0.2f;
        hitSize = 13f;
        rotateSpeed = 2f;
        targetAir = false;
        health = 600f;
        mechFrontSway = 0.55f;

        weapon.add = new Weapon("scepter-weapon"){{
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

    //Support Weak Repair
    repairCamp = new UnitType("nova"){{
        aiController = RepairAi::new;

        hitSize = 8f;
        speed = 1.5f;
        health = 75f;
        abilities.add = new RegenAbility("camp-regen"){{
            percentAmount = 0.3f;
        }};

        weapon.add = new RepairBeamWeapon("repair-beam-weapon-center-large"){{
            mirror = true;
            shootY = 5f;
            repairSpeed = 1f;

        }};
    }};
    //LAYER TWO SUPPORT
    //Support 75% heal 25% shield
    repairOutpost = new UnitType("pulsar"){{
        hitSize = 11f;
        speed = 1.75f;
        health = 250f;

        abilities.add =(new RepairFieldAbility(5f, 90f, 40f));

        abilities.add =(new ForceFieldAbility(40f, 0.3f, 750f, 300f));

        weapon.add = new RepairBeamWeapon("heal-shotgun-weapon"){{
            mirror = false;
            x = 8f;
            shootY = 8f;
            repairSpeed = 2.5f;
        }};

    }};

    //Support 100% shield
    siege = new UnitType("fortress"){{


        hitSize = 13f;
        speed = 0.3f;
        health = 1200f;
        armor = 15f;
        mechFrontSway = 0.4f;

        abilities.add =(new ForceFieldAbility(60f, 5f, 3000f, 600f));

        weapon.add = new Weapon("large-artillery"){{
            x = 18f;
            shootY = 12f;
            reload = 30f;
            inaccuracy = 1f;

            siegeBullet = new BulletType(){{
                lifetime = -1f;
                speed = 30f;
                damage = 15f;
            }};
        }};
    }};
    //LAYER THREE SUPPORT
    //Support C1
    repairCenter = new UnitType("quasar"){{
        hitSize = 13f;
        health = 500f;
        armor = 8f;

        abilities.add =(new RepairFieldAbility(10f, 60f, 60f));

        abilities.add =(new ForceFieldAbility(40f, 0.5f, 800f, 240f));
    }};

    //Support C2
    fieldCenter = new UnitType("quasar"){{
        hitSize = 14f;
        health = 500f;
        armor = 12f;

        abilities.add =(new RepairFieldAbility(10f, 60f, 60f));

        abilities.add =(new ForceFieldAbility(40f, 0.5f, 800f, 240f));

        weapon.add = new Weapon("heal-shotgun-weapon"){{
            x = 20f;
            shootY = 12f;
            reload = 15f;
            inaccuracy = 1f;

            fieldCenterBullet = new BulletType(){{
                lifetime = 60f;
                speed = 15f;
                damage = 30f;
                color = "98ffa9ff"
                healPercent = 3f;

        }};
    }};
}};
    }};
