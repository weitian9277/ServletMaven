package JDBC.eneity;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class State {
    private  int code;          //200
    private String Msg;         //密码错了  登录
    private String backups;
    private String backups1;
    private Object backups2;

    public State() {
    }

    public State(int code) {
        this.code = code;
    }

    public State(int code, String msg) {
        this.code = code;
        Msg = msg;
    }

    public State(int code, String msg,  String backups ,String backups1 ) {
        this.code = code;
        Msg = msg;
        this.backups = backups;
        this.backups1 = backups1;
    }

    public State(int code, String msg, String backups) {
        this.code = code;
        Msg = msg;
        this.backups = backups;
    }

    public State(int code, String msg, String backups, Object backups2) {
        this.code = code;
        Msg = msg;
        this.backups = backups;
        this.backups1 = backups1;
    }

    public State(int code, String msg, Object backups2) {
        this.code = code;
        Msg = msg;
        this.backups2 = backups2;
    }

    public String getBackups1() {
        return backups1;
    }

    public void setBackups1(String backups1) {
        this.backups1 = backups1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getBackups() {
        return backups;
    }

    public void setBackups(String backups) {
        this.backups = backups;
    }

    public Object getBackups2() {
        return backups2;
    }

    public void setBackups2(Object backups2) {
        this.backups2 = backups2;
    }
}
