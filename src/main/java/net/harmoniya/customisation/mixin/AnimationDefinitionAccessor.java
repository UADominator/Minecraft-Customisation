package net.harmoniya.customisation.mixin;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import java.util.Map;

@Mixin(AnimationDefinition.class)
public interface AnimationDefinitionAccessor {
	@Accessor("boneAnimations")
	Map<String, List<AnimationChannel>> getAnimationByBone();

	@Accessor("lengthInSeconds")
	float getLength();

	@Accessor("looping")
	boolean isLooping();
}