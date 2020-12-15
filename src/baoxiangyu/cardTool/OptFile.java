package baoxiangyu.cardTool;

import java.io.*;
import java.util.List;

/**
 * @Description: * @CreateTime: 2020-07-19-15-52
 */
public class OptFile {

    //文件保存
    public static boolean saveFile(String fileName, String str) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName,true);
            fos.write(str.getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //文件保存 集合
    public static boolean saveFile(String fileName, List<String> strList, boolean append) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName,append);
            for (String s: strList) {
                fos.write((s +"\n").getBytes());
            }
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //复制文件数据
    public static boolean copyFile(String fileName, String aimFileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(aimFileName));
            String lien = "";
            while ((lien = br.readLine()) != null) {
                bw.write(lien);
                bw.newLine();
            }
            bw.close();
            br.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
