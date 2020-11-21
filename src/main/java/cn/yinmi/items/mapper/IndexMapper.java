package cn.yinmi.items.mapper;

import cn.yinmi.items.POJO.Order;
import cn.yinmi.items.POJO.Stock;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface IndexMapper {
    @Select("select * from stock")
    List<Stock> selectStock();

    @Select("select * from orderdata")
    List<Order> selectOrder();

    @Update("update orderdata set YN_SK = 'Y' WHERE ORDER_NO IN (#{str})")
    int fukuan(String str);

    @Update("update orderdata set YN_FH = 'Y' WHERE ORDER_NO IN (#{str})")
    int fahuo(String str);

    @Select("select ITEM_NAME from orderdata")
    List<String> selectItemName();

    @Update("update stock set NUMBER = NUMBER + #{number} where ITEM_NAME = #{name}")
    int inOutBound(String name,String number);

    @Delete("delete from orderdata WHERE ORDER_NO IN (#{str})")
    int deleteOrder(String str);
}
