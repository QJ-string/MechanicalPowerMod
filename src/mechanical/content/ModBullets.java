package mechanical.content;

import mechanical.entities.expand.bullets.PowerOrb;
import mindustry.content.Fx;

public class ModBullets {
    public static PowerOrb powerOrb;


    public void load() {

            powerOrb = new PowerOrb(3.5f, 20f){{
                lifetime = 300f;
                hitEffect = Fx.none;
                despawnEffect = Fx.none;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
            }};
    }
}
