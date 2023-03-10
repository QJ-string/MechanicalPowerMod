package mechanical.components;

import mechanical.entities.expand.blocks.defence.StatedWall;
import mindustry.gen.Building;

public class SharingHealth extends ComponentBase<StatedWall.StatedWallBuild> {
    @Override
    public void onUpdate(StatedWall.StatedWallBuild b) {
        for (Building other : b.proximity) {
            if (other.block != b.block)
                continue;
            float thisH = b.health;
            float otherH = other.health;
            if (thisH > otherH && thisH > 1 && otherH < other.maxHealth){
                other.health += 1;
                b.health -= 1;
            }
        }
    }
}
