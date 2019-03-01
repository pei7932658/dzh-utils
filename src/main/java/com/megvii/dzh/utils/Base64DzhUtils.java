package com.megvii.dzh.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.Base64Utils;

public class Base64DzhUtils {


  /**
   * 文件读取缓冲区大小.
   */
  private static final int CACHE_SIZE = 1024;

  public static String decode(String str) {
    byte[] s = Base64.getDecoder().decode(str);
    return new String(s, Charset.forName("UTF-8"));
  }


  /**
   * <p> BASE64字符串解码为二进制数据. </p>
   */
  public static byte[] decodeToByte(String base64) {
    return Base64Utils.decodeFromString(base64);
  }


  /**
   * <p> 二进制数据编码为BASE64字符串. </p>
   */
  public static String encode(byte[] bytes) {
    return Base64Utils.encodeToString(bytes);
  }


  /**
   * BASE64 encrypt.
   */
  public static String encryptBASE64(byte[] key) {
    /* 设置加密提供者，解决不同容器加密不一致问题 */
    return Base64Utils.encodeToUrlSafeString(key);
  }


  /**
   * BASE64 decrypt.
   */
  public static byte[] decryptBASE64(String key) {
    return Base64Utils.decodeFromUrlSafeString(key);
  }


  /**
   * <p> 将文件编码为BASE64字符串. </p>
   * <p> 大文件慎用，可能会导致内存溢出. </p>
   *
   * @param filePath 文件绝对路径.
   */
  public static String encodeFile(String filePath) throws Exception {
    byte[] bytes = fileToByte(filePath);
    return encode(bytes);
  }


  /**
   * <p> BASE64字符串转回文件. </p>
   *
   * @param filePath 文件绝对路径
   * @param base64 编码字符串
   */
  public static void decodeToFile(String filePath, String base64) throws Exception {
    byte[] bytes = decodeToByte(base64);
    byteArrayToFile(bytes, filePath);
  }


  /**
   * 文件绝对路径.
   *
   * @param linuxDir linux存放目录
   * @param winDir win存放目录
   * @param fileName 文件名
   * @return String
   */
  public static String filePath(String linuxDir, String winDir, String fileName) {
    StringBuffer bf = new StringBuffer();
    if ("\\".equals(File.separator)) {
      // windows
      bf.append(winDir);
    } else if ("/".equals(File.separator)) {
      // Linux
      bf.append(linuxDir);
    }
    bf.append(File.separator);
    bf.append(fileName);
    return bf.toString();
  }


  /**
   * <p> 文件转换为二进制数组. </p>
   *
   * @param filePath 文件路径
   */
  public static byte[] fileToByte(String filePath) throws Exception {
    File file = new File(filePath);
    if (file.exists()) {
      try {
        return FileUtils.readFileToByteArray(file);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }


  /**
   * <p> 二进制数据写文件. </p>
   *
   * @param bytes 二进制数据
   * @param filePath 文件生成目录
   */
  public static void byteArrayToFile(byte[] bytes, String filePath) throws Exception {
    File destFile = new File(filePath);
    if (!destFile.getParentFile().exists()) {
      destFile.getParentFile().mkdirs();
    }
    destFile.createNewFile();
    OutputStream out = new FileOutputStream(destFile);
    try {
      IOUtils.write(bytes, out);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(out);
    }
  }

  /**
   * url文件转为base64.
   */
  public static String enCodeFromUrl(String url) {
    URL neturl = null;
    try {
      neturl = new URL(url);
      return encode(IOUtils.toByteArray(neturl));
    } catch (Exception e) {
      return "";
    }
  }

}
