//姓名+时间
//整数型和浮点(小数)型的自动转换和强制转换
public class Homework3_1 {
    //(1)整数常量默认是int型常量
    //(2)小数常量默认是double型常量
    public static void main(String args[]){
        //正常的赋值
        int a = 1;
        long b = 2L;
        float c = 3.0f;
        double e = 4.0;

        //隐形(自动)转换, 容量小的自动转为容量大的
        //byte，short，char->int->long->float->double
        long f = 5;
        float g = 5;//
        double h = 5;
        double i = 5.1f;

        //强制转换, 容量大的强制转为容量小的
        int j = (int)6L; //long 强制变为int
        int k = (int)f;

        int l = (int)7.1;//double 强制变为int
        System.out.println(l);//这里的l是多少呢  7
        int m = (int)i;//m 5
        float x = (float)i;

        //特别的byte short char
        byte o = 17; //int型常量赋值给byte, 特殊的不需要强制转换
        short p = 12;
        char r = 65; //char r = 'A'

        byte s = (byte)a; //int型变量赋值给byte, 大容量给小容量, 需要强制转换
        short t = (short)a; //int型变量赋值给short, 大容量给小容量, 需要强制转换
        char y = (char)a; //int型变量赋值给x, 大容量给小容量, 需要强制转换


    }
}
