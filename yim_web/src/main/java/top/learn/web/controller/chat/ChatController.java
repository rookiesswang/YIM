package top.learn.web.controller.chat;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/index")
    public String init(){
        return "index";
    }
}
