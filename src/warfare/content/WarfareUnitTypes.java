package warfare.content;

import mindustry.core.*;
import warfare.content.WarfareBlocks.*;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.content.Fx;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.bullet.BulletType.*;
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

    public static UnitType repairCamp, repairOutpost, repairCenter, fieldCenter, riot, tumult, siege, affray;


    public static void load(){ 
    
    //Support Unit Tree

    //Support Weak Repair
    repairCamp = new UnitType("repairCamp"){{
        aiController = RepairAI::new;
        constructor = UnitEntity::create;

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
    repairOutpost = new UnitType("repairOutpost"){{
constructor = UnitEntity::create;

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

    //Support B2
    riot = new UnitType("fort"){{
constructor = UnitEntity::create;

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
        constructor = UnitEntity::create;
        hitSize = 13f;
        health = 500f;
        armor = 8f;

        abilities.add(new RepairFieldAbility(10f, 60f, 60f));

        abilities.add(new ForceFieldAbility(40f, 0.5f, 800f, 240f));
    }};

    //Support C2
    fieldCenter = new UnitType("quasar"){{
        constructor = UnitEntity::create;
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
        constructor = UnitEntity::create;
        speed = 0.75f;
        mechFrontSway = 1f;
        health = 6000f;
        singleTarget = true;
        armor = 5f;
        
        weapons.add(new Weapon("spiroct-weapon"){{
            x = 15f;
            shootY = 8;
            reload = 10;
            rotate = true;

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

    //Support C4
    //Needs sprites still
    siege = new UnitType("reign"){{
        hitSize = 30f;
        constructor = UnitEntity::create;
        speed = 0.3f;
        health = 4120f;
        mechFrontSway = 1.2f;
        armor = 20f;

        weapons.add(new Weapon("sei-launcher"){{
            reload = 10f;
            x = 10f;
            
            shoot = new ShootAlternate(){{
                shots = 3;
                shotDelay = 1.5f;
                barrels = 3;
                spread = 4f;
            }};
            bullet = new MissileBulletType(4f, 50){{
                    homingPower = 0.10f;
                    width = 8f;
                    height = 12f;
                    shrinkX = shrinkY = 0f;
                    drag = 0.02f;
                    homingRange = 80f;
                    keepVelocity = false;
                    splashDamageRadius = 35f;
                    splashDamage = 45f;
                    lifetime = 120f;
                    trailColor = Pal.bulletYellowBack;
                    backColor = Pal.bulletYellowBack;
                    frontColor = Pal.bulletYellow;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 10f;
                    weaveMag = 3f;
                }};
        }});
    }};

    //Tumult Upgrade 1
    affray = new UnitType("scepter1"){{
        hitSize = 18f;
        constructor = UnitEntity::create;
        speed = 1f;
        mechFrontSway = 1.6f;
        health = 10000f;
        armor = 10f;

        weapons.add(new Weapon("scathe-missle"){{
            reload = 20f;
            hitSize = 10f;
        }});
    }};
}};
    }};
