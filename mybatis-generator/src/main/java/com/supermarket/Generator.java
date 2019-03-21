package com.supermarket;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于自动生成的类
 * @version 1.0 created by chenyichang_fh on 2019/3/21 17:05
 */
public class Generator {

    public static void main(String[] args) throws Exception {
        //执行中的警告信息
        List<String> warings = new ArrayList<String>();
        //当生成代码重复时，覆盖原代码
        boolean overwrite = true;

        //读取配置
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建自动生成器
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warings);
        //执行
        myBatisGenerator.generate(null);
        //输出警告信息
        for (String war : warings) {
            System.out.println(war);
        }


    }
}
