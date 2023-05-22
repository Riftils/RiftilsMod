package me.riftils.utils;

import me.riftils.Riftils;
import net.minecraft.util.ChatComponentText;

public class Utils {

    public static void addChat(String s) {
        Riftils.mc.thePlayer.addChatMessage(new ChatComponentText(s));
    }

}
