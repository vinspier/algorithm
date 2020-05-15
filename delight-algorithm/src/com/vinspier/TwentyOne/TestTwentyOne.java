package com.vinspier.TwentyOne;

/**
 * @ClassName: TestTwentyOne
 * @Description:
 * 21点游戏 赌场经典的二十一点游戏，每回合最少下注 1 枚硬币，赢了可以得到 2 枚硬币，输了硬币会被收走。
 * @Author:
 * @Date: 2020/3/17 10:22
 * @Version V1.0
 **/

public class TestTwentyOne {
    public static void main(String[] args) {
        TwentyOne twentyOne = new TwentyOne(10,24);
        twentyOne.bet(twentyOne.getAmount(),0);
        twentyOne.getLeftData().stream().forEach((i)-> System.out.println(i));
        System.out.println(twentyOne.getAvaliable());
    }


}
