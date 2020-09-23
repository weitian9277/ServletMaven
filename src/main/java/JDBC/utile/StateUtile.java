package JDBC.utile;

import com.alibaba.fastjson.JSONObject;
import JDBC.eneity.State;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class StateUtile {
    public static Object  succeedMsg2(Object object){
        State state = null;
        if(object != null){
            state = new State(200,"成功",object);
        }else {
            state = new State(200,"成功");
        }
        return  state;
    }
    public static String  succeedMsg(Object object){
        State state = null;
        if(object != null){
              state = new State(200,"成功",object);
        }else {
            state = new State(200,"成功");
        }

        JSONObject jsonObject = new JSONObject();

      return  jsonObject.toJSONString(state);
    }
    public static Object  errorMsg2(Object object){
        State state = null;
        if(object != null){
            state = new State(-1,"失败",object);
        }else {
            state = new State(-1,"失败");
        }


        return  state;
    }
    public static String  errorMsg(Object object){
        State state = null;
        if(object != null){
            state = new State(-1,"失败",object);
        }else {
            state = new State(-1,"失败");
        }
        JSONObject jsonObject = new JSONObject();

        return  jsonObject.toJSONString(state);
    }
}
