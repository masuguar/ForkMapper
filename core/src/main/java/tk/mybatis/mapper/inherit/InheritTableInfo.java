package tk.mybatis.mapper.inherit;

public class InheritTableInfo {

    private String mainTable;

    private String inheritTable;

    public InheritTableInfo() {
    }

    public InheritTableInfo(String mainTable, String inheritTable) {
        this.mainTable = mainTable;
        this.inheritTable = inheritTable;
    }

    public String getMainTable() {
        return mainTable;
    }

    public void setMainTable(String mainTable) {
        this.mainTable = mainTable;
    }

    public String getInheritTable() {
        return inheritTable;
    }

    public void setInheritTable(String inheritTable) {
        this.inheritTable = inheritTable;
    }
}
