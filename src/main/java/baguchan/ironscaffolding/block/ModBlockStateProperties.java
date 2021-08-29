package baguchan.ironscaffolding.block;

import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ModBlockStateProperties {
  public static final EnumProperty<FluidType> FLUID = EnumProperty.create("fluid_type", FluidType.class);
}
