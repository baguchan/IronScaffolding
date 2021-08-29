package baguchan.ironscaffolding.registry;

import baguchan.ironscaffolding.IronScaffolding;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = IronScaffolding.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModItems {
	public static void register(RegistryEvent.Register<Item> registry, Item item, String id) {
		if (item instanceof BlockItem)
			Item.BY_BLOCK.put(((BlockItem) item).getBlock(), item);
		item.setRegistryName(new ResourceLocation(IronScaffolding.MODID, id));
		registry.getRegistry().register(item);
	}

	public static void register(RegistryEvent.Register<Item> registry, Item item) {
		if (item instanceof BlockItem && item.getRegistryName() == null) {
			item.setRegistryName(((BlockItem) item).getBlock().getRegistryName());
			Item.BY_BLOCK.put(((BlockItem) item).getBlock(), item);
		}
		registry.getRegistry().register(item);
	}
}
