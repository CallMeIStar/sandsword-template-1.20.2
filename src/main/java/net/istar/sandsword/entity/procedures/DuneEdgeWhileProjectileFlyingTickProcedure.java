package net.istar.sandsword.entity.procedures;

import net.minecraft.block.Blocks;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.WorldAccess;

public class DuneEdgeWhileProjectileFlyingTickProcedure {
    public static void execute(WorldAccess world, double x, double y, double z) {

        // Create the particle option for falling sand
        ParticleEffect fallingSand = new BlockStateParticleEffect(ParticleTypes.FALLING_DUST, Blocks.SAND.getDefaultState());

        // Summon the particles
        world.addParticle(fallingSand, x, y, z, 0, 0.1, 0);  // Correct argument order
    }
}
