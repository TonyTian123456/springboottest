package com.example.config.datasource.prop;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("baiduParamsProperties")
@EnableConfigurationProperties(value = BaiduParamsProperties.class)
@ConfigurationProperties(prefix="baidu")
@Primary
@Data
public class BaiduParamsProperties {

	private String ak;
	
	private String sk;


}
