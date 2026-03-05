package com.betternpchighlightrevamped.managers;

import java.awt.Color;
import java.util.Random;

import javax.inject.Inject;

import com.betternpchighlightrevamped.BetterNpcHighlightConfig;
import com.betternpchighlightrevamped.data.NPCInfo;
import com.betternpchighlightrevamped.data.NameAndIdContainer;

import net.runelite.api.Client;
import net.runelite.client.util.WildcardMatcher;

public class ColorManager {
  @Inject
  private Client client;

  @Inject
  private BetterNpcHighlightConfig config;

  @Inject
  private NameAndIdContainer nameAndIdContainer;

  /**
   * Color of the NPC in the list Used for Minimap dot and displayed names
   *
   * @return Color
   */
  public Color getSpecificColor(NPCInfo n) {
    if (n.isTask() && config.slayerHighlight())
    {
      return config.slayerRave() ? getRaveColor(config.slayerRaveSpeed()) : config.taskColor();
    }
    else if (n.getTile().isHighlight() && config.tileHighlight())
    {
      return config.tileRave() ? getRaveColor(config.tileRaveSpeed()) : n.getTile().getColor();
    }
    else if (n.getTrueTile().isHighlight() && config.trueTileHighlight())
    {
      return config.trueTileRave() ? getRaveColor(config.trueTileRaveSpeed()) : n.getTrueTile().getColor();
    }
    else if (n.getSwTile().isHighlight() && config.swTileHighlight())
    {
      return config.swTileRave() ? getRaveColor(config.swTileRaveSpeed()) : n.getSwTile().getColor();
    }
    else if (n.getSwTrueTile().isHighlight() && config.swTrueTileHighlight())
    {
      return config.swTrueTileRave() ? getRaveColor(config.swTrueTileRaveSpeed()) : n.getSwTrueTile().getColor();
    }
    else if (n.getHull().isHighlight() && config.hullHighlight())
    {
      return config.hullRave() ? getRaveColor(config.hullRaveSpeed()) : n.getHull().getColor();
    }
    else if (n.getArea().isHighlight() && config.areaHighlight())
    {
      return config.areaRave() ? getRaveColor(config.areaRaveSpeed()) : n.getArea().getColor();
    }
    else if (n.getOutline().isHighlight() && config.outlineHighlight())
    {
      return config.outlineRave() ? getRaveColor(config.outlineRaveSpeed()) : n.getOutline().getColor();
    }
    else if (n.getClickbox().isHighlight() && config.clickboxHighlight())
    {
      return config.clickboxRave() ? getRaveColor(config.clickboxRaveSpeed()) : n.getClickbox().getColor();
    }
    else
    {
      return null;
    }
  }

  /**
   * Returns color of either the config or a preset if selected
   *
   * @return Color
   */
  public Color getHighlightColor(String preset, Color color) {
    switch (preset) {
    case "1":
      return config.presetColor1();
    case "2":
      return config.presetColor2();
    case "3":
      return config.presetColor3();
    case "4":
      return config.presetColor4();
    case "5":
      return config.presetColor5();
    case "6":
      return config.presetColor6();
    case "7":
      return config.presetColor7();
    case "8":
      return config.presetColor8();
    case "9":
      return config.presetColor9();
    case "10":
      return config.presetColor10();
    case "11":
      return config.presetColor11();
    case "12":
      return config.presetColor12();
    case "13":
      return config.presetColor13();
    case "14":
      return config.presetColor14();
    case "15":
      return config.presetColor15();
    case "16":
      return config.presetColor16();
    case "17":
      return config.presetColor17();
    case "18":
      return config.presetColor18();
    case "19":
      return config.presetColor19();
    case "20":
      return config.presetColor20();
    }

    return color;
  }

  /**
   * Returns fill color of either the config or a preset if selected
   *
   * @return Color
   */
  public Color getHighlightFillColor(String preset, Color color) {
    switch (preset) {
    case "1":
      return config.presetFillColor1();
    case "2":
      return config.presetFillColor2();
    case "3":
      return config.presetFillColor3();
    case "4":
      return config.presetFillColor4();
    case "5":
      return config.presetFillColor5();
    case "6":
      return config.presetFillColor6();
    case "7":
      return config.presetFillColor7();
    case "8":
      return config.presetFillColor8();
    case "9":
      return config.presetFillColor9();
    case "10":
      return config.presetFillColor10();
    case "11":
      return config.presetFillColor11();
    case "12":
      return config.presetFillColor12();
    case "13":
      return config.presetFillColor13();
    case "14":
      return config.presetFillColor14();
    case "15":
      return config.presetFillColor15();
    case "16":
      return config.presetFillColor16();
    case "17":
      return config.presetFillColor17();
    case "18":
      return config.presetFillColor18();
    case "19":
      return config.presetFillColor19();
    case "20":
      return config.presetFillColor20();
    }

    return color;
  }

  /**
   * Color of the tag menu (ex. "Tag-Hull")
   *
   * @return Color
   */
  public Color getTagColor() {
    if (config.useGlobalTileColor())
    {
      return config.globalTileColor();
    }
    if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.TILE))
    {
      return config.tileColor();
    }
    else if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.TRUE_TILE))
    {
      return config.trueTileColor();
    }
    else if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.SW_TILE))
    {
      return config.swTileColor();
    }
    else if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.SW_TRUE_TILE))
    {
      return config.swTrueTileColor();
    }
    else if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.HULL))
    {
      return config.hullColor();
    }
    else if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.AREA))
    {
      return config.areaColor();
    }
    else if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.OUTLINE))
    {
      return config.outlineColor();
    }
    else if (config.tagStyleModeSet().contains(BetterNpcHighlightConfig.tagStyleMode.CLICKBOX))
    {
      return config.clickboxColor();
    }
    else
    {
      return Color.getHSBColor(new Random().nextFloat(), 1.0F, 1.0F);
    }
  }

  public Color getRaveColor(int speed) {
    int ticks = speed / 20;
    return Color.getHSBColor((client.getGameCycle() % ticks) / ((float) ticks), 1.0f, 1.0f);
  }
}
