package top.learn.service;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        int size = 6;
        int i = 1;
        while (size != 0) {
            i *= 10;
            size--;
        }
        int flag = new Random().nextInt(i-1);
        if (flag < 100000)
        {
            flag += 100000;
        }
        System.out.println(flag);
    }

}
