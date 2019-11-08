package com.zm.zmcommon;

import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/7 14:36
 */
public class CommonUtils {

    public static Map objToMaps(Object... objects) {
        Map map = Maps.newHashMap();
        for (Object object : objects) {
            Set<Map.Entry<String, Object>> entrySet = objectToMap(object).entrySet();
            entrySet.forEach(o -> {
                if (Objects.nonNull(o.getValue())) {
                    map.put(o.getKey(), o.getValue());
                }
            });
        }
        return map;
    }

    public static Map<String, Object> objectToMap(Object obj) {
        try {
            Map<String, Object> map = Maps.newHashMap();
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                map.put(fieldName, value);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
