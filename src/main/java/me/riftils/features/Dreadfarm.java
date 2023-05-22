package me.riftils.features;

import me.riftils.Riftils;
import me.riftils.utils.RenderUtils;
import me.riftils.utils.ScoreboardUtils;
import net.minecraft.init.Blocks;
import net.minecraft.util.*;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Dreadfarm {

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (Riftils.inRift && ScoreboardUtils.contains("Dreadfarm") && Riftils.mc.thePlayer != null && Riftils.mc.theWorld != null) {
            if (Riftils.config.dreadFarmRedMushroom) {
                MovingObjectPosition m = Riftils.mc.thePlayer.rayTrace(Riftils.mc.playerController.getBlockReachDistance(), event.partialTicks);
                if (Riftils.mc.theWorld.getBlockState(m.getBlockPos()).getBlock() == Blocks.red_mushroom) {
                    RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(m.getBlockPos(), m.getBlockPos().add(1, 1, 1)), Riftils.config.dreadFarmRedMushroomColor, 3, event.partialTicks);
                }
            }
        }
    }

}
