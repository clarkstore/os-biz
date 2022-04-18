package com.onestop.demo;

import com.onestop.ali.nlp.model.dto.OsNlpReq;
import com.onestop.ali.nlp.model.dto.OsNlpRes;
import com.onestop.ali.nlp.util.OsNlpUtils;
import lombok.extern.slf4j.Slf4j;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Clark
 * @version 2022-04-14
 */
@Slf4j
@SpringBootTest(classes = OsDemoApplication.class)
public class OsNlpUtilsTest {
    private static final String TEXT = "我们都是新中国人你好吗";
    @Autowired
    private OsNlpUtils utils;

    /**
     * 基础版分词
     */
    @Test
    public void textParse() {
        OsNlpReq req = OsNlpReq.builder()
                .text(TEXT).build();

        try {
            OsNlpRes res = utils.parse(req);
            res.getWordList();
            log.error("=============================");
            log.error(res.getRequestId());
            log.error(res.getWordList().toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 高级版分词(需开通高级版、如未定制词库与基础版功能相同)
     */
    @Test
    public void textParseByCustomized() {
        OsNlpReq req = OsNlpReq.builder()
                .text(TEXT).build();

        try {
            OsNlpRes res = utils.parseByCustomized(req);
            log.error("=============================");
            log.error(res.getRequestId());
            log.error(res.getWordList().toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 第三方ansj
     */
    public void testAnsj() {
        DicLibrary.insert(DicLibrary.DEFAULT, "都是", "n", 1000);
        DicLibrary.insert(DicLibrary.DEFAULT, "国人", "n", 1000);
        DicLibrary.insert(DicLibrary.DEFAULT, "中国人", "n", 1000);
        DicLibrary.insert(DicLibrary.DEFAULT, "新中国", "n", 1000);
        DicLibrary.insert(DicLibrary.DEFAULT, "新中国人", "n", 1000);
        Result result = DicAnalysis.parse(TEXT);
        List<String> nameList = result.getTerms().stream().map(Term::getName).collect(Collectors.toList());
        log.error("==============第三方===============");
        log.error(nameList.toString());
    }
}