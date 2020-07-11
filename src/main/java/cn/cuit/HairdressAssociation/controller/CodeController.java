package cn.cuit.HairdressAssociation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Controller
@RequestMapping("/code")
public class CodeController {

    @RequestMapping("/getcode")
    public void code(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //使用JavaAPI绘制一张随机验证码图片，响应给页面
        int width=70; //宽度
        int height=28; //高度

        //获取一个画布  RED  GREEN BLUE 三原色
        BufferedImage b=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //画笔
        Graphics g = b.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        //画笔为黑色为黑色
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width-1, height-1);//把图片的边框画为黑色

        //生成随机验证码  大小字母和数字 62
        char[] array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' }; // 62

        String str = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66";
        char[] arrays = str.toCharArray();


        StringBuffer sb=new StringBuffer();

        //随机取四个
        Random r=new Random();
        for (int i =1; i <=4; i++) {
            int index=r.nextInt(array.length); //0-61下标
            String c = array[index]+""; //一个随机数
            sb.append(c);
            Font f=new Font("Arial", Font.BOLD, 16);
            g.setFont(f);
            // 0-255
            int red = r.nextInt(256);
            int green = r.nextInt(256);
            int blue = r.nextInt(256);
            Color color=new Color(red, green, blue); //随机色
            g.setColor(color);
            g.drawString(c, (width/5)*i, 18);
        }

        System.out.println("系统生成是正确验证码:"+sb.toString());

        request.getSession().setAttribute("syscode", sb.toString());

        //绘制干扰线
        for (int i =1; i <=8; i++) {
            int red = r.nextInt(256);
            int green = r.nextInt(256);
            int blue = r.nextInt(256);
            Color color=new Color(red, green, blue); //随机色
            g.setColor(color);

            int x1=r.nextInt(width);
            int y1=r.nextInt(height);

            int x2=r.nextInt(width);
            int y2=r.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }


        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(b, "jpeg", out);
    }

}
