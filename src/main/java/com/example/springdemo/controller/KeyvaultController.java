/**
 * Copyright 2024 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 26/Mar/2024
 */

package com.example.springdemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/keyvault")
@Profile("keyvault")
@RequiredArgsConstructor
public class KeyvaultController {

  @Value("${demo_secret:}")
  private String secret;

  @GetMapping("/check")
  @ResponseBody
  public String check(){
    return "keyvault profile is enabled";
  }

  @GetMapping("/secret")
  @ResponseBody
  public String secret() {
    return "Key Vault secret: " + secret;
  }
}
