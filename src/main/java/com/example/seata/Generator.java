package com.example.seata;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  逆向工程生成类.
 * </p>
 * @author 杨帮东 (qq:397827222)
 * @version 1.0
 * @date 2019/03/18 17:06
 **/
public class Generator {

    /**
     * 生成
     * @author 杨帮东
     * @param
     * @return void
     * @throws
     * @version 1.0
     * @date 2019/3/18 17:08
     */
    @Test
    public void genMybatisHelperClass() {

        List<String> warnings = new ArrayList<String>();
        String filePath = this.getClass().getClassLoader().getResource("generator.xml").getFile();
        File configFile = new File(filePath);
        ConfigurationParser cp = new ConfigurationParser(warnings);

        try {
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);

        } catch (Exception error) {
            error.printStackTrace();
        }

        for (String string : warnings) {
            System.out.println(string);
        }

        System.out.println("over.");
    }

}
