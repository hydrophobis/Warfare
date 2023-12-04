package meme.content;

import arc.graphics;
import mindustry.type.*;

public class MemeUnitTypes{
    public static UnitType crawler;

    public static void load(){
        crawler = new UnitType("crawler"){{
            aiController = SuicideAi::new;

            speed = 1.5f;
            hitSize = 6f;
            health = 400f;
            mechSideSway = 0.25f;
            range = 50f;
            ammoType = new AmmoType();

            weapons.add(new Weapon("atrax-weapon"){{
                top = true;
                //add a shoot Y before release
                shootY = null;
                reload = 4f;
                ejectEffect = Fx.none;
                recoil = 0.6f;
                x = 4f;
                shootSound = Sounds.pew;

                bullet = new BulletType(){{
                    shootOnDeath = true;
                    shootCone = 180f;
                    damage = 9f;
                    speed = 3.5f;
                    drag = 0f;
                    shootEffect = Fx.shootSmall;
                    lifetime = 80f;
                    collidesAir = false;
                }};


            }});

            weapons.add(new Weapon(){{
               shootY = x = 0f;
               reload = 24f;
               shootSound = Sounds.explosion;
                controllable = false;
                shootY = x = 0;
               
               bullet = new BulletType(){{
                    visible = false;
                    splashDamageRadius = 110f;
                   splashDamage = 40f;
                   collides = false;
                   collidesTiles = false;
                   hitSound = Sounds.explosion;
                   hittable = false;
                   speed = 0f;
                   instantDisappear = true;
                   collidesAir = true;
                   
               }};
            }});
        }};
    }
}
