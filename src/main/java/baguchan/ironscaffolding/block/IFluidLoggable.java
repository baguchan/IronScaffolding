package baguchan.ironscaffolding.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import java.util.Optional;

public interface IFluidLoggable extends SimpleWaterloggedBlock {
	default boolean canPlaceLiquid(BlockGetter p_56301_, BlockPos p_56302_, BlockState p_56303_, Fluid p_56304_) {
		return p_56303_.hasProperty(ModBlockStateProperties.FLUID) && p_56304_ != Fluids.EMPTY;
	}

	default boolean placeLiquid(LevelAccessor p_56306_, BlockPos p_56307_, BlockState p_56308_, FluidState p_56309_) {
		if (p_56308_.hasProperty(ModBlockStateProperties.FLUID) && p_56309_.getType() != Fluids.EMPTY) {
			if (!p_56306_.isClientSide()) {
				FluidType fluidType = FluidType.byName(p_56309_.getType());
				if (fluidType != null) {
					p_56306_.setBlock(p_56307_, p_56308_.setValue(ModBlockStateProperties.FLUID, fluidType), 3);
					p_56306_.getLiquidTicks().scheduleTick(p_56307_, p_56309_.getType(), p_56309_.getType().getTickDelay(p_56306_));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	default ItemStack pickupBlock(LevelAccessor p_154560_, BlockPos p_154561_, BlockState p_154562_) {
		if (p_154562_.hasProperty(ModBlockStateProperties.FLUID)) {
			FluidType fluidType = p_154562_.getValue(ModBlockStateProperties.FLUID);
			p_154560_.setBlock(p_154561_, p_154562_.setValue(ModBlockStateProperties.FLUID, FluidType.EMPTY), 3);
			if (!p_154562_.canSurvive(p_154560_, p_154561_)) {
				p_154560_.destroyBlock(p_154561_, true);
			}

			return new ItemStack(fluidType.getFluid().getBucket());
		} else {
			return ItemStack.EMPTY;
		}
	}

	default Optional<SoundEvent> getPickupSound() {
		return Fluids.WATER.getPickupSound();
	}
}
