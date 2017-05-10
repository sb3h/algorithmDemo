package com.template.N20_ExpressionBST;

import java.util.Stack;

/**
 * Created by huanghh on 2017/5/9.
 */

public class N20_ExpressionBST {

    //--------------------------------初始化动作-----------------------------------
    //--------------------------------查询动作-----------------------------------
    //--------------------------------添删动作-----------------------------------


    public static void main(String[] args) {
        BET bet = new BET();
        String exp = "";
//        exp = "752+*";
//        bet.parse(exp);
//        System.out.println(String.format("exp:%s-->result:%d",exp,bet.evaluate()));

//        exp = "753+*";
//        bet.parse(exp);
//        System.out.println(String.format("exp:%s-->result:%d", exp, bet.evaluate()));

//        exp = "7";
//        bet.parse(exp);
//        System.out.println(String.format("exp:%s-->result:%d",exp,bet.evaluate()));
//
        exp = "77+88++";
        bet.parse(exp);
        System.out.println(String.format("exp:%s-->result:%d",exp,bet.evaluate()));
//        String str = "123";
//        System.out.println(str.charAt(str.length()-1));
    }
}
