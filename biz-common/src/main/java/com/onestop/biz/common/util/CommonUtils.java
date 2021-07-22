package com.onestop.biz.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 公共工具类
 */
@Component
public class CommonUtils {
    private Map<String, Integer> map = MapUtil.newHashMap();

    /**
     * 生成Id
     * @return
     */
    public String getId() {
        return IdUtil.getSnowflake(1,1).nextIdStr();
    }

    /**
     * 根据日期生成固定长度序号
     * @return
     */
    private String getSequence() {
        int sequence = 1;
        String today = DateUtil.format(new Date(), "yyMMdd");
        if (map.get(today) == null) {
            map.clear();
            map.put(today, sequence);
        } else {
            sequence = map.get(today) + 1;
            map.put(today, sequence);
        }
        //0代表前面要补的字符
        //4代表字符串长度
        //d表示参数为整数类型
        return String.format("%04d", sequence);
    }
}
