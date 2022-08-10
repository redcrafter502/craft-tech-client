package net.redcrafter502.crafttechclient.client

import net.fabricmc.api.EnvType
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.InputUtil
import net.minecraft.client.option.KeyBinding

@Environment(EnvType.CLIENT)
class CrafttechclientClient : ClientModInitializer {

    override fun onInitializeClient() {
        // Key Bindings
        zoomKeyBinding = KeyBinding("key.crafttechclient.zoom", InputUtil.Type.KEYSYM, InputUtil.GLFW_KEY_C, "category.crafttechclient.zoom")
        KeyBindingHelper.registerKeyBinding(zoomKeyBinding)

        // Initialize Zoom Variables
        currentlyZoomed = false
        originalSmoothCameraEnabled = false
    }

    companion object {
        // Key Bindings
        private lateinit var zoomKeyBinding: KeyBinding

        private var currentlyZoomed: Boolean = false
        private var originalSmoothCameraEnabled: Boolean = false
        private val mc: MinecraftClient = MinecraftClient.getInstance()

        val zoomLevel: Double = 0.23

        fun isZooming(): Boolean {
            return zoomKeyBinding.isPressed
        }

        fun manageSmoothCamera() {
            if (zoomStarting()) {
                zoomStarted()
                enableSmoothCamera()
            }
    
            if (zoomStopping()) {
                zoomStopped()
                resetSmoothCamera()
            }
        }

        private fun isSmoothCamera(): Boolean {
            return mc.options.smoothCameraEnabled
        }

        private fun enableSmoothCamera() {
            mc.options.smoothCameraEnabled = true
        }

        private fun disableSmoothCamera() {
            mc.options.smoothCameraEnabled = false
        }

        private fun zoomStarting(): Boolean {
            return isZooming() && !currentlyZoomed
        }

        private fun zoomStopping(): Boolean {
            return !isZooming() && currentlyZoomed
        }

        private fun zoomStarted() {
            originalSmoothCameraEnabled = isSmoothCamera()
            currentlyZoomed = true
        }

        private fun zoomStopped() {
            currentlyZoomed = false
        }

        private fun resetSmoothCamera() {
            if (originalSmoothCameraEnabled) {
                enableSmoothCamera()
            } else {
                disableSmoothCamera()
            }
        }

    }
}