package baoxiangyu.cardModule;

import baoxiangyu.cardTool.printFormat;
import baoxiangyu.cardTool.MyScan;
import baoxiangyu.cardTool.OptData;
import baoxiangyu.cardTool.OptFile;

import java.util.List;

/**
 * @Description: 名片操作
 * @CreateTime: 2020-07-15-15-36
 */
public class CardOpt {

    private final static String CARD = "card.txt";

    public static void find() {
        while (true) {
            printFormat.println("搜素名片界面");
            String name = MyScan.scan("请输入要搜索名片的条件：");
            String findData = OptData.findByName(CARD, name);
            if ("".equals(findData)) {
                printFormat.print("未找到相关的名片数据！");
            } else {
                System.out.println("符合条件的名片是："+ findData);
                boolean yOrN = MyScan.yesOrNo("是否继续搜索？(yes/no):");
                if (!yOrN) {
                    break;
                }
            }
            printFormat.printlnEnd();
        }
    }

    //合并名片
    public static void merge() {
        while (true) {
            printFormat.println("合并名片界面");
            String name = MyScan.scan("请输入要合并名片的姓名：");
            String findData = OptData.findByName(CARD, name);
            if (!"".equals(findData)) {
                String[] arr = findData.split("、");
                int size = arr.length;
                if (size == 1) {
                    printFormat.print("该名字只有一条名片信息，无需合并");
                } else {
                    System.out.println("符合条件的名片是：");
                    for (String str : arr) {
                        System.out.println(str);
                    }
                    boolean yOrN = MyScan.yesOrNo("是否合并？(yes/no):");
                    if (yOrN) {
                        //合并
                        String job = "";
                        String mobile = "";
                        String com = "";
                        String addr = "";
                        for (String line : arr) {
                            String[] split = line.split("-");
                            job += split[1] + ",";
                            mobile += split[2] + ",";
                            com += split[3] + ",";
                            addr += split[4] + ",";
                        }
                        job = OptData.delEnd(job);
                        mobile = OptData.delEnd(mobile);
                        com = OptData.delEnd(com);
                        addr = OptData.delEnd(addr);
                        String data = name + "-" + job + "-" + mobile + "-" + com + "-" + addr +"\n";
                        List<String> list = OptData.delByName(CARD, name);
                        list.add(data);//将合并的数据添加进去
                        //将数据存进文件中
                        boolean b = OptFile.saveFile(CARD, list, false);
                        if (b) {
                            printFormat.print("名片合并成功");
                        } else {
                            printFormat.print("名片合并失败");
                        }
                    } else {
                        printFormat.printlnEnd();
                        break;
                    }
                }
            } else {
                printFormat.print("未找到对应名片信息");
            }

        }

    }
    //合并名片
}
