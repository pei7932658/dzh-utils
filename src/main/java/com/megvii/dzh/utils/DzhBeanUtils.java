package com.megvii.dzh.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 
 * @Description
 * @author chenchaoyun
 * @date 2017年4月1日 下午2:05:44
 */
@Slf4j
public class DzhBeanUtils {

  public static <S, T> List<T> copyList(List<S> sources, Class<T> c) {
    List<T> list = new ArrayList<T>();
    for (S s : sources) {
      T copyBean = copyBean(s, c);
      list.add(copyBean);
    }
    return list;
  }

  public static <S, T> T copyBean(S source, Class<T> c) {
    T dest = null;
    try {
      dest = c.newInstance();
      if (source != null) {
        BeanUtils.copyProperties(source, dest);
      }
    } catch (InstantiationException | IllegalAccessException e) {
      log.error("copyBean:实例化类型出错:{}", e);
      throw new RuntimeException("copyBean:实例化类型出错", e);
    }
    return dest;
  }

  public static <T> String[] getFieldStringArrays(Class<T> c) {
    Field[] declaredFields = c.getDeclaredFields();
    List<String> list = new ArrayList<>();
    for (Field field : declaredFields) {
      String name = field.getName();
      if (!"serialVersionUID".equals(name)) {
        list.add(name);
      }
    }
    String[] s = new String[list.size()];
    list.toArray(s);
    return s;
  }
}
