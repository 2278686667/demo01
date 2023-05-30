package com.zhby.easyexcel_test.read;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * @ClassName: ReadTest
 * @Description:
 * @Author: CHB
 * @Date: 2023/5/18 9:21
 * @Version: 1.0
 */
@SpringBootTest
public class ReadTest {


    @Test
    public void test01(){
        File file=new File("C:/Users/Admin/Desktop/test01.xlsx");
        EasyExcel.write(file,User.class);


    }
    // 定义数据实体类
    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // 省略getter和setter方法
    }

}
