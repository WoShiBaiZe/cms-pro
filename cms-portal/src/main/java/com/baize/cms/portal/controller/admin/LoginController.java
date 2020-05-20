package com.baize.cms.portal.controller.admin;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private Producer captchaProduce;

    @GetMapping("login.do")
    public String toLogin(){
        return "/admin/login";
    }

    @GetMapping("captcha.do")
    public void doCaptcha(HttpServletResponse httpServletResponse){
        String text = captchaProduce.createText();
        BufferedImage image = captchaProduce.createImage(text);
//        ServletOutputStream outputStream = null;
        //JDK1.7以后语法糖写法，自动关闭流
        try(ServletOutputStream outputStream = httpServletResponse.getOutputStream()) {
            ImageIO.write(image,"jpg",outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        
        //JDK1.7以前，需要自己手动关闭流
//        try {
//            outputStream = httpServletResponse.getOutputStream();
//            ImageIO.write(image,"jpg",outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
