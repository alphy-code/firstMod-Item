package com.alphy;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
  public static Item registerModItem(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory,
      Item.Properties settings) {
    Item item = itemFactory.apply(settings.setId(itemKey));
    Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    return item;
  }

  public static final Item LUMINITE_ALLOY_ITEM = registerModItem(ModItemIDs.LUMINITE_ALLOY, Item::new,
      new Item.Properties());
  public static final Item LUMINITE_DUST_ITEM = registerModItem(ModItemIDs.LUMINITE_DUST, Item::new,
      new Item.Properties());

  public static void initialize() {
    CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
        .register((creativeTabs) -> creativeTabs.accept(LUMINITE_ALLOY_ITEM));
    CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
        .register((creativeTabs) -> creativeTabs.accept(LUMINITE_DUST_ITEM));
  }
}
