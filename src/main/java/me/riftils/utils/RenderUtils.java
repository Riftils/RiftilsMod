package me.riftils.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RenderUtils {

    public static void drawOutlinedBoundingBox(BlockPos b, Color c, float l, float p) {
        drawOutlinedBoundingBox(new AxisAlignedBB(b, b.add(1, 1, 1)), c, l, p);
    }

    /**
     * Modified from Danker's Skyblock Mod under GPL 3.0 license
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     */
    public static void drawOutlinedBoundingBox(AxisAlignedBB aabb, Color c, float l,float p) {
        Entity e = Minecraft.getMinecraft().getRenderViewEntity();

        double x = e.lastTickPosX + (e.posX - e.lastTickPosX) * p;
        double y = e.lastTickPosY + (e.posY - e.lastTickPosY) * p;
        double z = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * p;

        GlStateManager.disableCull();
        GlStateManager.pushMatrix();
        GlStateManager.translate(-x, -y, -z);
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GL11.glLineWidth(l);

        RenderGlobal.drawOutlinedBoundingBox(aabb, c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());

        GlStateManager.translate(x, y, z);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
        GlStateManager.enableCull();
    }

    /**
     * Modified from Danker's Skyblock Mod under GPL-3.0
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     */
    public static void draw3DLine(Vec3 v1, Vec3 v2, Color c, float l,float p) {
        Entity e = Minecraft.getMinecraft().getRenderViewEntity();
        WorldRenderer r = Tessellator.getInstance().getWorldRenderer();

        double x = e.lastTickPosX + (e.posX - e.lastTickPosX) * p;
        double y = e.lastTickPosY + (e.posY - e.lastTickPosY) * p;
        double z = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * p;

        GlStateManager.pushMatrix();
        GlStateManager.translate(-x, -y, -z);
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GL11.glLineWidth(l);
        GlStateManager.color(c.getRed() / 255f, c.getGreen() / 255f, c.getBlue() / 255f, c.getAlpha() / 255f);
        r.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);

        r.pos(v1.xCoord, v1.yCoord, v1.zCoord).endVertex();
        r.pos(v2.xCoord, v2.yCoord, v2.zCoord).endVertex();
        Tessellator.getInstance().draw();

        GlStateManager.translate(x, y, z);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }

}
