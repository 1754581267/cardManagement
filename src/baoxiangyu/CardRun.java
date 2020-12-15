package baoxiangyu;

import baoxiangyu.cardModule.AccountInfo;
import baoxiangyu.cardModule.CardMaintain;
import baoxiangyu.cardModule.CardMgr;
import baoxiangyu.cardModule.CardOpt;
import baoxiangyu.cardTool.printFormat;
import baoxiangyu.cardTool.CardUI;

import java.util.Scanner;

/**
 * @Description: 名片管理系统总代码
 * @CreateTime: 2020-07-15-15-18
 */
public class CardRun {

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            CardUI.mainUI();
            int opt = scan.nextInt();
            if (opt == 1) {
                //注册
                AccountInfo.register();
            }
            else if (opt == 2) {
                //登录
                if (AccountInfo.SignIn()) {
                    printFormat.print("登录成功");
                    //菜单界面
                    while (true) {
                        int a = Integer.parseInt(CardUI.menuUI());
                        if (a == 1) {//新增名片
                            CardMaintain.newCard();
                        } else if (a == 2) {//修改名片
                            CardMaintain.edit();
                        } else if (a == 3) {//删除名片
                            CardMaintain.delete();
                        } else if (a == 4) {//搜素名片
                            CardOpt.find();
                        } else if (a == 5) {//合并名片
                            CardOpt.merge();
                        } else if (a == 6) {//备份名片
                            CardMgr.backups();
                        } else if (a == 7) {//恢复名片
                            CardMgr.recovery();
                        } else if (a == 8) {
                            printFormat.print("已退出至主界面");
                            break;
                        } else System.out.println("没有该服务");

                    }
                } else printFormat.print("登录失败");
            }
            //退出
            else if (opt == 3) {
                printFormat.print("结束服务");
                break;
            }
        }

    }

}
