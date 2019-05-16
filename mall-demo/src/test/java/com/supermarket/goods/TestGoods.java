package com.supermarket.goods;

/**
 * @version 1.0 created by chenyichang_fh on 2019/5/15 18:34
 */
public class TestGoods {

    public static void main(String[] args) throws Exception {
        //第一组
        System.out.println("Input 1:");
        Goods book = new Goods("book", 1, false, GoodType.BOOK.getType(), 12.49f);
        Goods musicCD = new Goods("musicCD", 1, false, GoodType.OTHER.getType(), 14.99f);
        Goods chocolate = new Goods("chocolate", 1, false, GoodType.FOOD.getType(), 0.85f);

        System.out.println(book.getCount() + " " + book.getName() + " at " + book.getPrice());
        System.out.println(musicCD.getCount() + " " + musicCD.getName() + " at " + musicCD.getPrice());
        System.out.println(chocolate.getCount() + " " + chocolate.getName() + " at " + chocolate.getPrice());

        //第二组
        System.out.println("Input 2:");
        Goods importChocolates = new Goods("importChocolates", 1, true, GoodType.FOOD.getType(), 10.00f);
        Goods importPerfume = new Goods("importPerfume", 1, true, GoodType.OTHER.getType(), 47.50f);

        System.out.println(importChocolates.getCount() + " " + importChocolates.getName() + " at " + importChocolates.getPrice());
        System.out.println(importPerfume.getCount() + " " + importPerfume.getName() + " at " + importPerfume.getPrice());



        System.out.println("Output 1:");
        System.out.println(book.getCount() + " " + book.getName() + ":" + Goods.getGoodsPrice(book));
        System.out.println(musicCD.getCount() + " " + musicCD.getName() + ":" + Goods.getGoodsPrice(musicCD));
        System.out.println(chocolate.getCount() + " " + chocolate.getName() + ":" + Goods.getGoodsPrice(chocolate));


        System.out.println("Output 2:");
        System.out.println(importChocolates.getCount() + " " + importChocolates.getName() + ":" + Goods.getGoodsPrice(importChocolates));
        System.out.println(importPerfume.getCount() + " " + importPerfume.getName() + ":" + Goods.getGoodsPrice(importPerfume));
    }
}
