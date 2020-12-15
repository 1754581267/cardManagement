package baoxiangyu.cardModule;

import baoxiangyu.cardTool.printFormat;
import baoxiangyu.cardTool.MyScan;
import baoxiangyu.cardTool.OptFile;

/**
 * @Description: 名片管理
 * @CreateTime: 2020-07-15-15-37
 */
public class CardMgr {

    private final static String CARD = "card.txt";

    //备份
    public static void backups() {
        printFormat.println("备份名片界面");
        String aim = MyScan.scan("请输入备份文件路径：");
        boolean b = MyScan.yesOrNo("是否备份？(yes/no):");
        printFormat.printlnEnd();
        if (b) {
            boolean b1 = OptFile.copyFile(CARD, aim);
            if (b1) {
                printFormat.print("备份成功");
            } else printFormat.print("备份失败");
        }
    }

    //恢复
    public static void recovery() {
        printFormat.println("备份名片界面");
        String aim = MyScan.scan("请输入恢复文件路径：");
        boolean b = MyScan.yesOrNo("是否恢复？(yes/no):");
        printFormat.printlnEnd();
        if (b) {
            boolean b1 = OptFile.copyFile(aim, CARD);
            if (b1) {
                printFormat.print("恢复成功");
            } else printFormat.print("恢复失败");
        }
    }
}
