package VerifyCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/code")
public class VerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 40;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获得画笔
        Graphics graphics = bufferedImage.getGraphics();
        //设置填充颜色
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, 0, width, height);
        //设置边框颜色
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);
        //写内容
        String str = "abcdefghijklmnopqrstuvwxyz";
        str += str.toUpperCase();
        str += "0123456789";
        System.out.println(str);
        graphics.setColor(Color.red);
        for (int i = 0; i < 4; i++) {
            int number = (int) (Math.random() * str.length());
            graphics.drawString(str.substring(number, number + 1), 20 + 15 * i, 20 + (int) Math.random() * 20);
        }
        graphics.setColor(Color.pink);
        for (int i = 0; i < 10; i++) {
            graphics.drawLine((int) (Math.random() * width), (int) (Math.random() * height), (int) (Math.random() * width), (int) (Math.random() * height));
        }
        ImageIO.write(bufferedImage, "png", resp.getOutputStream());
    }
}
