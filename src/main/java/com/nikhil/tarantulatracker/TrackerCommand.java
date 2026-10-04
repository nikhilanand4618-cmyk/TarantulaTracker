package com.nikhil.tarantulatracker;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class TrackerCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "tracker";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/tracker [toggle|reset]";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if (args.length == 0 || args[0].equalsIgnoreCase("toggle")) {
            TarantulaTracker.toggleTracker();
            return;
        }

        if (args[0].equalsIgnoreCase("reset")) {
            TarantulaTracker.resetTracker();

            sender.addChatMessage(
                new ChatComponentText(
                    "§5[Tarantula Tracker] §aTracker reset!"
                )
            );
            return;
        }

        sender.addChatMessage(
            new ChatComponentText(
                "§5[Tarantula Tracker] §fUse §e/tracker §for §atoggle §for §e/tracker reset"
            )
        );
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
