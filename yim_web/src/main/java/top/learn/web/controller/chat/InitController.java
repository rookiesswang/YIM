package top.learn.web.controller.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.learn.common.IMResult;
import top.learn.entity.*;
import top.learn.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InitController {

    public static Logger log = LoggerFactory.getLogger(InitController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/chat/init", method = RequestMethod.GET)
    @ResponseBody
    public IMResult initChat(@CookieValue("account")String account) {
        IMResult imResult = new IMResult();
        imResult.setCode(0);
        imResult.setMsg("");
        Map<String, Object> map = null;
        log.info("当前用户账户为：" + account);
        try {
            List<FriendMenu> friendMenus = new ArrayList<>();
            map = new HashMap<>();
            User mine = userService.findByAccount(account);
            log.info("当前用户为：" + mine);
            List<Friend> friends = userService.findFriendsById(mine.getUserId());
            log.info("用户好友名单为：" + friends);
            List<Group> groups = userService.findGroupsById(mine.getUserId());
            log.info("群组列表为：" + groups);
            for (Friend friend:friends
                 ) {
                FriendMenu lastMenu = null;
                UserVO userVO = null;
                if (friendMenus.size() != 0){
                    lastMenu = friendMenus.get(friendMenus.size()-1);
                }
                if (lastMenu == null || !friend.getMenuId().equals(lastMenu.getId())) {
                    FriendMenu friendMenu = new FriendMenu();
                    friendMenu.setId(friend.getMenuId());
                    friendMenu.setGroupname(friend.getMenuName());
                    userVO = new UserVO(friend);
                    friendMenu.getList().add(userVO);
                    friendMenus.add(friendMenu);
                } else {
                    lastMenu.getList().add(new UserVO(friend));
                }
            }
            log.info("朋友列表为：" + friendMenus);
            map.put("mine",new UserVO(mine));
            map.put("friend",friendMenus);
            map.put("group", groups);
            imResult.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imResult;
    }

}
