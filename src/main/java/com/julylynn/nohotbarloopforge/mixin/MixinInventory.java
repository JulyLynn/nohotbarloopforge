package com.julylynn.nohotbarloopforge.mixin;

import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Inventory.class)
public class MixinInventory {
    @Shadow public int selected;
    @Inject(at = @At("HEAD") ,method = "swapPaint(D)V", cancellable = true)
    private void swapPaint(double p_35989_, CallbackInfo ci) {
        int i = (int)Math.signum(p_35989_);

        for(this.selected -= i; this.selected < 0; this.selected += 1) {
        }

        while(this.selected >= 9) {
            this.selected -= 1;
        }
        ci.cancel();

    }
}
