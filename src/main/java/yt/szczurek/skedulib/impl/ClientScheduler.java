package yt.szczurek.skedulib.impl;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public class ClientScheduler extends SyncScheduler<MinecraftClient> {
    private static final ClientScheduler self = new ClientScheduler();

    /**
     * @return Returns the instance of ClientScheduler
     */
    public static ClientScheduler get() {
        return self;
    }

    private ClientScheduler() {}
}
