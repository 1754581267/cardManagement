package baoxiangyu.cardModule;

import baoxiangyu.cardTool.printFormat;
import baoxiangyu.cardTool.MyScan;
import baoxiangyu.cardTool.OptFile;

import java.io.*;

/**
 * @Description: 用户模块
 * @CreateTime: 2020-07-15-15-35
 */
public class AccountInfo {
    //用户数据存储位置
    private final static String LOGIN = "user.txt";
    private final static String CARD = "card.txt";


    //注册
    public static void register() {
        String name, pwd, pwd1;
        while (true) {
            printFormat.println("用户注册");
            name = MyScan.scan("请输入用户名：");
            pwd = MyScan.scan("请输入密码：");
            pwd1 = MyScan.scan("请再次输入密码：");
            printFormat.printlnEnd();
            if (pwd1.equals(pwd)) {

                break;
            }
            else printFormat.print("两次密码不相同！请重新输入");
        }
        String str = name +"->"+ pwd +"\n";
        if (OptFile.saveFile(LOGIN, str)) {
            printFormat.print("恭喜您，注册成功！");
        } else printFormat.print("注册失败！请稍后重试");
    }

    //登录
    public static boolean SignIn() {
        printFormat.println("用户登录");
        String name = MyScan.scan("请输入用户名：");
        String pwd = MyScan.scan("请输入密码：");
        printFormat.printlnEnd();
        try {
            BufferedReader br = new BufferedReader(new FileReader(LOGIN));
            String str = "";
            while ((str = br.readLine()) != null) {
                String[] arr = str.split("->");
                if (name.equals(arr[0]) && pwd.equals(arr[1]))
                    return true;
            }
            System.out.println("结束");
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
