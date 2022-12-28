package net.redcrafter502.crafttechclient.mixin

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.entity.player.PlayerInventory
import net.redcrafter502.crafttechclient.client.KeyBindings
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Environment(EnvType.CLIENT)
@Mixin(PlayerInventory::class)
class PlayerInventoryMixin {
    @Inject(method = ["scrollInHotbar(D)V"], at = [At("HEAD")], cancellable = true)
    fun onScrollInHotbar(scrollAmount: Double, ci: CallbackInfo) {
        if (KeyBindings.zoomKeyBinding.isPressed) {
            println("ho")
            ci.cancel()
        }
    }
}