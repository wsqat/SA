package com.ustc.overwatch;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class SampleController extends WebMvcConfigurerAdapter {

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";
    private Map<String,Object> map;
    /**
     * 登录session key
     */
//    public final static String SESSION_KEY = "user";

    //index页面
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        return "login";
    }

    //登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    //登录方法
    @RequestMapping("/addlogin")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username："+username+" password:"+password);
        if ( username.equals("admin") && password.equals("123456")){
            System.out.println("index");
//            return "blank";
//            map.put("name","admin");
            return "redirect:/index";
        } else {
            System.out.println("login");
            return "redirect:/login";
        }
    }

    @RequestMapping("/tables")
    public String tables(Map<String, Object> model) {
        return "tables";
    }

    @RequestMapping("/dynamic")
    public String dynamic(Map<String, Object> model) {
        return "data_dynamic";
    }

    @RequestMapping("/history")
    public String history(Map<String, Object> model) {
        return "data_history";
    }

    @RequestMapping("/config")
    public String config(Map<String, Object> model) {
        return "config";
    }

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    //FastJson实现
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        //  初始化转换器
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        //  初始化一个转换器配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //  将配置设置给转换器并添加到HttpMessageConverter转换器列表中
        fastConvert.setFastJsonConfig(fastJsonConfig);

        converters.add(fastConvert);
    }

}
