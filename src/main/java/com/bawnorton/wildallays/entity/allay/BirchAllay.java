package com.bawnorton.wildallays.entity.allay;

import com.bawnorton.wildallays.entity.BiomeAllay;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.world.World;

public class BirchAllay extends BiomeAllay {
    public BirchAllay(EntityType<? extends BiomeAllay> entityType, World world) {
        super(entityType, world);
    }
}
