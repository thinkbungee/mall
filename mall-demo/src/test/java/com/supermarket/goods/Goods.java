package com.supermarket.goods;

import lombok.Data;

/**
 * 商品
 * @version 1.0 created by chenyichang_fh on 2019/5/15 15:23
 */
@Data
public class Goods {
    public Goods(String name, int count, boolean isImport, int goodsType, float price) {
        this.name = name;
        this.count = count;
        this.isImport = isImport;
        this.goodsType = goodsType;
        this.price = price;
    }

    public static float getGoodsPrice(Goods goods) throws Exception {

        float finalPrice = 0;
        if (null == goods) {
            System.out.println("商品不能为空");
            throw new Exception();
        }
        if (goods.isImport) {
            //进口货物，有附加税
            float importPrice = goods.price * goods.count * Goods.IMPORT;
            finalPrice += getMathPrice(importPrice);
        }

        if (goods.goodsType == GoodType.OTHER.getType()) {
            //非books, food, and medical products 征收基础税
            float basePrice = goods.price * goods.count * Goods.BASIC;
            finalPrice += getMathPrice(basePrice);
        }

        //最后 总价为 商品价格 和消费税
        finalPrice += goods.price * goods.count;
        return finalPrice;
    }

    /**
     * The rounding rules for sales tax are that for a tax rate of n%,
     * a shelf price of p contains (np/100 rounded up to the nearest 0.05)
     * amount of sales tax.
     *
     * @param price
     * @return
     */
    private static float getMathPrice(float price) {
        int i = String.valueOf(price / 0.05f).indexOf(".");
        //只要不是0.05的倍数，就需要四舍五入至小数点后一位
        if(i != -1){

        }
        return price;
    }

    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品数量
     */
    private int count;

    /**
     * 是否进口
     */
    private boolean isImport;

    /**
     * 商品类型
     */
    private int goodsType;

    /**
     * 单价
     */
    private float price;

    /**
     * 基本税
     */
    public static final float BASIC = 0.1f;

    /**
     * 进口附加税
     */
    public static final float IMPORT = 0.05f;

}
