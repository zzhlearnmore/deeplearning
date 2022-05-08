package zzh.snake.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class StartGame {
    public static void main(String[] args) {
        //创建一个窗体
        JFrame jf = new JFrame();
        //给窗体设置一个标题
        jf.setTitle("彬彬贪吃屎 by zzh");
        //设置窗体弹出的对应坐标，对应窗体的宽和高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height= Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-800)/2,(height-800)/2,800,800);
        //设置窗体大小锁定
        jf.setResizable(false);
        //创建面板：
        GamePanel gp = new GamePanel();
        //将面板放入窗体中
        jf.add(gp);
        //guangbi
        jf.setDefaultCloseOperation(2);
        //默认情况下窗体隐藏，必须将窗体显现,显现的方法最好放在最后，否则之间的方法可能不出现
        jf.setVisible(true);
    }
}
