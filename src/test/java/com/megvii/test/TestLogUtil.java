package com.megvii.test;

import com.alibaba.fastjson.JSONObject;
import com.megvii.dzh.utils.LogUtil;
import java.util.List;

/**
 * 描述:
 *
 * @author chenchaoyun
 * @create 2018-11-27 14:42
 */
public class TestLogUtil {

  public static void main(String[] args) {
    //1-单一属性对象
    TestUserVo userVo = new TestUserVo();
    System.out.println("userVo:{}"+LogUtil.formatLog(userVo));
    //2-集合/嵌套属性对象
    List<TestUserDog> userDogList = userVo.getUserDogList();
//    System.out.println("1.getUserDogList:{}"+ JSONObject.toJSONString(userVo));
//    System.out.println("2.getUserDogList:{}"+LogUtil.formatLog(userVo));
    //System.out.println(LogUtil.prettyJson(LogUtil.formatLog(userVo)));
  }
}