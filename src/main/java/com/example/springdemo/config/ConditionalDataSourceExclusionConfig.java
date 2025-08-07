/**
 * Copyright 2025 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 07/Aug/2025
 */

package com.example.springdemo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(NotSqlProfileCondition.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ConditionalDataSourceExclusionConfig {

}
