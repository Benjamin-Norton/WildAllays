package com.bawnorton.wildallays.entity.allay;

import com.bawnorton.wildallays.entity.BiomeAllay;
import com.bawnorton.wildallays.util.Colour;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrimsonAllay extends BiomeAllay {
    public CrimsonAllay(EntityType<? extends BiomeAllay> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected boolean checkSurface(BlockPos pos) {
        return true;
    }

    @Override
    protected boolean checkDarkness(BlockPos pos) {
        return true;
    }

    @Override
    protected boolean randFailure() {
        return this.random.nextInt(100) == 0;
    }
}
