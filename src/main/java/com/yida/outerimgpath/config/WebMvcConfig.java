package com.yida.outerimgpath.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 静态资源处理
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        /**
         * 解决程序外部静态资源无法访问的问题！
         * 注意：
         *  1）以下两行代码只有在发布jar包并运行时，才起作用!idea运行时是访问不了这里的imgPath；
         *  2）需要在发布jar包的同级目录，手动创建一个upload目录，里面再创建一个img目录存放图片；
         */
        String imgPath = path.getParentFile().getParentFile().getParent() + File.separator + "upload" + File.separator + "img" + File.separator;
        registry.addResourceHandler("/img/**").addResourceLocations(imgPath);

        //解决静态资源无法访问
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
