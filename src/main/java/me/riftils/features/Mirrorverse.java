package me.riftils.features;

import me.riftils.Riftils;
import me.riftils.utils.RenderUtils;
import me.riftils.utils.ScoreboardUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class Mirrorverse {

    private static final ArrayList<Vec3> a = new ArrayList<>(Arrays.asList(
            new Vec3(-82.5, 52.5, -111.5),
            new Vec3(-85.5, 52.5, -111.5),
            new Vec3(-85.5, 52.5, -114.5),
            new Vec3(-87.5, 52.5, -114.5),
            new Vec3(-87.5, 52.5, -109.5),
            new Vec3(-85.5, 52.5, -109.5),
            new Vec3(-85.5, 52.5, -108.5),
            new Vec3(-83.5, 52.5, -108.5),
            new Vec3(-83.5, 52.5, -106.5),
            new Vec3(-89.5, 52.5, -106.5),
            new Vec3(-89.5, 52.5, -107.5),
            new Vec3(-92.5, 52.5, -107.5),
            new Vec3(-92.5, 52.5, -109.5),
            new Vec3(-89.5, 52.5, -109.5),
            new Vec3(-89.5, 52.5, -111.5),
            new Vec3(-91.5, 52.5, -111.5),
            new Vec3(-91.5, 52.5, -113.5),
            new Vec3(-89.5, 52.5, -113.5),
            new Vec3(-89.5, 52.5, -115.5),
            new Vec3(-93.5, 52.5, -115.5),
            new Vec3(-93.5, 52.5, -113.5),
            new Vec3(-95.5, 52.5, -113.5),
            new Vec3(-95.5, 52.5, -115.5),
            new Vec3(-97.5, 52.5, -115.5),
            new Vec3(-97.5, 52.5, -111.5),
            new Vec3(-95.5, 52.5, -111.5),
            new Vec3(-95.5, 52.5, -110.5),
            new Vec3(-94.5, 52.5, -110.5),
            new Vec3(-94.5, 52.5, -107.5),
            new Vec3(-97.5, 52.5, -107.5),
            new Vec3(-97.5, 52.5, -109.5),
            new Vec3(-99.5, 52.5, -109.5),
            new Vec3(-99.5, 52.5, -107.5),
            new Vec3(-101.5, 52.5, -107.5),
            new Vec3(-101.5, 52.5, -111.5),
            new Vec3(-99.5, 52.5, -111.5),
            new Vec3(-99.5, 52.5, -115.5),
            new Vec3(-101.5, 52.5, -115.5),
            new Vec3(-101.5, 52.5, -113.5),
            new Vec3(-103.5, 52.5, -113.5),
            new Vec3(-103.5, 52.5, -111.5),
            new Vec3(-105.5, 52.5, -111.5)
    ));

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (Riftils.inRift && ScoreboardUtils.contains("Mirrorverse") && Riftils.mc.thePlayer != null && Riftils.mc.theWorld != null) {

            // Craft Axe
            if (Riftils.config.mirrorVerseCraftAxe) {
                for (Entity e : Riftils.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(-117, 58, -127, -108, 52, -117))) {
                    if (e instanceof EntityPlayer || e instanceof EntityItemFrame || e instanceof EntityArmorStand) continue;
                    Vec3 v = new Vec3(e.posX, e.posY, -116.5 + (-116.5 - e.posZ));
                    RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(v.xCoord - 0.25, v.yCoord, v.zCoord - 0.25, v.xCoord + 0.25, v.yCoord + 0.5, v.zCoord + 0.25), Riftils.config.mirrorVerseCraftAxeColor, 2, event.partialTicks);
                }
            }

            // Lava
            if (Riftils.config.mirrorVerseLava || Riftils.config.mirrorVerseLavaOriginalBlocks) {
                for (int x = -105; x < -81; x++) {
                    for (int z = -105; z < -94; z++) {
                        if (Riftils.config.mirrorVerseLavaOriginalBlocks) Riftils.mc.theWorld.setBlockState(new BlockPos(x, 51, -106 + (-106 - z)), Riftils.mc.theWorld.getBlockState(new BlockPos(x, 51, z)));
                        if (Riftils.config.mirrorVerseLava && Riftils.mc.theWorld.getBlockState(new BlockPos(x, 51, z)).getBlock() == Blocks.iron_block) {
                            RenderUtils.drawOutlinedBoundingBox(new BlockPos(x, 51, -106 + (-106 - z)), Riftils.config.mirrorVerseLavaColor, 5, event.partialTicks);
                        }
                    }
                }
            }

            // Lava Line
            if (Riftils.config.mirrorVerseLavaLine) {
                for (int i = 1; i < a.size(); i++) {
                    RenderUtils.draw3DLine(a.get(i - 1), a.get(i), Riftils.config.mirrorVerseLavaLineColor, 2, event.partialTicks);
                }
            }

            // Fake Block
            if (Riftils.config.mirrorVerseFakeBlock || Riftils.config.mirrorVerseFakeBlockOriginalBlocks) {
                for (int x = -222; x < -122; x += 4) {
                    for (int z = -125; z < -91; z += 4) {
                        for (int y = 47; y < 57; y++) {
                            if (Riftils.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.planks) {
                                RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(x, 46 + (46 - y), z, x + 2, 46 + (46 - y) + 1, z + 2), Riftils.config.mirrorVerseFakeBlockColor, 5, event.partialTicks);
                            } else {
                                if (Riftils.config.mirrorVerseFakeBlockOriginalBlocks) {
                                    Riftils.mc.theWorld.setBlockToAir(new BlockPos(x, 46 + (46 - y), z));
                                    Riftils.mc.theWorld.setBlockToAir(new BlockPos(x, 46 + (46 - y), z + 1));
                                    Riftils.mc.theWorld.setBlockToAir(new BlockPos(x + 1, 46 + (46 - y), z));
                                    Riftils.mc.theWorld.setBlockToAir(new BlockPos(x + 1, 46 + (46 - y), z + 1));
                                }
                            }
                        }
                    }
                }
            }

            // Jump
            if (Riftils.config.mirrorVerseJump || Riftils.config.mirrorVerseJumpOriginalBlocks) {
                for (int x = -320; x < -310; x++) {
                    for (int y = 1; y < 54; y++) {
                        for (int z = -111; z < -101; z ++) {
                            if (Riftils.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock() != Blocks.planks) continue;
                            if (Riftils.config.mirrorVerseJump) RenderUtils.drawOutlinedBoundingBox(new BlockPos(-310 + (-310 - x), y, z), Riftils.config.mirrorVerseJumpColor, 5, event.partialTicks);
                            if (Riftils.config.mirrorVerseJumpOriginalBlocks) Riftils.mc.theWorld.setBlockState(new BlockPos(-310 + (-310 - x), y, z), Blocks.planks.getDefaultState());
                        }
                    }
                }
            }

        }
    }

}
