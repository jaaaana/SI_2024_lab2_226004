package org.example;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @Test(expected = RuntimeException.class)
    public void allItemsNull(){
        SILab2.checkCart(null, 100);
    }

    @Test
    public void productWithoutName(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("", "234", 250, 0.3f));
        assertTrue(SILab2.checkCart(items, 100));
        assertEquals("unknown", items.get(0).getName());
    }

    @Test(expected = RuntimeException.class)
    public void nullBarcode(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", null, 200, 0));
        SILab2.checkCart(items, 100);
    }

    @Test(expected = RuntimeException.class)
    public void invalidBarcode(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "89ab", 200, 0));
        SILab2.checkCart(items, 200);
    }

    @Test
    public void discountNoCondition(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item", "123", 100, 0.7f));
        assertTrue(SILab2.checkCart(items, 100));
    }

    @Test
    public void discountCondition(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item", "0123", 500, 0.7f));
        assertFalse(SILab2.checkCart(items, 100));
    }

    @Test
    public void withoutDiscount(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item", "0123", 500, 0));
        assertFalse(SILab2.checkCart(items, 100));
    }

    @Test
    public void priceLessThanPayment(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "123", 400, 0));
        items.add(new Item("Item2", "456", 200, 0.3f));
        assertTrue(SILab2.checkCart(items, 800));
    }

    @Test
    public void priceGreaterThanPayment(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "789", 1000, 0));
        items.add(new Item("Item2", "012", 700, 0.8f));
        assertFalse(SILab2.checkCart(items, 1200));
    }

    @Test
    public void multipleCondition1(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "123", 400, 0));
        assertFalse(SILab2.checkCart(items, 100));
    }

    @Test
    public void multipleCondition2() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "123", 200, 0.5f));
        assertTrue(SILab2.checkCart(items, 100));
    }

    @Test
    public void multipleCondition3() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "0123", 200, 0));
        assertFalse(SILab2.checkCart(items, 100));
    }

    @Test
    public void multipleCondition4() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "123", 400, 0.5f));
        assertFalse(SILab2.checkCart(items, 100));
    }

    @Test
    public void multipleCondition5() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "0123", 400, 0));
        assertFalse(SILab2.checkCart(items, 100));
    }

    @Test
    public void multipleCondition6() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "0123", 200, 0.5f));
        assertTrue(SILab2.checkCart(items, 100));
    }

    @Test
    public void multipleCondition7() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "123", 200, 0));
        assertFalse(SILab2.checkCart(items, 100));
    }

    @Test
    public void multipleCondition8() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item", "0123", 400, 0.5f));
        assertFalse(SILab2.checkCart(items, 100));
    }

}
