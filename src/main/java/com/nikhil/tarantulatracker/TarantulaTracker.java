package com.nikhil.tarantulatracker;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
    modid = "tarantulatracker",
    name = "Tarantula Tracker",
    version = "1.0.0"
)
public class TarantulaTracker {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Tarantula Tracker loaded!");
    }
}
