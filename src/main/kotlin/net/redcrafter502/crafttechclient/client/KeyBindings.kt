package net.redcrafter502.crafttechclient.client

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil

class KeyBindings {
    companion object {
        // Key Bindings
        lateinit var zoomKeyBinding: KeyBinding

        // Initialize Key Bindings
        fun initialize() {
            // Zoom Key Binding
            zoomKeyBinding = KeyBinding("key.crafttechclient.zoom", InputUtil.Type.KEYSYM, InputUtil.GLFW_KEY_C, "category.crafttechclient.zoom")
            KeyBindingHelper.registerKeyBinding(zoomKeyBinding)
        }
    }
}