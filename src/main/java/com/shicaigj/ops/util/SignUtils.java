package com.shicaigj.ops.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.common.base.Joiner;
import com.shicaigj.util.sec.SecUtils;


/**
 * 请求api sign加密方法
 * 
 * @author mengqizhou
 *
 */
public final class SignUtils {

  private final static String ScgjAppKey = "d0611c60b143da8d505908e7946600f8";

  public static String genSign(TreeMap<String, String> paramMap) {
    List<String> kvPairs = new ArrayList<>(paramMap.size() + 1);
    for (Entry<String, String> entry : paramMap.entrySet()) {
      String kvPair = String.format("%s=%s", entry.getKey(), entry.getValue());
      kvPairs.add(kvPair);
    }
    kvPairs.add(ScgjAppKey);

    String sign = Joiner.on('|').join(kvPairs);
    sign = SecUtils.sha1(sign);
    return sign;
  }

}
