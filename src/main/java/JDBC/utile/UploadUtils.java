package JDBC.utile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class UploadUtils {
    public static void main(String[] args) {
//        String s = MakeNewFileName("aa.jpg");
//        MakeNewPath();
    }

    public static String MakeNewFileName(String filename){
        String string = UUID.randomUUID().toString().replace("-", "");
        return string+"_"+filename;
    }

    public static  String MakeNewPath( ){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(calendar.getTime()));

        return formatter.format(calendar.getTime())+"".replace("-", "_");
    }

    public static  String akeNewPath2( ){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(calendar.getTime()));

        return formatter.format(calendar.getTime())+"".replace("-", "_");
    }


    //遍历可以被下载的文件
    public  static  void  listFile(File dir, HashMap<String, String> map){
        File[] files = dir.listFiles();
        if(files != null && files.length>0){
            for (File file : files) {
                if(file.isDirectory()){
                    listFile(file, map);
                }else {
                    String uuidFileName = file.getName();
                    String fileName = uuidFileName.substring(uuidFileName.indexOf("_" )+1);
                    map.put(uuidFileName,fileName);
                }
            }
        }
    }
}
