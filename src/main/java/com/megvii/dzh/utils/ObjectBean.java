package com.megvii.dzh.utils;

/**
 * 描述: 封装集合对象
 *
 * @author chenchaoyun
 * @create 2018-11-28 11:23
 */
public class ObjectBean {

  private Object arrayObject;

  public ObjectBean() {
  }

  public ObjectBean(Object arrayObject) {
    this.arrayObject = arrayObject;
  }

  public Object getArrayObject() {
    return arrayObject;
  }

  public void setArrayObject(Object arrayObject) {
    this.arrayObject = arrayObject;
  }
}