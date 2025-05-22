/**
 * Copyright 2024 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 26/Mar/2024
 */

package com.example.springdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
  @Value("${demo_setting:}")
  private String setting;
  @Value("${demo_secret:}")
  private String secret;
  @Value("${api_test:}")
  private String apiTest;

  @GetMapping("/hello")
  @ResponseBody
  public String hello(@RequestParam(required = false) String name) throws InterruptedException {
    log.info("hello: {}", name);
    Thread.sleep(10000);
    log.info("bye: {}", name);
    return "Hello: " + name;
  }

  @GetMapping("/setting")
  @ResponseBody
  public String setting() {
    return "setting: " + setting;
  }

  @GetMapping("/secret")
  @ResponseBody
  public String secret() {
    return "secret: " + secret;
  }

  @GetMapping("/call")
  @ResponseBody
  public String callExpress() {
    try{
      log.info("call express: {}", apiTest);
      RestTemplate template = new RestTemplate();
      return template.getForObject(apiTest, String.class);
    }catch (Exception e){
      return e.getMessage();
    }

  }
}
