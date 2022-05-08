package zzh.snake.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

//将这个类继承Jpanel以后才具备面板的功能
public class GamePanel extends JPanel {
    //定义两个数组
    //蛇的长度
    int length;
    //一个数组存x轴坐标
    int[] snakeX = new int[200];
    //一个数组存y轴坐标
    int[] snakeY = new int[200];
    //游戏有两个状态，开始和暂停
    boolean isStart = false;//默认暂停
    //加入一个定时器
    Timer timer;
    //定义蛇的行走方向
    String direction;
    //定义食物的x，y 轴坐标
    int foodX;
    int foodY;
    //定义一个积分
    int score;
    //加入一个变量判定，判断小蛇死亡状态
    boolean isDie = false;//默认存活


    //初始化
    public void init(){
        //初始化蛇的长度为三
        length = 3;
        //初始化蛇头坐标
        snakeX[0] = 175;
        snakeY[0] =275;
        //初始化第一阶身体坐标
        snakeX[1] = 150;
        snakeY[1] =275;
        //初始化第二节身子坐标
        snakeX[2] = 125;
        snakeY[2] =275;
        //初始化蛇头方向
        direction = "R"; //R U L D
        //初始化食物的x，y 轴坐标
            foodX = 300;
            foodY = 200;



    }
    public GamePanel(){
        init();
        //将焦点定位在当前程序的面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {//监听键盘按键的按下操作
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                if(keyCode==KeyEvent.VK_SPACE){
                    if(isDie){
                        //shushihua
                        init();
                        isDie=false;
                    }else{
                        isStart =!isStart;
                        repaint();
                    }

                }
                //监听向上箭头
                            if(keyCode==KeyEvent.VK_UP){
                                direction = "U";
                            }

                //监听向下箭头
                            if(keyCode==KeyEvent.VK_DOWN){
                                direction = "D";
                            }
                //监听向左箭头
                            if(keyCode==KeyEvent.VK_LEFT){
                                direction = "L";
                            }
                //监听向右箭头
                            if(keyCode==KeyEvent.VK_RIGHT){
                                direction = "R";
                            }

            }
        });
        //对定时器进行初始化操作
        timer = new Timer(100, new AbstractAction() {
            //AbstractAction是事件监听，相当于每一百毫秒监听一下是否发生了一个动作
            //具体的动作放入 actionPerformed里面
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isStart&&isDie==false){
                    //游戏是开始状态时蛇才动
                    //后一截身子走到前一节身子的位置上
                    for (int i = length-1; i >0 ; i--) {
                        snakeX[i] = snakeX[i - 1];
                        snakeY[i] = snakeY[i - 1];
                    }
                        //动蛇头
                        if ("R".equals(direction)){
                            snakeX[0] += 25;
                        }
                        if ("U".equals(direction)){
                            snakeY[0] -= 25;
                        }
                        if ("L".equals(direction)){
                            snakeX[0] -= 25;
                        }
                        if ("D".equals(direction)){
                            snakeY[0] += 25;
                        }

                        //防止蛇超出边界：
                        if(snakeX[0]>750){
                            snakeX[0] = 25;
                        }
                        if(snakeX[0]<25){
                            snakeX[0] = 750;
                        }
                        if(snakeY[0]<100){
                            snakeY[0] = 725;
                        }
                        if(snakeY[0]>725){
                            snakeY[0] = 100;
                        }
                        //检测吃屎的动作
                        if(snakeX[0] == foodX&&snakeY[0] == foodY){
                            //蛇的长度加1
                            length++;
                            //食物的坐标随机发生改变，须为25的倍数
                            //调用math.random()
                             foodX =(int)((Math.random()*30)+1)*25;//[25,750]
                             foodY =(new Random().nextInt(26)+4)*25;//[100,725]
                            //吃上大便，积分加10
                            score +=10;
                        }
                    //死亡判断
                    //和任意一截碰撞都死
                    for (int i = 1; i <length ; i++) {
                        if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                            //将死亡状态改为true
                            isDie=true;

                        }

                    }
                    repaint();//重绘界面
                }

            }
        });
        //定时器必须要启动：
        timer.start();

    }


    //这个方法较为特殊，属于图形版的main方法，自动调用
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //填充背景颜色
        this.setBackground(new Color(245, 221, 221));
        //画头部图片,paintIcon对应四个参数this指当前面板 g是指使用的画笔
        Images.headerImg.paintIcon(this,g,10,10);
        //调节画笔颜色
        g.setColor(new Color(163, 246, 134));
        //画一个矩形
        g.fillRect(10,70,770,685);
        //画小蛇：
        //画蛇头：
        if("R".equals(direction)){
        Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("U".equals(direction)){
            Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("D".equals(direction)){
            Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("L".equals(direction)){
            Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        //画蛇身子：
//        //diyijie
//        Images.bodyImg.paintIcon(this,g,snakeX[1],snakeY[1]);
//        //dierjie
//        Images.bodyImg.paintIcon(this,g,snakeX[2],snakeY[2]);
        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //如果游戏是暂停的界面中间就应该有一句提示语
        if(isStart == false){
            //画一个文字
            g.setColor(new Color(1,1,1));
            // 字体    加粗     字号
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //画文字:三个参数 文字内容   x轴坐标   y 坐标
            g.drawString("点击空格彬彬开始吃便便",250,330);

        }
        //画食物
        Images.foodImg.paintIcon(this,g,foodX,foodY);
        //画积分
        g.setColor(new Color(192, 21, 21));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("积分："+score,620,40);
        //画入死亡状态
        if (isDie){
            g.setColor(new Color(171, 25, 25));
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            g.drawString("彬彬被屎噎死了，按下空格彬彬remake！",200,200);
        }


    }
}
