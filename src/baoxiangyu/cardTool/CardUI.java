package baoxiangyu.cardTool;

/**
 * @Description: 界面UI
 * @CreateTime: 2020-07-15-15-17
 */
public class CardUI {
    //系统界面UI
    public static void mainUI() {
        System.out.print("***************欢迎使用名片管理系统***************\n" +
                         "1、注册\n" +
                         "2、登录\n" +
                         "3、退出\n" +
                         "************************************************\n" +
                         "请输入您选择的操作：");
    }

    //菜单界面UI
    public static String menuUI() {
        System.out.println("***************菜单界面***************\n" +
                           "1、新增名片\n" +
                           "2、修改名片\n" +
                           "3、删除名片\n" +
                           "4、搜索名片\n" +
                           "5、合并名片\n" +
                           "6、备份名片\n" +
                           "7、恢复名片\n" +
                           "8、退出系统");
        String s = MyScan.scan("请输入您选择的操作：");
        System.out.println("**************************************");
        return s;

    }


}
