package JDBC.eneity;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String realname;
    private String email;
    private String gender;
    private int flag;
    private int role;
    private double money;
    private  String img;
    private  String bookArr;

    public User(int id, String username, String password, String realname, String email, String gender, int flag, int role, double money, String img, String bookArr) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.email = email;
        this.gender = gender;
        this.flag = flag;
        this.role = role;
        this.money = money;
        this.img = img;
        this.bookArr = bookArr;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFlag() {
        return flag;
    }



    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBookArr() {
        return bookArr;
    }

    public void setBookArr(String bookArr) {
        this.bookArr = bookArr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", flag=" + flag +
                ", role=" + role +
                ", money=" + money +
                ", img='" + img + '\'' +
                ", bookArr='" + bookArr + '\'' +
                '}';
    }
}
