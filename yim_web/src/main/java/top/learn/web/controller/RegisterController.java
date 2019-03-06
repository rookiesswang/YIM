package top.learn.web.controller;

import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import top.learn.common.Result;
import top.learn.common.ResultStatus;
import top.learn.entity.User;
import top.learn.service.UserService;
import top.learn.service.utils.MD5Utils;
import top.learn.service.utils.RandomUtils;

@Controller
public class RegisterController {

    public static Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register")
    public String regist(){
        return "regist";
    }

    @RequestMapping(value="/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Result registerUser(User user) {
        Result result = new Result(ResultStatus.Error);
        try {
            Integer randomAccount = null;
            User exisitUser = null;

            for(;;) {
                //注册六位数字账号
                randomAccount = RandomUtils.getAcoountBySize(6);
                exisitUser = userService.findByAccount(String.valueOf(randomAccount));
                if (exisitUser == null) {
                    break;
                }
            }
            user.setAccount(String.valueOf(randomAccount));
            user.setPassword(MD5Utils.getEncryptedPwd(user.getPassword()));
            userService.registerUser(user);
            result.setMsg("注册成功！");
            result.setStatus(ResultStatus.Success);
            result.setData(user);
            log.info(user.getAccount() + "注册成功！");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setMsg("注册失败！");
        return result;
    }
}
