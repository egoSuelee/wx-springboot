package com.warelucent.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * config.ds – 配置层，这里是数据源的配置，包括 master 和 cluster 的数据源配置
 * controller – Controller 层
 * dao – 数据操作层 DAO，细分了 master 和 cluster 包下的 DAO 操作类
 * domain – 实体类
 * service – 业务逻辑层
 * Application – 应用启动类
 * application.properties – 应用配置文件，应用启动会自动读取配置
 */

@SpringBootApplication
public class WxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxApplication.class, args);
	}
}
