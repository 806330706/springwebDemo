package com.shicaigj.ops.web;

import java.io.IOException;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;
import com.shicaigj.ops.util.SignUtils;
import com.shicaigj.ops.web.constans.URLConstans;


@Controller
@RequestMapping("/v1/app")
public class ApiController {

  private AsyncHttpClient client;

  // @ResponseBody
  @RequestMapping(value = "test", method = RequestMethod.GET)
  public ModelAndView testPage() {
    return new ModelAndView("api/test");
  }

  @RequestMapping(value = "version", method = RequestMethod.GET)
  public @ResponseBody String check_Test(@RequestParam("platform") String platform,
      @RequestParam("os") String os) throws InterruptedException, ExecutionException {

    String version = "1.0";
    TreeMap<String, String> treeMap = new TreeMap<String, String>();
    treeMap.put("version", version);
    String sign = SignUtils.genSign(treeMap);

    System.out.println(sign);
    RequestBuilder builder = new RequestBuilder("GET");
    Request request =
        builder.setUrl(URLConstans.URL_BASE + "app/version").addHeader("pt", platform)
            .addHeader("os", os).addQueryParam("version", version).addQueryParam("sign", sign)
            .build();
    client = new AsyncHttpClient();
    Response response = client.executeRequest(request).get();
    String result;
    try {
      result = response.getResponseBody();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      result = e.toString();
    }

    return result;
  }
}
