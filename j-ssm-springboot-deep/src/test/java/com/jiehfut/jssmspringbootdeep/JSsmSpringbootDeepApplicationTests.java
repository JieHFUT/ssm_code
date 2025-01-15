package com.jiehfut.jssmspringbootdeep;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JSsmSpringbootDeepApplicationTests {

    @Value("${outer.config}")
    private String outer;

    @Test
    void contextLoads() {
        /**
         * 外部化配置（只要在该项目打包 jar包的外面呢放一个配置文件，就不用重新打包，可以直接读取外部配置）
         * 假如这个属性 outer.config 需要被经常修改 - 外部配置
         * ***.jar => java -jar ***.jar 启动 => 该 jar 文件夹内放一个 applcation.properties
         * 在 applcation.properties 里面更改配置信息即可生效
         */
        System.out.println("outer-config = " + outer);
    }

}
