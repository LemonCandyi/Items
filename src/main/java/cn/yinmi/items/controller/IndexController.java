package cn.yinmi.items.controller;

import cn.yinmi.items.POJO.Order;
import cn.yinmi.items.POJO.Stock;
import cn.yinmi.items.mapper.IndexMapper;
import cn.yinmi.items.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Stock> selectAll(){
        List<Stock> resule = indexService.selectStock();
        return resule;
    }

    @RequestMapping("/selectOrder")
    @ResponseBody
    public List<Order> selectOrder(){
        List<Order> result = indexService.selectOrder();
        return result;
    }

    @RequestMapping("/fukuan")
    @ResponseBody
    public String fukuan(@RequestBody String number){
        String result = indexService.fukuan(number);
        return result;
    }

    @RequestMapping("/fahuo")
    @ResponseBody
    public String fahuo(@RequestBody String number){
        String result = indexService.fahuo(number);
        return result;
    }

    @RequestMapping("/selectItemNameBY")
    @ResponseBody
    public List<String> selectItemName(){
        List<String> result = indexService.selectItemName();
        return result;
    }

    @RequestMapping("/inOutBound")
    @ResponseBody
    public String inOutBound(@RequestBody String data){
        String result = indexService.inOutBound(data);
        return result;
    }
}
