package com.bawnorton.wildallays.registry;

import com.bawnorton.wildallays.WildAllays;
import com.bawnorton.wildallays.config.ConfigManager;
import com.bawnorton.wildallays.entity.BiomeAllay;
import com.bawnorton.wildallays.entity.allay.*;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;


public class Entities {
    public static final EntityType<? extends BiomeAllay> LOST_ALLAY = register("lost_allay", LostAllay::new);
    public static final EntityType<? extends BiomeAllay> BIRCH_ALLAY = register("birch_allay", BirchAllay::new);
    public static final EntityType<? extends BiomeAllay> CRIMSON_ALLAY = register("crimson_allay", CrimsonAllay::new);
    public static final EntityType<? extends BiomeAllay> DARK_ALLAY = register("dark_allay", DarkAllay::new);
    public static final EntityType<? extends BiomeAllay> END_ALLAY = register("end_allay", EndAllay::new);
    public static final EntityType<? extends BiomeAllay> FLOWER_ALLAY = register("flower_allay", FlowerAllay::new);
    public static final EntityType<? extends BiomeAllay> FOREST_ALLAY = register("forest_allay", ForestAllay::new);
    public static final EntityType<? extends BiomeAllay> JUNGLE_ALLAY = register("jungle_allay", JungleAllay::new);
    public static final EntityType<? extends BiomeAllay> LUSH_ALLAY = register("lush_allay", LushAllay::new);
    public static final EntityType<? extends BiomeAllay> PLAINS_ALLAY = register("plains_allay", PlainsAllay::new);
    public static final EntityType<? extends BiomeAllay> SAVANNA_ALLAY = register("savanna_allay", SavannaAllay::new);
    public static final EntityType<? extends BiomeAllay> SWAMP_ALLAY = register("swamp_allay", SwampAllay::new);
    public static final EntityType<? extends BiomeAllay> TAIGA_ALLAY = register("taiga_allay", TaigaAllay::new);
    public static final EntityType<? extends BiomeAllay> WARPED_ALLAY = register("warped_allay", WarpedAllay::new);
    public static final EntityType<? extends BiomeAllay> WOODED_BADLANDS_ALLAY = register("wooded_badlands_allay", WoodedBadlandsAllay::new);

    private static <T extends BiomeAllay> EntityType<T> register(String id, EntityType.EntityFactory<T> initialiser) {
        return Registry.register(Registry.ENTITY_TYPE, "%s:%s".formatted(WildAllays.MODID, id), FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, initialiser)
                        .dimensions(EntityDimensions.fixed(0.6F, 0.6F))
                        .build());
    }

    public static void register() {
        for(BiomeAllay.Type allay: BiomeAllay.Type.values()) {
            FabricDefaultAttributeRegistry.register(allay.entityType, BiomeAllay.createAllayAttributes());
            for(BiomeAllay.Biome biome: allay.biomes) {
                if(biome.enabled) {
                    BiomeModifications.addSpawn(biome.getContext(), SpawnGroup.MONSTER, allay.entityType, ConfigManager.get("allay_spawn_weight", Integer.class), 1, 1);
                }
            }
        }
    }
}
