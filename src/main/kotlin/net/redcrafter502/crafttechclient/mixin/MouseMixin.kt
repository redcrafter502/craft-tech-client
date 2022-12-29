package net.redcrafter502.crafttechclient.mixin

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.Mouse
import net.redcrafter502.crafttechclient.client.Zoom
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Environment(EnvType.CLIENT)
@Mixin(Mouse::class)
class MouseMixin {
    @Inject(method = ["onMouseScroll(JDD)V"], at = [At("Return")])
    fun onMouseScroll(long_1: Long, double_1: Double, double_2: Double, callbackInfo: CallbackInfo) {
        Zoom.onMouseScroll(double_2)
    }
}