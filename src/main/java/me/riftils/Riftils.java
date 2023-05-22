package me.riftils;

import me.riftils.commands.RiftilsCommand;
import me.riftils.configs.Config;
import me.riftils.features.BarryCenter;
import me.riftils.features.Dreadfarm;
import me.riftils.features.Mirrorverse;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Collection;

@Mod(modid = Riftils.ID, name = Riftils.NAME, version = Riftils.VERSION)
public class Riftils {

    public static final String ID = "riftils";
    public static final String NAME = "Riftils";
    public static final String VERSION = "0.0.0.alpha";
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static boolean inRift = false;
    public static Config config;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        config = new Config();
        config.preload();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Mirrorverse());
        MinecraftForge.EVENT_BUS.register(new Dreadfarm());
        MinecraftForge.EVENT_BUS.register(new BarryCenter());

        new RiftilsCommand().register();
    }

    private int t = 0;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (t % 20 == 0) {
            if (mc.thePlayer != null && mc.theWorld != null) {
                ScoreObjective s = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
                if (s != null) {
                    Collection<NetworkPlayerInfo> c = mc.getNetHandler().getPlayerInfoMap();
                    for (NetworkPlayerInfo n : c) {
                        if (n == null || n.getDisplayName() == null) continue;
                        if (n.getDisplayName().getUnformattedText().startsWith("Area: ")) {
                            inRift = n.getDisplayName().getUnformattedText().contains("The Rift");
                        }
                    }
                }
            }
        }
        t++;
    }

}
