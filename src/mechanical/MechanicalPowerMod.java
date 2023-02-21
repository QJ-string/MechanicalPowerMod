package mechanical;

import arc.util.Log;
import mechanical.content.ModBlocks;
import mechanical.content.ModBullets;
import mechanical.content.ModItems;
import mindustry.mod.Mod;


public class MechanicalPowerMod extends Mod {
    public static ModItems modItems;
    public static ModBullets modBullets;
    public static ModBlocks modBlocks;

    public MechanicalPowerMod() {
        Log.info("Loaded MechanicalPowerMod constructor.");
    }

    @Override
    public void loadContent() {
        Log.info("Loading some tutorial content.");
        modItems = new ModItems();
        modItems.load();
        modBullets = new ModBullets();
        modBullets.load();
        modBlocks = new ModBlocks();
        modBlocks.load();
    }
}