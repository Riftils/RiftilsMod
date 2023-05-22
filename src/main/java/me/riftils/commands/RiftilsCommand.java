package me.riftils.commands;

import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;
import me.riftils.Riftils;

public class RiftilsCommand extends Command {

    public RiftilsCommand() {
        super("riftils");
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(Riftils.config.gui());
    }

}
