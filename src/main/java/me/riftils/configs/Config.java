package me.riftils.configs;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.awt.*;
import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.SWITCH,
            name = "Item Need Warning",
            description = "best feature",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseRequiredItems = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Craft Axe Solver",
            description = "Render entities in mirror",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseCraftAxe = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Craft Axe Solver Color",
            description = "Render entities in mirror color",
            category = "Mirrorverse"
    )
    public Color mirrorVerseCraftAxeColor = Color.WHITE;

    @Property(
            type = PropertyType.SWITCH,
            name = "Lava Solver",
            description = "Render outlines on real stone",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseLava = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Lava Solver Color",
            description = "Render outlines on real stone color",
            category = "Mirrorverse"
    )
    public Color mirrorVerseLavaColor = Color.WHITE;

    @Property(
            type = PropertyType.SWITCH,
            name = "Lava Solver (Line)",
            description = "Render lines on stone path",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseLavaLine = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Lava Solver (Line) Color",
            description = "Render lines on stone path color",
            category = "Mirrorverse"
    )
    public Color mirrorVerseLavaLineColor = Color.WHITE;

    @Property(
            type = PropertyType.SWITCH,
            name = "Lava Original Blocks",
            description = "Render lava and iron blocks instead of stones",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseLavaOriginalBlocks = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Fake Block Solver",
            description = "Render outlines on real blocks",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseFakeBlock = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Fake Block Color",
            description = "Render outlines on real blocks color",
            category = "Mirrorverse"
    )
    public Color mirrorVerseFakeBlockColor = Color.WHITE;

    @Property(
            type = PropertyType.SWITCH,
            name = "Hide Fake Blocks",
            description = "Hide fake blocks",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseFakeBlockOriginalBlocks = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Jump Solver",
            description = "Render outlines on invisible blocks",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseJump = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Jump Color",
            description = "Render outlines on invisible blocks color",
            category = "Mirrorverse"
    )
    public Color mirrorVerseJumpColor = Color.WHITE;

    @Property(
            type = PropertyType.SWITCH,
            name = "Show Hidden Jump Blocks",
            description = "Render oak wood planks",
            category = "Mirrorverse"
    )
    public boolean mirrorVerseJumpOriginalBlocks = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Render Red Mushroom Outline",
            description = "§cTrash",
            category = "Dreadfarm"
    )
    public boolean dreadFarmRedMushroom = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Render Red Mushroom Outline Color",
            description = "§cTrash color",
            category = "Dreadfarm"
    )
    public Color dreadFarmRedMushroomColor = Color.RED;

    @Property(
            type = PropertyType.SWITCH,
            name = "Barry Center Solver",
            description = "Show real answer",
            category = "Village Plaza"
    )
    public boolean barryCenterSolver = false;

    public Config() {
        super(new File("./config/riftils.toml"));
        initialize();
    }

}
