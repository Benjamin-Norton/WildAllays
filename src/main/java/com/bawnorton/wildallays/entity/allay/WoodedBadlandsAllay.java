package com.bawnorton.wildallays.entity.allay;

import com.bawnorton.wildallays.entity.BiomeAllay;
import com.bawnorton.wildallays.entity.enums.AllayBiome;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.world.World;

public class WoodedBadlandsAllay extends BiomeAllay {
    public WoodedBadlandsAllay(EntityType<? extends AllayEntity> entityType, World world) {
        super(entityType, world);
        biome = AllayBiome.WOODED_BADLANDS;
    }
}
