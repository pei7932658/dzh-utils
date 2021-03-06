package com.megvii.dzh.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 描述: copy from spring ObjectUtils
 *
 * @author chenchaoyun
 * @create 2018-11-28 10:45
 */
public class ObjectUtils {

  /**
   * Determine whether the given object is an array:
   * either an Object array or a primitive array.
   * @param obj the object to check
   */
  public static boolean isArray(Object obj) {
    return (obj != null && obj.getClass().isArray());
  }

  public static boolean isEmpty(Object obj) {
    if (obj == null) {
      return true;
    }
    if (obj.getClass().isArray()) {
      return Array.getLength(obj) == 0;
    }
    if (obj instanceof CharSequence) {
      return ((CharSequence) obj).length() == 0;
    }
    if (obj instanceof Collection) {
      return ((Collection) obj).isEmpty();
    }
    if (obj instanceof Map) {
      return ((Map) obj).isEmpty();
    }

    // else
    return false;
  }
}