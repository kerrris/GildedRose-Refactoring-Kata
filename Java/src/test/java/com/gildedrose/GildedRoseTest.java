package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private static final String BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured";
    private static final String NORMAL = "Normal Item";
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void testAgedBrieQualityIncrease() {
        Item[] items = new Item[] { new Item(BRIE, 2, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(1, gildedRose.items[0].quality);
        assertEquals(1, gildedRose.items[0].sellIn);
    }

    @Test
    public void testAgedBrieQualityStaysSame() {
        Item[] items = new Item[] { new Item(BRIE, 10, 50) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void testSulfurasQualityStaysSame() {
        Item[] items = new Item[] { new Item(SULFURAS, 0, 80) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(0, gildedRose.items[0].sellIn);
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreaseSellInDecrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 15, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(21, gildedRose.items[0].quality);
        assertEquals(14, gildedRose.items[0].sellIn);
    }

    @Test
    public void testBackstagePassesQualityIncreaseWith2SellInDecrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 10, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(22, gildedRose.items[0].quality);
        assertEquals(9, gildedRose.items[0].sellIn);
    }

    @Test
    public void testBackstagePassesQualityIncreaseWith3SellInDecrease() {
        Item[] items = new Item[] { new Item(BACKSTAGE, 5, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(23, gildedRose.items[0].quality);
        assertEquals(4, gildedRose.items[0].sellIn);
    }
    @Test
    public void testConjuredItemDecreasesWith2() {
        Item[] items = new Item[] { new Item(CONJURED, 3, 6) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(4, gildedRose.items[0].quality);
        assertEquals(2, gildedRose.items[0].sellIn);
    }

    @Test
    public void testNormalItemQualityAndSellInDecrease() {
        Item[] items = new Item[] { new Item(NORMAL, 10, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateItems();
        assertEquals(19, gildedRose.items[0].quality);
        assertEquals(9, gildedRose.items[0].sellIn);
    }
}
