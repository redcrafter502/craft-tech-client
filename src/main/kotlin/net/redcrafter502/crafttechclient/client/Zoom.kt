package net.redcrafter502.crafttechclient.client

import net.minecraft.util.math.MathHelper

class Zoom {
    companion object {
        private const val defaultLevel: Double = 3.0
        private var currentLevel: Double? = null

        fun isZooming(): Boolean {
            return KeyBindings.zoomKeyBinding.isPressed
        }

        fun changeFovBasedOnZoom(fov: Double): Double {
            if (currentLevel == null) {
                currentLevel = defaultLevel
            }

            if (!isZooming()) {
                currentLevel = defaultLevel
                return fov
            }

            return fov / currentLevel!!
        }

        fun onMouseScroll(amount: Double) {
            if (!isZooming()) {
                return
            }

            if (currentLevel == null) {
                currentLevel = defaultLevel
            }

            if (amount > 0) {
                currentLevel = currentLevel!! * 1.1
            } else if (amount < 0) {
                currentLevel = currentLevel!! * 0.9
            }
            currentLevel = MathHelper.clamp(currentLevel!!, 1.0, 50.0)
        }

    }
}