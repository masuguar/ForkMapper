package tk.mybatis.mapper.entity;

import tk.mybatis.mapper.inherit.InheritTableFormatter;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.util.StringUtil;

public class InheritTableHelper {
    public static String getInheritTableName(Object parameter, EntityTable entityTable) throws InstantiationException, IllegalAccessException {
        InheritTableFormatter formatter = entityTable.getFormatter().newInstance();
        StringBuilder sb = new StringBuilder(16);
        String preffix = formatter.preffix(parameter);
        if(StringUtil.isNotEmpty( preffix )){
            sb.append( preffix ).append(entityTable.getSplitKey());
        }
        sb.append(entityTable.getName());
        String suffix = formatter.suffix(parameter);
        if( StringUtil.isNotEmpty(suffix) ){
            sb.append(entityTable.getSplitKey())
                    .append(suffix);
        }
        return sb.toString().toLowerCase();
    }

    public static String getInheritTableName( Object parameter ) throws IllegalAccessException, InstantiationException {
        EntityTable entityTable = EntityHelper.getEntityTable(parameter.getClass());
        return getInheritTableName(parameter,entityTable);
    }
}
