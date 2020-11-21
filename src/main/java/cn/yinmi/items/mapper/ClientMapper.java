package cn.yinmi.items.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClientMapper {
    @Select("select ITEM_NAME from stock")
    public String[] selectItemName();

    @Select("select NUMBER from stock where ITEM_NAME = #{name}")
    int selectItemNumber(@Param("name")String name);

    @Select("select ITEM_NO from stock where ITEM_NAME = #{name}")
    int selectItemNo(@Param("name")String name);

    @Insert("insert into orderdata (ITEM_NO,iTEM_NAME,USER_NAME,TEL,ADDR) values (#{ITEM_NO},#{ITEM_NAME},#{USER_NAME},#{TEL},#{ADDR})")
    int insertData(String ITEM_NO,String ITEM_NAME,String USER_NAME,String TEL,String ADDR);
}
