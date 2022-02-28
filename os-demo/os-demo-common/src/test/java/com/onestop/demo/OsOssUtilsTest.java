package com.onestop.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Clark
 * @version 2021/8/20
 */
@Slf4j
@SpringBootTest(classes = OsDemoApplication.class)
public class OsOssUtilsTest {
    private String ossPath = "popular/";
    private String localPath = "d:/upload";

    @Autowired
    private OsOssUtils utils;

    @Test
    public void test() {
        try {
            //加载文件夹
            File file = new File(localPath);
            if (file.isDirectory()) {
                //将该目录下的所有文件放置在一个File类型的数组中
                File[] fileList = file.listFiles();
                log.error("=============================");
                log.error("本次上传共计：" + fileList.length + "个文件");
                for (File item : fileList) {
                    utils.upload(ossPath + item.getName(), new FileInputStream(item));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}