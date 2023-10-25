package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final String BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured";
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }
    private static void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        if (isExpired(item)) {
            handleExpiredItem(item);
        }
    }
    private static void handleExpiredItem(Item item) {

        if (BRIE.equals(item.name)) {
            increaseQuality(item);
        } else if (BACKSTAGE.equals(item.name)) {
            item.quality = 0;
        } else if (SULFURAS.equals(item.name)) {
            return;
        } else {
            decreaseQuality(item);
        }
    }
    private static void updateQuality(Item item) {
        if(CONJURED.equals(item.name)){
            decreaseQuality(item);
        }
        if (BRIE.equals(item.name)) {
            increaseQuality(item);
        } else if (BACKSTAGE.equals(item.name)) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else if (SULFURAS.equals(item.name)) {
            return;
        } else decreaseQuality(item);
    }

    private static void updateSellIn(Item item) {
        if (SULFURAS.equals(item.name)) {
            return;
        }
        item.sellIn--;
    }
    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

}
