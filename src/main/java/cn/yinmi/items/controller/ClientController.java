package cn.yinmi.items.controller;

import cn.yinmi.items.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("/selectItemName")
    @ResponseBody
    public String[] selectItemName() {
        String[] str = clientService.selectItemName();
        return str;
    }

    @RequestMapping("/selectItemNumber")
    @ResponseBody
    public int selectItemNumber(String name){
        int num = clientService.selectItemNumber(name);
        return num;
    }

    @RequestMapping(value = "/commitForm")
    @ResponseBody
    public int commitForm(String data){
        int result = clientService.commitForm(data);
        return result;
    }
}
