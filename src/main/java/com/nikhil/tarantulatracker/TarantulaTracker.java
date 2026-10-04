package com.nikhil.tarantulatracker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
        modid = "tarantulatracker",
        name = "Tarantula Tracker",
        version = "1.0.0",
        clientSideOnly = true
)
public class TarantulaTracker {

    private static boolean enabled = true;

    private static int totalDrops = 0;
    private static int rareDrops = 0;
    private static int veryRareDrops = 0;
    private static int crazyRareDrops = 0;
    private static int insaneDrops = 0;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

        ClientCommandHandler.instance.registerCommand(
                new TrackerCommand()
        );

        System.out.println("Tarantula Tracker loaded!");
    }

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent.Text event) {
        if (!enabled) {
            return;
        }

        Minecraft mc = Minecraft.getMinecraft();

        if (mc.thePlayer == null) {
            return;
        }

        FontRenderer font = mc.fontRendererObj;

        int x = 10;
        int y = 10;

        font.drawStringWithShadow(
                "§5§lTarantula Tracker",
                x,
                y,
                0xFFFFFF
        );

        font.drawStringWithShadow(
                "§fTotal Drops: §e" + totalDrops,
                x,
                y + 12,
                0xFFFFFF
        );

        font.drawStringWithShadow(
                "§fRare: §a" + rareDrops,
                x,
                y + 24,
                0xFFFFFF
        );

        font.drawStringWithShadow(
                "§fVery Rare: §b" + veryRareDrops,
                x,
                y + 36,
                0xFFFFFF
        );

        font.drawStringWithShadow(
                "§fCrazy Rare: §d" + crazyRareDrops,
                x,
                y + 48,
                0xFFFFFF
        );

        font.drawStringWithShadow(
                "§fInsane: §c" + insaneDrops,
                x,
                y + 60,
                0xFFFFFF
        );
    }

    public static void toggleTracker() {
        enabled = !enabled;

        Minecraft mc = Minecraft.getMinecraft();

        if (mc.thePlayer != null) {
            mc.thePlayer.addChatMessage(
                    new ChatComponentText(
                            "§5[Tarantula Tracker] §f" +
                            (enabled ? "§aEnabled" : "§cDisabled")
                    )
            );
        }
    }

    public static void resetTracker() {
        totalDrops = 0;
        rareDrops = 0;
        veryRareDrops = 0;
        crazyRareDrops = 0;
        insaneDrops = 0;
    }
}
