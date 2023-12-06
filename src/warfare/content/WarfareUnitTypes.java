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
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.bullet.BulletType;
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
import mindustry.Vars;

import static mindustry.entities.bullet.BulletType.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class WarfareUnitTypes{

    public static UnitType assault, artillery;

    public static UnitType repairCamp, repairOutpost, repairCenter, fieldCenter, riot, tumult;


    public static void load(){ 
    
    //Attack A1
    assault = new UnitType("dagger"){{
        aiController = GroundAI::new;

        speed = 0.7f;
        hitSize = 8f;
        health = 100f;
        weapons.add(new Weapon("artillery"){{
            shootY = 12f;
            mirror = false;
            reload = 7f;
            x = 12f;
            bullet = new BulletType(){{
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
        aiController = GroundAI::new;

        speed = 0.2f;
        hitSize = 13f;
        rotateSpeed = 2f;
        targetAir = false;
        health = 600f;
        mechFrontSway = 0.55f;

        weapons.add(new Weapon("scepter-weapon"){{
            x = 18f;
            mirror = false;
            shootY = 18f;
            reload = 60f;
            range = 15f;
            bullet = new BulletType(){{
                lifetime = 300f;
                speed = 60f;
                splashDamage = 75f;
                splashDamageRadius = 40f;
            }};
        }});
    }};
    
    
    
    //Support Unit Tree

    //Support Weak Repair
    repairCamp = new UnitType("nova"){{
        aiController = RepairAI::new;

        hitSize = 8f;
        speed = 1.5f;
        health = 75f;
        abilities.add(new RegenAbility(){{
            percentAmount = 0.3f;
        }});

        weapons.add(new RepairBeamWeapon("repair-beam-weapon-center-large"){{
            mirror = true;
            shootY = 5f;
            repairSpeed = 1f;

        }});
    }};
    //LAYER TWO SUPPORT
    //Support 75% heal 25% shield
    repairOutpost = new UnitType("pulsar"){{
        hitSize = 11f;
        speed = 1.75f;
        health = 250f;

        abilities.add(new RepairFieldAbility(5f, 90f, 40f));

        abilities.add(new ForceFieldAbility(40f, 0.3f, 750f, 300f));

        weapons.add(new RepairBeamWeapon("heal-shotgun-weapon"){{
            mirror = false;
            x = 8f;
            shootY = 8f;
            repairSpeed = 2.5f;
        }});

    }};

    //Support 100% shield
    riot = new UnitType("fort"){{


        hitSize = 13f;
        speed = 0.3f;
        health = 1200f;
        armor = 15f;
        mechFrontSway = 0.4f;

        abilities.add(new ForceFieldAbility(60f, 5f, 3000f, 600f));

        weapons.add(new Weapon("large-artillery"){{
            x = 18f;
            shootY = 12f;
            reload = 30f;
            inaccuracy = 1f;

            bullet = new BulletType(){{
                lifetime = -1f;
                speed = 30f;
                damage = 15f;
            }};
        }});
    }};
    //LAYER THREE SUPPORT
    //Support C1
    repairCenter = new UnitType("quasar1"){{
        hitSize = 13f;
        health = 500f;
        armor = 8f;

        abilities.add(new RepairFieldAbility(10f, 60f, 60f));

        abilities.add(new ForceFieldAbility(40f, 0.5f, 800f, 240f));
    }};

    //Support C2
    fieldCenter = new UnitType("quasar"){{
        hitSize = 14f;
        health = 500f;
        armor = 12f;

        abilities.add(new RepairFieldAbility(10f, 60f, 60f));

        abilities.add(new ForceFieldAbility(40f, 0.5f, 800f, 240f));

        weapons.add(new Weapon("heal-shotgun-weapon"){{
            x = 20f;
            shootY = 12f;
            reload = 15f;
            inaccuracy = 1f;

            bullet = new BulletType(){{
                lifetime = 60f;
                speed = 15f;
                damage = 30f;
                healPercent = 3f;

        }};
    }});

    //Support C3
    tumult = new UnitType("scepter"){{
        hitSize = 24f;
        speed = 0.75f;
        mechFrontSway = 1f;
        health = 6000f;
        singleTarget = true;
        armor = 5f;
        
        weapons.add(new Weapon("spiroct-weapon"){{
            x = 15f;
            shootY = 8;
            reload = 10;

            bullet = new BulletType(){{
                lifetime = 300f;
                speed = 7f;
                damage = -1f;
            }};
        }});

        weapons.add(new Weapon("large-bullet-mount"){{
            x = 25f;
            shootY = 15f;
            reload = 20f;

            bullet = new BulletType(){{
                lifetime = 120f;
                speed = 10f;
                damage = 200f;
            }};
        }});
    }};
}};
    }};
