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
import mindustry.content.Bullets.*;
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

    public static UnitType ore, iron, steel, cordite;

    public static UnitType repairCamp, repairOutpost, repairCenter, fieldCenter, riot, tumult, siege, affray;


    public static void load(){
    
    ore = new UnitType("crawler"){{
        aiController = GroundAI::new;
        constructor = UnitEntity::create;

        hitSize = 3f;
        speed = 1f;
        health = 500f;
        range = 100f;

        weapons.add(new Weapon("spiroct-weapon"){{
            reload = 3f;
            x = 2f;
            shootY = 4f;
            mirror = false;

            bullet = new BasicBulletType(){{
                lifetime = 120f;
                speed = 4f;
                pierce = true;
                pierceCap = 3;
                pierceDamageFactor = 0.9f;
                damage = 12f;
                width = 4f;
                height = 6f;
            }};
        }});
    }};

    iron = new UnitType("atrax"){{
        aiController = GroundAI::new;
        constructor = UnitEntity::create;

        hitSize = 13f;
        speed = 0.6f;
        health = 3000f;
        range = 225f;

        weapons.add(new Weapon("atrax-weapon"){{
            reload = 5f;
            x = 7f;
            shootY = 4f;

            bullet = new BasicBulletType(){{
                lifetime = 120f;
                speed = 4f;
                pierce = true;
                pierceCap = 3;
                pierceDamageFactor = 0.9f;
                damage = 26f;
                width = 4f;
                height = 6f;
            }};
        }});
    }};

    steel = new UnitType("spiroct"){{
        aiController = GroundAI::new;
        constructor = UnitEntity::create;

        drag = 0.1f;
        speed = 0.7f;
        hitSize = 23f;
        health = 12000;
        armor = 6f;

        rotateSpeed = 2.7f;

        legCount = 6;
        legMoveSpace = 1f;
        legPairOffset = 3;
        legLength = 30f;
        legExtension = -15;
        legBaseOffset = 10f;
        stepShake = 1f;
        legLengthScl = 0.96f;
        rippleScale = 2f;
        legSpeed = 0.2f;

        weapons.add(new Weapon("atrax-weapon"){{
            reload = 20f;
            x = 7f;
            shootY = 4f;

            bullet = new BasicBulletType(){{
                lifetime = 120f;
                speed = 4f;
                pierce = true;
                pierceCap = 3;
                pierceDamageFactor = 0.9f;
                damage = 26f;
                width = 6f;
                height = 8f;
            }};
        }});

        weapons.add(new Weapon("spiroct-weapon"){{
            reload = 3f;
            x = 2f;
            shootY = 4f;
            mirror = false;

            bullet = new BasicBulletType(){{
                lifetime = 120f;
                speed = 4f;
                pierce = true;
                pierceCap = 3;
                pierceDamageFactor = 0.9f;
                damage = 12f;
                width = 4f;
                height = 6f;
            }};
        }});
    }};

    cordite = new UnitType("arkyid"){{
        aiController = GroundAI::new;
        constructor = UnitEntity::create;

        drag = 0.1f;
        speed = 0.7f;
        hitSize = 23f;
        health = 12000;
        armor = 6f;

        rotateSpeed = 2.7f;

        legCount = 6;
        legMoveSpace = 1f;
        legPairOffset = 3;
        legLength = 30f;
        legExtension = -15;
        legBaseOffset = 10f;
        stepShake = 1f;
        legLengthScl = 0.96f;
        rippleScale = 2f;
        legSpeed = 0.2f;

        abilities.add(new RegenAbility(){{
            amount = 15f;
        }});

        abilities.add(new ForceFieldAbility(90, 10, 6000, 300));

        weapons.add(new Weapon("large-purple-mount"){{
            reload = 20f;
            x = 2f;
            shootY = 6f;

            bullet = new BasicBulletType(){{
                lifetime = 240f;
                speed = 3f;
                pierce = true;
                pierceCap = 10;
                pierceDamageFactor = 0.9f;
                damage = 12f;
                width = 7f;
                height = 10f;
        }};
    }});


    //Support Unit Tree

    //Support Weak Repair
    repairCamp = new UnitType("repairCamp"){{
        aiController = RepairAI::new;
        constructor = UnitEntity::create;

        range = 150f;
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

            bullet = new ContinuousLaserBulletType(-10f);
        }});
    }};
    //LAYER TWO SUPPORT
    //Support 75% heal 25% shield
    repairOutpost = new UnitType(" repairOutpost"){{
    constructor = UnitEntity::create;

        hitSize = 11f;
        speed = 1.75f;
        health = 250f;
        range = 200f;

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
        range = 250f;

        abilities.add(new ForceFieldAbility(240f, 5f, 3000f, 600f));

        weapons.add(new Weapon("large-weapon"){{
            x = 10f;
            shootY = 12f;
            reload = 10f;
            inaccuracy = 1f;

            bullet = new BasicBulletType(){{
                lifetime = 60f;
                speed = 6f;
                damage = 15f;
                width = 10f;
                height = 14f;
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
        range = 250f;

        abilities.add(new RepairFieldAbility(10f, 60f, 240f));

        abilities.add(new ForceFieldAbility(180f, 0.5f, 800f, 240f));
    }};

    //Support C2
    fieldCenter = new UnitType("quasar"){{
        constructor = UnitEntity::create;
        hitSize = 14f;
        health = 500f;
        armor = 12f;
        range = 250f;

        abilities.add(new RepairFieldAbility(10f, 60f, 100f));

        abilities.add(new ForceFieldAbility(120f, 0.5f, 800f, 240f));

        weapons.add(new Weapon("heal-shotgun-weapon"){{
            x = 8f;
            shootY = 12f;
            reload = 15f;
            inaccuracy = 1f;

            bullet = new BasicBulletType(){{
                lifetime = 60f;
                speed = 2f;
                damage = 140f;
                healPercent = 3f;
                width = 10f;
                height = 14f;

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
        range = 450f;
        
        weapons.add(new Weapon("spiroct-weapon"){{
            x = 7f;
            shootY = 8;
            reload = 10;
            rotate = true;

            bullet = new BasicBulletType(){{
                lifetime = 300f;
                speed = 3f;
                damage = -1f;
                knockback = -20f;
                width = 10f;
                height = 14f;
            }};
        }});

        weapons.add(new Weapon("large-bullet-mount"){{
            x = 17f;
            shootY = 15f;
            reload = 20f;


            bullet = new BasicBulletType(){{
                lifetime = 120f;
                speed = 5f;
                damage = 200f;
                width = 10f;
                height = 14f;
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
        range = 300f;

        weapons.add(new Weapon("sei-launcher"){{
            reload = 10f;
            x = 13f;
            
            shoot = new ShootAlternate(){{
                shots = 3;
                shotDelay = 3f;
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
        speed = 0.5f;
        mechFrontSway = 1.6f;
        health = 10000f;
        armor = 10f;
        range = 550f;

        weapons.add(new Weapon("scathe-missile"){{
            reload = 1f;
            hitSize = 10f;
            mirror = false;
            x = 7f;
            recoil = 0.5f;
            shootY = 13f;
            inaccuracy = 1f;

            bullet = new BasicBulletType(){{
                lifetime = 120f;
                speed = 3f;
                damage = 40f;
                width = 7f;
                height = 10f;
            }};
        }});
    }};
    }};
}};
    }};