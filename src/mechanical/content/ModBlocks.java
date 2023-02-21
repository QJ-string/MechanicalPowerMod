package mechanical.content;

import arc.graphics.Color;
import mechanical.entities.expand.blocks.defence.StatedWall;
import mechanical.components.SharingHealth;
import mechanical.entities.expand.blocks.turrets.PowerOrbTurret;
import mechanical.entities.expand.bullets.PowerOrb;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class ModBlocks {
    public static StatedWall ironWall;
    public static GenericCrafter steelSmelter,steelPlateSmelter;
    public static PowerOrbTurret PowerOrbTurret;


    public static SharingHealth sharingHealth = new SharingHealth();


    public void load() {
        ironWall = new StatedWall("iron-wall") {{
            requirements(Category.defense, BuildVisibility.shown, new ItemStack[]{
            });
            health = 500;
            size = 1;
            buildCostMultiplier = 2f;
            stateNumber = 4;
            update = true;
            components.add(sharingHealth);
        }};
        steelSmelter = new GenericCrafter("steel-smelter") {{
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(ModItems.iron, 30),
                    new ItemStack(Items.copper, 30),
                    new ItemStack(Items.lead, 25)
            });
            outputItem = new ItemStack(ModItems.steel, 1);
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            hasShadow = false;
            craftEffect = Fx.smeltsmoke;
            craftTime = 40f;
            size = 2;
            hasItems = true;
            consumeItems(with(Items.coal, 1, ModItems.iron, 2));
            hasPower = true;
            hasLiquids = false;
            consumePower(0.50f);
        }};
        steelPlateSmelter = new GenericCrafter("steel-plate-smelter") {{
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(ModItems.steel, 30),
                    new ItemStack(Items.copper, 30),
                    new ItemStack(Items.silicon, 30),
                    new ItemStack(Items.lead, 25)
            });
            outputItem = new ItemStack(ModItems.steelPlate, 1);
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            hasShadow = false;
            craftEffect = Fx.smeltsmoke;
            craftTime = 40f;
            size = 2;
            hasItems = true;
            consumeItem(ModItems.steel, 2);
            hasPower = true;
            hasLiquids = false;
            consumePower(0.7f);
        }};
        PowerOrbTurret = new PowerOrbTurret("power-orb-turret") {{
            requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30));
            range = 300f;

            shoot.firstShotDelay = 40f;

            recoil = 2f;
            reload = 80f;
            shake = 2f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            size = 4;
            health = 1300;
            scaledHealth = 280;
            targetAir = false;
            moveWhileCharging = false;
            accurateDelay = false;
            shootSound = Sounds.laser;
            coolant = consumeCoolant(0.2f);

            consumePower(12f);

            shootType = new PowerOrb(){{
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);

                buildingDamageMultiplier = 1.25f;
                status = StatusEffects.shocked;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 110f;
                drawSize = 400f;
                collidesAir = false;
                ammoMultiplier = 1f;
                pierceCap = 4;
            }};
        }};
    }
}
