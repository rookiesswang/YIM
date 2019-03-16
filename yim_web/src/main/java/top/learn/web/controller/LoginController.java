package top.learn.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.learn.common.Result;
import top.learn.common.ResultStatus;
import top.learn.entity.User;
import top.learn.service.UserService;
import top.learn.service.utils.MD5Utils;

@Controller
public class LoginController {

    public static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/")
    public String instance() {
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String account, String password) {
        Result result = new Result(ResultStatus.Error);
        User existUser = userService.findByAccount(account);
        log.info("帐户："+account+"正在尝试登陆！");
        if (existUser != null) {
            try {
                if (MD5Utils.validPassword(password,existUser.getPassword())) {
                    log.info("帐户："+account+"登陆成功");
                    result.setStatus(ResultStatus.Success);
                   
                    redisTemplate.opsForSet().add("User" + existUser.getAccount(),existUser);
                } else {
                    log.info("帐户："+account+"登陆密码错误");
                    result.setMsg("密码错误！");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            result.setMsg("账号错误！");
        }
        return result;
    }

}
