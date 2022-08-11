package net.redcrafter502.crafttechclient.client

class Zoom {
    companion object {
        val zoomLevel: Double = 0.23

        fun isZooming(): Boolean {
            return KeyBindings.zoomKeyBinding.isPressed
        }
    }
}