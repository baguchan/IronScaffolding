package baguchan.ironscaffolding.client;

import baguchan.ironscaffolding.registry.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@OnlyIn(Dist.CLIENT)
public class ClientRegistrar {
	public static void setup(FMLCommonSetupEvent event) {
		setRenderLayer(ModBlocks.IRON_SCAFFOLDING, RenderType.cutout());
	}

	private static void setRenderLayer(Block block, RenderType type) {
		ItemBlockRenderTypes.setRenderLayer(block, type::equals);
	}

	private static void setRenderLayer(Fluid fluid, RenderType type) {
		ItemBlockRenderTypes.setRenderLayer(fluid, type::equals);
	}
}
