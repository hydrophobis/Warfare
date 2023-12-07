package warfare.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;



public class WarfareBlocks{
    public static Block
    
      warfareFactory, oreFactory;

      public static void load(){

        warfareFactory = new UnitFactory("ground-factory"){{
            requirements(Category.units, with(Items.copper, 0, Items.lead, 0, Items.silicon, 0));
            plans = Seq.with(
                new UnitPlan(WarfareUnitTypes.repairCamp, 10f * 10, with(Items.silicon, 0, Items.lead, 0)),
                new UnitPlan(WarfareUnitTypes.repairCenter, 10f * 10, with(Items.silicon, 8, Items.coal, 0)),
                new UnitPlan(WarfareUnitTypes.repairOutpost, 10f * 10, with(Items.silicon, 0, Items.lead, 0, Items.titanium, 0)),
                new UnitPlan(WarfareUnitTypes.fieldCenter, 10f * 10, with(Items.silicon, 0, Items.lead, 0)),
                new UnitPlan(WarfareUnitTypes.repairCamp, 10f * 10, with(Items.silicon, 0, Items.lead, 0)),
                new UnitPlan(WarfareUnitTypes.riot, 10f * 10, with(Items.silicon, 0, Items.lead, 0)),
                new UnitPlan(WarfareUnitTypes.tumult, 10f * 10, with(Items.silicon, 0, Items.lead, 0)),
                new UnitPlan(WarfareUnitTypes.siege, 10f * 10, with(Items.silicon, 0, Items.lead, 0)),
                new UnitPlan(WarfareUnitTypes.affray, 10f * 10, with(Items.silicon, 0, Items.lead, 0)));
            size = 3;
            consumePower(0f);
        }};

        oreFactory = new UnitFactory("ore-factory"){{
            requirements(Category.units, with(Items.copper, 0, Items.lead, 0, Items.silicon, 0));
            plans = Seq.with(
                new UnitPlan(WarfareUnitTypes.ore, 10f * 10, with(Items.silicon, 0)),
                new UnitPlan(WarfareUnitTypes.iron, 10f * 10, with(Items.silicon, 0)),
                new UnitPlan(WarfareUnitTypes.steel, 10f * 10, with(Items.silicon, 0)),
                new UnitPlan(WarfareUnitTypes.cordite, 10f * 10, with(Items.silicon, 0)));
            size = 3;
            consumePower(1f);
        }};
}};