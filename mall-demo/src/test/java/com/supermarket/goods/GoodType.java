package com.supermarket.goods;

import lombok.Getter;

/**
 * @version 1.0 created by chenyichang_fh on 2019/5/15 15:50
 */
public enum GoodType {
    BOOK(1),//书
    FOOD(2),//食物
    MEDI(3),//药品
    OTHER(4),//其他
    ;

    @Getter
    private int type;//商品类型


    GoodType() {
    }

    GoodType(int type) {
        this.type = type;
    }
}
