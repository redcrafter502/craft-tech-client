package net.redcrafter502.crafttechclient.client

import net.fabricmc.api.EnvType
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient

@Environment(EnvType.CLIENT)
class CrafttechclientClient : ClientModInitializer {

    override fun onInitializeClient() {
        // Initialize Key Bindings
        KeyBindings.initialize()
    }

    companion object {
        private var currentlyZoomed: Boolean = false
        private var originalSmoothCameraEnabled: Boolean = false
        private val mc: MinecraftClient = MinecraftClient.getInstance()

        val zoomLevel: Double = 0.23

        fun isZooming(): Boolean {
            return KeyBindings.zoomKeyBinding.isPressed
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