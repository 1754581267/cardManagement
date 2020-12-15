package baoxiangyu.cardModule;

import baoxiangyu.cardTool.printFormat;
import baoxiangyu.cardTool.MyScan;
import baoxiangyu.cardTool.OptData;
import baoxiangyu.cardTool.OptFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 名片维护
 * @CreateTime: 2020-07-15-15-36
 */
public class CardMaintain {
    private final static String CARD = "card.txt";

    public static void newCard() {
        printFormat.println("新增名片界面");
        String name = MyScan.scan("请输入姓名：");
        String post = MyScan.scan("请输入职务：");
        String phone = MyScan.scan("请输入手机：");
        String cptname = MyScan.scan("请输入公司名称：");
        String address = MyScan.scan("请输入公司地址：");
        boolean yOrN = MyScan.yesOrNo("请输入是否保存(y/n)：");
        printFormat.printlnEnd();
        //是否保存
        if (yOrN) {
            String str = name + "-" + post + "-" + phone + "-" + cptname + "-" + address + "\n";
            if (OptFile.saveFile(CARD, str)) {
                printFormat.print("保存成功");
            } else printFormat.print("保存失败");

        }
    }

    //修改名片
    public static void edit() {
        try {
            while (true) {
                printFormat.println("修改名片界面");
                String name = MyScan.scan("请输入要修改名片的姓名：");
                BufferedReader br = new BufferedReader(new FileReader(CARD));
                String line = "";
                boolean find = false;
                while ((line = br.readLine()) != null) {
                    if (!"".equals(line)) {
                        //是否查找到了
                        find = line.startsWith(name+"-");
                        if (find) break;
                    }
                }
                br.close();
                //查找到后的操作
                if (find) {
                    System.out.println("您要修改的名片是："+ line);
                    String str = MyScan.scan("请输入修改的名片：");
                    boolean yOrN = MyScan.yesOrNo("是否修改？(yes/no):");
                    printFormat.printlnEnd();
                    if (yOrN) {
                        List<String> list = new ArrayList<>();
                        BufferedReader br1 = new BufferedReader(new FileReader(CARD));
                        String lin;
                        boolean fleg = false;
                        while ((lin = br1.readLine()) != null) {
                            if (!"".equals(lin)) { //判断是否是空
                                //是否是要修改的数据
                                if (!fleg && lin.startsWith(name + "-")) {
                                    list.add(str);//将修改的数据添加进去
                                    fleg = true;
                                } else list.add(lin);//不是的直接添加进集合
                            }
                        }
                        br1.close();
                        //将数据存入文件中
                        boolean b = OptFile.saveFile(CARD, list,false);
                        if (b) {
                            printFormat.print("修改成功");
                            break;
                        } else {
                            printFormat.print("修改失败");
                            break;
                        }
                    } else break;
                }
                printFormat.printlnEnd();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete() {
        try {
            while (true) {
                printFormat.println("删除名片界面");
                String name = MyScan.scan("请输入要删除名片的姓名：");
                String findData = OptData.findByName(CARD, name);
                if ("".equals(findData)) {
                    printFormat.print("未找到该名片");
                    break;
                } else {
                    //找到后的操作
                    System.out.println("您要删除的是名片是："+ findData);
                    boolean yOrN = MyScan.yesOrNo("是否删除？(yes/no):");
                    if (yOrN) {
                        List<String> list = OptData.delByName(CARD, name);
                        //将数据存入文件中
                        boolean b = OptFile.saveFile(CARD, list,false);
                        if (b) {
                            printFormat.print("删除成功");
                            break;
                        } else {
                            printFormat.print("删除失败");
                            break;
                        }
                    } else break;
                }

                //查找到后的操作
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
