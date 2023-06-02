package me.riftils.features;

import me.riftils.Riftils;
import me.riftils.utils.Utils;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BarryCenter {

    private final String[] s = {
            "[You are in the highest tax bracket, but the tax system is progressive.]",
            "[They go from 0 to 20k, then to 40k, 70k and finally 100k+.]",
            "[From first to last they are 10%, 20%, 30%, 40% and 50%.]",
            "[32,000]",
            "[5]",
            "[You might be on a bad proxy.]",
            "[Barry said the Rift Herald is bought and paid for by the mob.]",
            "[In 10 years.]",
            "[Give 300 Motes]",
            "[Berry said that his name is Barry.]",
            "[Patience comes to those who wait.]"
    };

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        if (Riftils.config.barryCenterSolver && Riftils.inRift) {
            for (String s : s) {
                if (event.message.getFormattedText().contains(s)) {
                   Utils.addChat("[Riftils] " + EnumChatFormatting.GREEN + s);
                }
            }
        }
    }

}
