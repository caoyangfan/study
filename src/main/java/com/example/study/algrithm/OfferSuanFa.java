package com.example.study.algrithm;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,
 * 8,12,16,15,
 * 14,13,9,5,
 * 6,7,11,10.
 *
 * @author: caoyangfan
 * @create: 2019-11-22 14:44
 **/
public class OfferSuanFa {


    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> integers = printMatrix(array);
        System.out.println(integers);
    }

    public static ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array.length == 0)
            return result;
        int n = array.length, m = array[0].length;
        if (m == 0)
            return result;
        // 此种方法关键点--求圈数
        int layers = (Math.min(n, m) - 1) / 2 + 1;
        // 要打印的圈数
        for (int i = 0; i < layers; i++) {
            // 打印每圈
            for (int k = i; k < m - i; k++)
                result.add(array[i][k]);// 左至右
            for (int j = i + 1; j < n - i; j++)
                result.add(array[j][m - i - 1]);// 右上至右下
            // 注意k,j开始的下标
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--)
                result.add(array[n - i - 1][k]);// 右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--)
                result.add(array[j][i]);// 左下至左上
        }
        return result;
    }


}
