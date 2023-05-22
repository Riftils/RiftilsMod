package me.riftils.features;

import me.riftils.Riftils;
import me.riftils.utils.Utils;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class BarryCenter {

    private static final ArrayList<String> a = new ArrayList<>(Arrays.asList(
            // Soma
            "[You are in the highest tax bracket, but the tax system is progressive.]",
            //"[You will have to pay 50% of that, so 55,000.]",
            //"[I don't know.]",

            "[They go from 0 to 20k, then to 40k, 70k and finally 100k+.]",
            //"[They go from 0 to 20k, then to 40k, 80k and finally 100k+.]",
            //"[They go from 0 to 10k, then to 30k, 80k and finally 90k+.]",

            "[From first to last they are 10%, 20%, 30%, 40% and 50%.]",
            //"[From first to last they are 15%, 25%, 35%, 45% and 50%.]",
            //"[From first to last they are 30%, 35%, 40%, 45% and 50%.]",

            //"[5,000]",
            //"[26,000]",
            //"[28,000]",
            //"[30,000]",
            "[32,000]",
            //"[34,000]",
            //"[36,000]",
            //"[38,000]",
            //"[40,000]",
            //"[50,000]",
            //"[55,000]",

            // Who is this?????
            //"[3]",
            //"[4]",
            "[5]",

            // Frankie
            "[You might be on a bad proxy.]",
            //"[Are you perhaps using a VPN?]",
            //"[Maybe you are downloading something?]",

            // Harriette
            "[Barry said the Rift Herald is bought and paid for by the mob.]",
            //"[Barry said you shouldn't base your identity on jumping.]",
            //"[Barry said jumping is an affront to gravity.]",

            // Violetta
            "[In 10 years.]",
            //"[In 15 years.]",
            //"[In 12.5 years.]",

            // Creed
            "[Give 300 Motes]",
            //"[Barry says he can't afford 300 Motes, he's poor.]",
            //"[What did the duck say after he went shopping?]",

            // Stain
            "[Berry said that his name is Barry.]",
            //"[Berry said it's not true, he did something in his life. He just can't remember what.]",
            //"[Barry said that at least he's not called Stain.]",

            // Dust
            "[Patience comes to those who wait.]"
            //"[The secret to life is good dental hygiene.]",
            //"[Something smart.]"
    ));

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        if (Riftils.config.barryCenterSolver && Riftils.inRift) {
            for (String s : a) {
                if (event.message.getFormattedText().contains(s)) {
                   Utils.addChat("[Riftils] " + EnumChatFormatting.GREEN + s);
                }
            }
        }
    }

}
