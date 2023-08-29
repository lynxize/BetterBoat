package dev.lynxize.betterboat.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {

	@Inject(method = "maxUpStep", at = @At("HEAD"), cancellable = true)
	public void maxUpStep(CallbackInfoReturnable<Float> ci) {
		//noinspection ConstantValue
		if (((Object) this) instanceof Boat) {
			ci.setReturnValue(1.0F);
			ci.cancel();
		}
	}
}
