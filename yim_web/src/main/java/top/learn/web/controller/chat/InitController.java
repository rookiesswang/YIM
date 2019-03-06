package top.learn.web.controller.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.learn.common.IMResult;
import top.learn.entity.Friend;
import top.learn.entity.User;
import top.learn.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InitController {

    public static Logger log = LoggerFactory.getLogger(InitController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/chat/init",method=RequestMethod.GET)
    public IMResult initChat(User user) {
        IMResult imResult = new IMResult();
        imResult.setCode(0);
        try{
            Map<String, Object> data = new HashMap<>();
            User mine = userService.findByAccount(user.getAccount());
            List<Friend> friends = userService.findFriendsById(user.getUserId());
            log.info("用户好友名单为：" + friends);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
