package com.alphy;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIDs {
  public static ResourceKey<Item> create(String name) {
    return ResourceKey.create(Registries.ITEM, FirstItem.id(name));
  }

  public static final ResourceKey<Item> LUMINITE_ALLOY = create("luminite_alloy");
  public static final ResourceKey<Item> LUMINITE_DUST = create("luminite_dust");
}
