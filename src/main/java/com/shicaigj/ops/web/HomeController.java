package com.shicaigj.ops.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shicaigj.ops.model.User;

@Controller
@RequestMapping("/home")
public class HomeController {

  @RequestMapping(value = "show", method = RequestMethod.GET)
  public ModelAndView showHomePage(HttpServletRequest request, HttpServletResponse response,
      ModelMap modelMap) {
    return new ModelAndView("home/show");
  }

  @RequestMapping(value = "ordinary", method = RequestMethod.GET)
  public ModelAndView ordinary(HttpServletRequest request, HttpServletResponse response,
      ModelMap modelMap) {
    // velocity测试
    List<String> strlist = new ArrayList<String>();
    for (int i = 0; i < 10; i++) {
      strlist.add("list字符" + i);
    }
    modelMap.put("strlist", strlist);
    Map<String, String> map = new HashMap<String, String>();
    for (int i = 0; i < 10; i++) {
      map.put("zifu" + i, "map字符" + i);
    }
    map.put(null, "哦");
    modelMap.put("map", map);
    List<User> objlist = new Stack<User>();
    for (int i = 0; i < 10; i++) {
      objlist.add(new User("name" + i, "nick" + i));
    }
    modelMap.put("uselist", objlist);
    return new ModelAndView("home/ordinary", modelMap);
  }

}
