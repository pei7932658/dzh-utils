package com.megvii.dzh.utils;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class TaskNoUtils {

  public static String nextTaskNo(String prefix) {
    StringBuilder sb = new StringBuilder(StringUtils.isBlank(prefix)?"":prefix);
    sb.append(1).append((System.currentTimeMillis() + "").substring(1)).append((System.nanoTime() + "").substring(7, 10));
    String orderId = sb.toString();
    return orderId;
  }

  public static String nextTaskNoTime() {
    String format = DateConvertUtils.format(new Date(), DateConvertUtils.DATE_FORMAT_NOT);
    return format;
  }

}
