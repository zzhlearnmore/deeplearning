package zzh.snake.game;
/*
   Images这个类专门用来游戏中所涉及到的图片，
 */

import javax.swing.*;
import java.net.URL;

public class Images {
    //面向对象，将图片进行封装，封装为一个对象，这样在程序中才可以通过操作这个对象来操作图片。
    //将图片所在的路径封装为一个对象：
    public static URL bodyURL =Images.class.getResource("/images/蛇身.png");
    //将图片封装为程序中一个对象：
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);
    //将图片所在的路径封装为一个对象：
    public static URL downURL =Images.class.getResource("/images/蛇头下.png");
    //将图片封装为程序中一个对象：
    public static ImageIcon downImg= new ImageIcon(downURL);
    //将图片所在的路径封装为一个对象：
    public static URL upURL =Images.class.getResource("/images/蛇头.png");
    //将图片封装为程序中一个对象：
    public static ImageIcon upImg = new ImageIcon(upURL);
    //将图片所在的路径封装为一个对象：
    public static URL leftURL =Images.class.getResource("/images/蛇头左.png");
    //将图片封装为程序中一个对象：
    public static ImageIcon leftImg = new ImageIcon(leftURL);
    //将图片所在的路径封装为一个对象：
    public static URL rightURL =Images.class.getResource("/images/蛇头右.png");
    //将图片封装为程序中一个对象：
    public static ImageIcon rightImg = new ImageIcon(rightURL);
    //将图片所在的路径封装为一个对象：
    public static URL foodURL =Images.class.getResource("/images/宝石.png");
    //将图片封装为程序中一个对象：
    public static ImageIcon foodImg = new ImageIcon(foodURL);
    //将图片所在的路径封装为一个对象：
    public static URL headerURL =Images.class.getResource("/images/标题.png");
    //将图片封装为程序中一个对象：
    public static ImageIcon headerImg = new ImageIcon(headerURL);
}
