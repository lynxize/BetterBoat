package io.github.snowdriftdev.betterboat.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@Shadow
	private float maxUpStep;

	// stupid mandated doc

	/**
	 * @author Snowdrift_
	 * @reason Easiest way to accomplish this,
	 * and I can't think of any reasons anyone else would want to mixin here
	 */
	@Overwrite
	public float maxUpStep() {
		if (((Object) this) instanceof Boat)
			return 1.0F;
		else return maxUpStep;
	}
}
