package net.istar.sandsword.world.dimension;

import net.istar.sandsword.SandSword;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> ARBORDIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(SandSword.MOD_ID, "arboreal_haven_dimension"));
    public static final RegistryKey<World> ARBORDIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(SandSword.MOD_ID, "arboreal_haven_dimension"));
    public static final RegistryKey<DimensionType> ARBOR_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(SandSword.MOD_ID, "arbor_type"));
    public static final RegistryKey<DimensionOptions> SHADOWDIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(SandSword.MOD_ID, "shadow_land_dimension"));
    public static final RegistryKey<World> SHADOWDIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(SandSword.MOD_ID, "shadow_land_dimension"));
    public static final RegistryKey<DimensionType> SHADOW_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(SandSword.MOD_ID, "shadow_land_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(ARBOR_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
        context.register(SHADOW_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }

}