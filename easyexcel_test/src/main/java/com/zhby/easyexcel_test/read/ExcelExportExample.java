package com.zhby.easyexcel_test.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExcelExportExample {
    public static void main(String[] args) {
        // 创建数据集合
        List<User> userList = new ArrayList<>();
        userList.add(new User("John", 25));
        userList.add(new User("Amy", 30));
        userList.add(new User("Mike", 28));

        // 设置导出的文件路径和文件名
        String filePath = "C:/Users/Admin/Desktop/test01.xlsx";
        Set<String> includ=new HashSet<>();
        includ.add("name");

        // 创建ExcelWriter对象
        //EasyExcel.write(filePath,User.class).sheet("用户表").doWrite(userList);


    }

    // 定义数据实体类
        @Data
        public static class User {
            @ExcelProperty("姓名")
            private String name;

            @ExcelProperty("年龄")
            private int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }
        // 省略getter和setter方法
    }
}
