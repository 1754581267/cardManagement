package baoxiangyu.cardTool;

import java.util.Scanner;

/**
 * @Description:
 * @CreateTime: 2020-07-19-15-51
 */
public class MyScan {
    //输入
    public static String scan(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.print(str);
        return scan.nextLine();
    }

    //判断yes  no
    public static boolean yesOrNo(String str) {
        String yesOrNo = MyScan.scan(str);
        if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("y")) {
            return true;
        } else return false;

    }

}
