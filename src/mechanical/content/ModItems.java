package mechanical.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class ModItems {
    public static Item
            iron,steel,steelPlate;
    public static void load() {
        iron = new Item("iron", Color.valueOf("666666")) {{
            hardness = 0;
            radioactivity = 0.25f;
            cost = 3.5f;
        }};
        steel = new Item("steel", Color.valueOf("555555")) {{
            radioactivity = 0.3f;
        }};
        steelPlate = new Item("steelPlate", Color.valueOf("444444")) {{
            radioactivity = 0.5f;
        }};

    }
}
