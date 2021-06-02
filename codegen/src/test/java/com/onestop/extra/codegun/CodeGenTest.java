package com.onestop.extra.codegun;

import com.onestop.extra.codegun.util.CodeGenUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Clark
 * @version 2021/5/14
 */
@Slf4j
@SpringBootTest(classes = CodegunApplication.class)
public class CodeGenTest {
    @Resource
    private CodeGenUtils codeGenUtils;

    @Test
    void codeGen() {
        this.codeGenUtils.codeGenerator();
    }
}