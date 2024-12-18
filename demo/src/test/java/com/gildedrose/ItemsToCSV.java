package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class ItemsToCSV {


    static Item[] generateSamples() {
        List<Item> items = new ArrayList<>();
        for (String itemName : List.of("Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros")) {
            for (int itemSellIn = 0; itemSellIn < 100; itemSellIn++) {
                for (int itemQuality = 0; itemQuality < 100; itemQuality++) {
                    Item item = new Item(itemName, itemSellIn, itemQuality);
                    items.add(item);
                }
            }
        }
        Item[] result = new Item[items.size()];
        return items.toArray(result);
    }

    static String toCSV(Item[] items) {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.name);
            sb.append(';');
            sb.append(item.sellIn);
            sb.append(';');
            sb.append(item.quality);
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Item[] items = generateSamples();
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        System.out.println(toCSV(items));
    }
}
