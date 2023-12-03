package meme.content;

import arc.graphics.*;
import mindustry.type.*;

public class MemeLiquids{
    public static Liquid cryofluid;

    public static void load(){

    cryofluid = new Liquid("cryofluid", Color.valueOf("6ecdec")){{
        heatCapacity = 1f;
        temperature = 0.05f;
        lightColor = Color.valueOf("0097f5").a(0.2f);
        boilPoint = 0.55f;
        gasColor = Color.valueOf("c1e8f5");
        }
    };
}
}

 
