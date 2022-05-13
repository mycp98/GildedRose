package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);

    }

    @Test
    void normalItemQualityValueAndSellInValueDecreaseByOneAtTheEndOfDay() {
        Item[] items = new Item[] { new Item("foo", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void qualityDegradesTwiceAsFastWhenTheSellByDateHasPassed() {
        Item[] items = new Item[] { new Item("foo", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void qualityOfItemIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 4, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieIncreasesInQualityAtTheEndOfDay() {
        Item[] items = new Item[] { new Item("Aged Brie", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void qualityOfItemIsNeverMoreThanFifty() {
        Item[] items = new Item[] { new Item("foo", 4, 51) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityOfBrieItemIsNeverMoreThanFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 4, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

    }

    @Test
    void SulfurasIsNeverSoldAndNeverDecreasesInQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(25, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesByTwoWhenTenDaysOrLessLeftAndMoreThanFiveDaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesByThreeWhenFiveDaysOrLessLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityDropsToZeroWhenSellByDatePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void conjuredItemsDegradeInQualityTwiceAsFastAsNormalItems() {
        Item[] items = new Item[] { new Item("conjured item", 5, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(15, app.items[0].quality);
    }


}
