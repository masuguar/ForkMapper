package tk.mybatis.mapper.inherit;

public enum InheritQueryDialect {

    POSTGRESSQL("select count(*) userId from pg_class where relname =#{tableName}")
    ;

    private String queryTableStatement;

    InheritQueryDialect(String queryTableStatement) {
        this.queryTableStatement = queryTableStatement;
    }

    public String getQueryTableStatement() {
        return queryTableStatement;
    }
}
