package yt.szczurek.skedulib.impl;

import net.minecraft.server.MinecraftServer;

public class ServerScheduler extends SyncScheduler<MinecraftServer> {
    private static final ServerScheduler self = new ServerScheduler();

    /**
     * @return Returns the instance of ServerScheduler
     */
    public static ServerScheduler get() {
        return self;
    }

    private ServerScheduler() {}
}
