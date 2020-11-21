package cn.yinmi.items.service;

import cn.yinmi.items.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientMapper clientMapper;

    public int selectItemNumber(String name) {
        int num = clientMapper.selectItemNumber(name);
        return num;
    }

    public String[] selectItemName(){
        String[] result = clientMapper.selectItemName();
        return result;
    }


    public int commitForm(String data) {
        String[] str = data.split(",");
        System.out.println(str);
        String itemname =str[0].substring(5);
        String name = str[1].substring(5);
        String tel = str[2].substring(4);
        String addr = str[3].substring(5);
        String itemno =new Integer( clientMapper.selectItemNo(itemname)).toString();
        int result = clientMapper.insertData(itemno,itemname,name,tel,addr);
        return result;
    }
}
