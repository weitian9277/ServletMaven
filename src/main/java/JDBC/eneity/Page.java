package JDBC.eneity;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class Page {
    private  int  thisPage; //当前页
    private  int  totalPages; //总页数
    private  Object objList; //数据
    private  int   totalData;   //总条数

    public Page() {
    }

    public Page(int thisPage) {
        this.thisPage = thisPage;
    }

    public Page(int thisPage, int totalPages) {
        this.thisPage = thisPage;
        this.totalPages = totalPages;
    }

    public Page(int thisPage, int totalPages, Object objList) {
        this.thisPage = thisPage;
        this.totalPages = totalPages;
        this.objList = objList;
    }

    public Page(int thisPage, int totalPages, Object objList, int totalData) {
        this.thisPage = thisPage;
        this.totalPages = totalPages;
        this.objList = objList;
        this.totalData = totalData;
    }

    public int getThisPage() {
        return thisPage;
    }

    public void setThisPage(int thisPage) {
        this.thisPage = thisPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Object getObjList() {
        return objList;
    }

    public void setObjList(Object objList) {
        this.objList = objList;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }
}
