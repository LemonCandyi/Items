package cn.yinmi.items.service;

import cn.yinmi.items.POJO.Order;
import cn.yinmi.items.POJO.Stock;
import cn.yinmi.items.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    private IndexMapper indexMapper;


    public List<Stock> selectStock() {
        List<Stock> result = indexMapper.selectStock();
        return result;
    }

    public List<Order> selectOrder() {
        List<Order> result = indexMapper.selectOrder();
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).getYn_fh().equals("Y")){
                result.get(i).setYn_fh("是");
            }else{
                result.get(i).setYn_fh("否");
            }
            if(result.get(i).getYn_sk().equals("Y")){
                result.get(i).setYn_sk("是");
            }else{
                result.get(i).setYn_sk("否");
            }
        }
        return result;
    }

    public String fukuan(String number) {
        String str = number.substring(9,number.length()-3).replace("\"","");
        if(str.length()>1){
            String[] strs = str.split(",");
            for (int i = 0; i < strs.length-1; i++) {
               indexMapper.fukuan(strs[i]);
            }
            return "2";
        }
        int temp = indexMapper.fukuan(str);
        String result = new Integer(temp).toString();
        return result;
    }

    public String fahuo(String number) {
        String str = number.substring(9,number.length()-3).replace("\"","");
        if(str.length()>1){
            String[] strs = str.split(",");
            for (int i = 0; i < strs.length-1; i++) {
                indexMapper.fahuo(strs[i]);
            }
            return "2";
        }
        int temp = indexMapper.fahuo(str);
        String result = new Integer(temp).toString();
        return result;
    }

    public List<String> selectItemName(){
        List<String> result = indexMapper.selectItemName();
        return result;
    }

    public String inOutBound(String data){
        String[] temp = data.replace("\"","").split(",");
        String crk = temp[0].substring(5);
        String name = temp[1].substring(5);
        String number = temp[2].substring(7,temp[2].length()-1);
        if(crk.equals("out")){
            number = new Integer((Integer.parseInt(number) * -1)).toString();
            return new Integer(indexMapper.inOutBound(name,number)).toString();
        }else if(crk.equals("in")){
            return new Integer(indexMapper.inOutBound(name,number)).toString();
        }
        return "error";
    }

    public String deleteOrder(String data){
        String str = data.substring(9,data.length()-3).replace("\"","");
        if(str.length()>1){
            String[] strs = str.split(",");
            for (int i = 0; i < strs.length-1; i++) {
                indexMapper.deleteOrder(strs[i]);
            }
            return "2";
        }
        int temp = indexMapper.deleteOrder(str);
        String result = new Integer(temp).toString();
        return result;
    }
}
