package me.earth.earthhack.impl;

import me.earth.earthhack.impl.core.ducks.IMinecraftClient;
import me.earth.earthhack.impl.managers.Managers;
import me.earth.earthhack.impl.managers.thread.GlobalExecutor;
import me.earth.earthhack.impl.modules.client.commands.Commands;
import me.earth.earthhack.impl.util.math.geocache.Sphere;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static me.earth.earthhack.api.util.interfaces.Globals.mc;

public class Earthhack implements ClientModInitializer {

    private static final Logger LOGGER = LogManager.getLogger("Sh4doWWare");
    public static final String NAME = "Sh4doWWare";
    public static final String VERSION = "(alpha 0.0.1)";
    public static long startMS;

    @Override
    public void onInitializeClient() {
        startMS = System.currentTimeMillis();
        GlobalExecutor.EXECUTOR.submit(() -> Sphere.cacheSphere(LOGGER));
        LOGGER.info("\n\n ------------------ Initializing Sh4doWWare. ------------------ \n");
        Managers.load();
        LOGGER.info("Prefix is " + Commands.getPrefix());
        LOGGER.info("\n\n ------------------ Sh4doWWare initialized. ------------------ \n");
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static boolean isRunning()
    {
        return ((IMinecraftClient) mc).earthhack$isRunning();
    }
}
