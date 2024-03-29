package net.redcrafter502.crafttechclient.mixin

import net.redcrafter502.crafttechclient.client.Zoom

import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment

import net.minecraft.client.render.GameRenderer

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer::class)
class GameRendererMixin {

    @Inject(method = ["getFov(Lnet/minecraft/client/render/Camera;FZ)D"], at = [At("RETURN")], cancellable = true)
    fun getZoomLevel(callbackInfo: CallbackInfoReturnable<Double>) {
        callbackInfo.returnValue = Zoom.changeFovBasedOnZoom(callbackInfo.returnValue)
    }
}