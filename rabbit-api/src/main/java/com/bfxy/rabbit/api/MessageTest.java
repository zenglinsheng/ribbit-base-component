package com.bfxy.rabbit.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zls
 * @Date: 2021/11/9 13:32
 * @Description:
 */
public class MessageTest {

    public static void main(String[] args) {
        Map<String, Object> attributesMap = new HashMap<>();
        attributesMap.put("username", "zenglinsheng");
        attributesMap.put("age", 25);
        Message message = MessageBuilder.
                create().
                withTopic(MessageType.RELIANT).
                withAttributes(attributesMap).
                withAttribute("sex", "boy").
                withDelayMills(10000).
                withRoutingKey("springBoot.*").
                build();
        System.out.println(message);

    }

}
