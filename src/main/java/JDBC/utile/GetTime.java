package JDBC.utile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class GetTime {
    public  static  String getThisTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }
}
