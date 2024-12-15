package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.*;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;

public class DefensiveArtifactStats extends ConfigSection {

    public DefensiveArtifactStats() {
        super();
        this.ENCHANTERS_TOME_STATS = new StatusGrantingArtifactStats(
                100,
                2,
                5f,
                true,
                true,
                64,
                100,
                2,
                1
        );
        this.IRON_HIDE_AMULET_STATS = new StatusGrantingArtifactStats(
                220,
                1,
                true,
                true,
                64,
                500,
                2,
                1
        );
        this.SATCHEL_OF_ELIXIRS_STATS = new ArtifactStats(
                true,
                true,
                64,
                120,
                2,
                1
        );
        this.SATCHEL_OF_SNACKS_STATS = new ArtifactStats(
                true,
                true,
                64,
                120,
                2,
                1
        );
        this.SOUL_HEALER_STATS = new ExperienceDrainingArtifactStats(
                20,
                12,
                0.2f,
                true,
                true,
                64,
                60,
                2,
                1
        );
        this.TOTEM_OF_REGENERATION_STATS = new StatusCloudCreatingArtifactStats(
                5.0f,
                100,
                100,
                100,
                true,
                true,
                64,
                600,
                2,
                1
        );
        this.TOTEM_OF_SHIELDING_STATS = new StatusCloudCreatingArtifactStats(
                5.0f,
                500,
                40,
                0,
                true,
                true,
                64,
                600,
                2,
                1
        );
        this.TOTEM_OF_SOUL_PROTECTION_STATS = new StatusCloudCreatingArtifactStats(
                5.0f,
                500,
                40,
                0,
                true,
                true,
                64,
                600,
                2,
                1
        );
        // Damage for the Wind Horn is the Knockback Multiplier
        this.WIND_HORN_STATS = new DamageArtifactStats(
                5f,
                2.0f,
                true,
                true,
                64,
                250,
                2,
                1
        );
    }
    
    public StatusGrantingArtifactStats ENCHANTERS_TOME_STATS;
    public StatusGrantingArtifactStats IRON_HIDE_AMULET_STATS;
    public ArtifactStats SATCHEL_OF_ELIXIRS_STATS;
    public ArtifactStats SATCHEL_OF_SNACKS_STATS;
    public ExperienceDrainingArtifactStats SOUL_HEALER_STATS;
    public StatusCloudCreatingArtifactStats TOTEM_OF_REGENERATION_STATS;
    public StatusCloudCreatingArtifactStats TOTEM_OF_SHIELDING_STATS;
    public StatusCloudCreatingArtifactStats TOTEM_OF_SOUL_PROTECTION_STATS;
    public DamageArtifactStats WIND_HORN_STATS;
}
