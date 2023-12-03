package meme.content;

import arc.graphics.*;
import mindustry.type.*;

public class MemeItems{
    public static Item pyratite, phaseFabric;

    public static void load(){

    pyratite = new Item("pyratite", Color.valueOf("ffaa5f")){{
        flammability = 20f;
        explosiveness = 1f;
        buildable = false;
    }};
    phaseFabric = new Item("phase-fabric", Color.valueOf("f4ba6e")){{
        radioactivity = 0.00001f;
        cost = 1.3f;
        healthScaling = 0.25f;
    }};
}
}

 
