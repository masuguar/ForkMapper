package tk.mybatis.mapper.inherit;

public interface InheritTableFormatter<T> {

    public String preffix(T t);

    public String suffix(T t);
}
