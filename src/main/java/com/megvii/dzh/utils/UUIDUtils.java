package com.megvii.dzh.utils;

import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述:
 *
 * @author chenchaoyun
 * @create 2018-12-19 15:53
 */
public class UUIDUtils {
  public static String randomUUID(){
    return StringUtils.replace(UUID.randomUUID().toString(),"-","");
  }
}