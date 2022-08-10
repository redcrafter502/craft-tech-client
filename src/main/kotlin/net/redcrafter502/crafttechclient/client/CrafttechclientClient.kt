package net.redcrafter502.crafttechclient.client

import net.fabricmc.api.EnvType
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.Environment

@Environment(EnvType.CLIENT)
class CrafttechclientClient : ClientModInitializer {

    override fun onInitializeClient() {
        // Initialize Key Bindings
        KeyBindings.initialize()
    }
}