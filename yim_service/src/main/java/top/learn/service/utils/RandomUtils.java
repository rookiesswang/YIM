package top.learn.service.utils;

import java.util.Random;

public class RandomUtils {
    // 生成6位账号
    public static Integer getAcoountBySize(int size) {
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
        return flag;
    }

}
