package baoxiangyu.cardTool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @CreateTime: 2020-07-19-16-39
 */
public class OptData {

    //更加姓名查找
    public static String findByName(String fileName, String name) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String findData = "";
            String line = "";
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    //是否查找到了
                    boolean find = line.startsWith(name + "-");
                    if (find) {
                        findData += line + "、";
                    }
                }
            }
            br.close();
            return delEnd(findData);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //删除最后的符号
    public static String delEnd(String data) {
        if (!"".equals(data)) {
            data = data.substring(0,data.length()-1);
        }
        return data;
    }

    public static List<String> delByName(String fileName, String name) {
        try {
            List<String> list = new ArrayList<>();
            BufferedReader br1 = new BufferedReader(new FileReader(fileName));
            String lin = "";
            while ((lin = br1.readLine()) != null) {
                if (!"".equals(lin)) { //判断是否是空
                    //是否是要删除的数据
                    if (!lin.startsWith(name + "-")) {
                        list.add(lin);
                    }
                }
            }
            br1.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
