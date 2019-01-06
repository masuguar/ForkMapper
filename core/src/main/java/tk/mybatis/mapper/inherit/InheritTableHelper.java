package tk.mybatis.mapper.inherit;

import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class InheritTableHelper {
    /**
     * 用于缓存已经存在的子表，
     */
    private static final Set<String> inheritTableSet = new ConcurrentSkipListSet<String>();

    public static boolean inheritTableExist( String inheritTable ){
        return inheritTableSet.contains(inheritTable);
    }

    /**
     * 底层是使用putIfAbsent实现的，因此不用加锁
     * @param inheritTable
     */
    public  static void addInheritTable( String inheritTable ){
        inheritTableSet.add(inheritTable);
    }

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
