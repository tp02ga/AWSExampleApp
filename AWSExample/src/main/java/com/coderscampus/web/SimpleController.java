package com.coderscampus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderscampus.UserRepository;
import com.coderscampus.domain.User;

@Controller
public class SimpleController
{
  @Autowired
  private UserRepository userRepo;
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String root (ModelMap model)
  {
    List<User> users = userRepo.findAll();
    model.put("hello", "Hello World");
    model.put("users", users);
    return "index";
  }
}
