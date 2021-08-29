package baguchan.ironscaffolding.registry;

import baguchan.ironscaffolding.IronScaffolding;
import baguchan.ironscaffolding.block.IronScaffoldingBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ScaffoldingBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = IronScaffolding.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModBlocks {
  public static final Block IRON_SCAFFOLDING = new IronScaffoldingBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.SAND).strength(2.0F, 10.0F).noCollission().sound(SoundType.NETHERITE_BLOCK).dynamicShape());

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> registry) {
    registry.getRegistry().register(IRON_SCAFFOLDING.setRegistryName("iron_scaffolding"));
  }

  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> registry) {
    ModItems.register(registry, new ScaffoldingBlockItem(IRON_SCAFFOLDING, (new Item.Properties()).tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));
  }
}
