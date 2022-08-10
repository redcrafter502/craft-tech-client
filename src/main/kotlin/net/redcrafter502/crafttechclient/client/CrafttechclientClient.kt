package net.redcrafter502.crafttechclient.client

import net.fabricmc.api.EnvType
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.api.Environment
import net.minecraft.client.util.InputUtil
import net.minecraft.client.option.KeyBinding

@Environment(EnvType.CLIENT)
class CrafttechclientClient : ClientModInitializer {
    private lateinit var zoomKeyBinding: KeyBinding

    override fun onInitializeClient() {
        // Key Bindings
        zoomKeyBinding = KeyBinding("key.crafttechclient.zoom", InputUtil.Type.KEYSYM, InputUtil.GLFW_KEY_C, "category.crafttechclient.zoom")
        KeyBindingHelper.registerKeyBinding(zoomKeyBinding)
    }
}