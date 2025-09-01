package net.harmoniya.customisation;

import net.harmoniya.customisation.render.layers.BaseArmorLayer;
import net.harmoniya.customisation.render.model.models.NakidkaLayerModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Customisation.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(NakidkaLayerModel.LAYER_LOCATION, NakidkaLayerModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void addRenderLayers(EntityRenderersEvent.AddLayers event) {
		addLayerToPlayerSkin(event, "default");
		addLayerToPlayerSkin(event, "slim");
	}

	private static void addLayerToPlayerSkin(EntityRenderersEvent.AddLayers event, String skinName) {
		LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer = event.getSkin(skinName);

		if (renderer != null) {
			renderer.addLayer(new BaseArmorLayer<>(renderer, event.getEntityModels()));
		}
	}
}
