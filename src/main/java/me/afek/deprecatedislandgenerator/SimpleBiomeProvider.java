package me.afek.deprecatedislandgenerator;

import com.google.common.collect.Lists;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.util.noise.SimplexOctaveGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class SimpleBiomeProvider extends BiomeProvider {

    @NotNull
    @Override
    public Biome getBiome(@NotNull WorldInfo worldInfo, int x, int y, int z) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(worldInfo.getSeed()), 6);
        generator.setScale(0.01);


        if (generator.noise(x, z, 1, 1, true) < 0)
            return Biome.OCEAN;

        return Biome.MOUNTAINS;
    }

    @NotNull
    @Override
    public List<Biome> getBiomes(@NotNull WorldInfo worldInfo) {
        return Lists.newArrayList(Biome.OCEAN, Biome.MOUNTAINS);
    }
}