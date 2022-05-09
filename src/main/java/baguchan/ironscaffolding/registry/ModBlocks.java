package baguchan.ironscaffolding.registry;

import baguchan.ironscaffolding.IronScaffolding;
import baguchan.ironscaffolding.block.IronScaffoldingBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ScaffoldingBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IronScaffolding.MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronScaffolding.MODID);


	public static final RegistryObject<Block> IRON_SCAFFOLDING = register("iron_scaffolding", () -> new IronScaffoldingBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.SAND).strength(2.0F, 10.0F).noCollission().sound(SoundType.NETHERITE_BLOCK).dynamicShape()));

	private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> register = BLOCKS.register(name, block);
		ITEMS.register(name, item.apply(register));
		return register;
	}

	private static <T extends Block> RegistryObject<T> noItemRegister(String name, Supplier<? extends T> block) {
		RegistryObject<T> register = BLOCKS.register(name, block);
		return register;
	}

	private static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends Block> block) {
		return (RegistryObject<B>) baseRegister(name, block, ModBlocks::registerBlockItem);
	}

	private static <T extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<T> block) {
		return () -> {
			if (Objects.requireNonNull(block.get()) instanceof IronScaffoldingBlock) {
				return new ScaffoldingBlockItem(Objects.requireNonNull(block.get()), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
			} else {
				return new BlockItem(Objects.requireNonNull(block.get()), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
			}
		};
	}
}
