package com.megvii.test;

import com.alibaba.fastjson.annotation.JSONField;
import com.megvii.dzh.annotations.HideAnn;
import com.megvii.dzh.annotations.HideCollection;
import com.megvii.dzh.annotations.HideImg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 描述:
 *
 * @author chenchaoyun
 * @create 2018-11-27 14:42
 */
public class TestUserVo implements Serializable {

  private static final long serialVersionUID = -2399743412194441268L;

  @JSONField(serialize = false)
  private String userName = "chenchaoyun";

  @HideImg
  private String userPassword = "BORw0KGgoA";

  @HideAnn
  private String userPwd = "qwertyuiop";

  @JSONField(name="USERIMG")
  @HideImg
  private String userImg = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAioAAAEqCAYAAAA72HsuAAAgAElEQVR4AeydBdQtSXW2m+Ti7gzu7u4e3IPN4ME9aLD8uHtwd9fBBofgMFjwwW3QEBwGSMK/nuY+N/v";

  @JSONField(name = "USERDOGLIST")
  private List<TestUserDog> userDogList = new ArrayList<>();

  private Map<String, TestUserDog> userDogMap = new HashMap<>();

  private Set<TestUserDog> userDogSet = new HashSet<>();

  @HideCollection
  private List<Integer> integerList = new ArrayList<>();

  private List<String> stringList =new ArrayList<>();

  private TestUserDog[] userDogArrays = new TestUserDog[]{new TestUserDog(), new TestUserDog()};

  public TestUserVo() {
    this.userDogList.add(new TestUserDog());
    this.userDogList.add(new TestUserDog());
    this.userDogSet.add(new TestUserDog());
    this.userDogSet.add(new TestUserDog());
    this.userDogMap.put(UUID.randomUUID().toString(), new TestUserDog());
    this.userDogMap.put(UUID.randomUUID().toString(), new TestUserDog());
    this.integerList.add(1);
    this.integerList.add(2);
    this.integerList.add(3);

    this.stringList.add("123");
    this.stringList.add("456");
    this.stringList.add("789");
  }

  public List<String> getStringList() {
    return stringList;
  }

  public void setStringList(List<String> stringList) {
    this.stringList = stringList;
  }

  public List<Integer> getIntegerList() {
    return integerList;
  }

  public void setIntegerList(List<Integer> integerList) {
    this.integerList = integerList;
  }

  public Map<String, TestUserDog> getUserDogMap() {
    return userDogMap;
  }

  public void setUserDogMap(Map<String, TestUserDog> userDogMap) {
    this.userDogMap = userDogMap;
  }

  public Set<TestUserDog> getUserDogSet() {
    return userDogSet;
  }

  public void setUserDogSet(Set<TestUserDog> userDogSet) {
    this.userDogSet = userDogSet;
  }

  public TestUserDog[] getUserDogArrays() {
    return userDogArrays;
  }

  public void setUserDogArrays(TestUserDog[] userDogArrays) {
    this.userDogArrays = userDogArrays;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public String getUserImg() {
    return userImg;
  }

  public void setUserImg(String userImg) {
    this.userImg = userImg;
  }

  public List<TestUserDog> getUserDogList() {
    return userDogList;
  }

  public void setUserDogList(List<TestUserDog> userDogList) {
    this.userDogList = userDogList;
  }
}

class TestUserDog {

  @HideImg
  private String dogImg = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAioAAAEqCAYAAAA72HsuAAAgAElEQVR4AeydBdQtSX";


  public TestUserDog() {
  }

  public String getDogImg() {
    return dogImg;
  }

  public void setDogImg(String dogImg) {
    this.dogImg = dogImg;
  }
}