package baguchan.ironscaffolding.block;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public enum FluidType implements StringRepresentable {
  EMPTY("empty", Fluids.EMPTY),
  WATER("water", Fluids.WATER),
  LAVA("lava", Fluids.LAVA);
  
  private static final FluidType[] VALUES;
  
  private static final Map<String, FluidType> BY_NAME;
  
  private final String name;
  
  private final Fluid fluid;
  
  static {
    VALUES = values();
    BY_NAME = Arrays.stream(VALUES).collect(Collectors.toMap(FluidType::getName, p_199785_0_ -> p_199785_0_));
  }
  
  FluidType(String p_i49394_3_, Fluid fluid) {
    this.name = p_i49394_3_;
    this.fluid = fluid;
  }
  
  @Nullable
  public static FluidType byName(String p_176717_0_) {
    return BY_NAME.get(p_176717_0_.toLowerCase(Locale.ROOT));
  }
  
  public static FluidType byName(Fluid p_176717_0_) {
    if (p_176717_0_.getRegistryName().toString() != null) {
      FluidType fluidType = BY_NAME.get(p_176717_0_.getRegistryName().toString());
      if (fluidType != null)
        return fluidType; 
      return EMPTY;
    } 
    return EMPTY;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Fluid getFluid() {
    return this.fluid;
  }
  
  public String toString() {
    return this.name;
  }
  @Override
  public String getSerializedName() {
    return this.name;
  }
}
