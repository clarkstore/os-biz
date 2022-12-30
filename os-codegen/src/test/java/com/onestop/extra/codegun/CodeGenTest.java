package com.onestop.extra.codegun;

import com.onestop.extra.codegun.util.OsCodeGenUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author Clark
 * @version 2021/5/14
 */
@Slf4j
@SpringBootTest(classes = CodegunApplication.class)
public class CodeGenTest {
    @Resource
    private OsCodeGenUtils codeGenUtils;

    @Test
    void codeGen() {
        this.codeGenUtils.codeGenerator();
    }
}