package com.onestop.demo;

import com.onestop.ali.oss.util.OsOssUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Clark
 * @version 2021/8/20
 */
@SpringBootTest(classes = OsDemoApplication.class)
public class OsOssUtilsTest {
    @Autowired
    private OsOssUtils osOssUtils;

    @Test
    public void test() {
        File file = new File("d:\\123.txt");

        try {
            osOssUtils.upload("abc/1.txt", new FileInputStream(file));
            osOssUtils.download("abc/1.txt", "d:\\1.txt");
            osOssUtils.deleteObject("abc");
            osOssUtils.deleteObjectList("abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}