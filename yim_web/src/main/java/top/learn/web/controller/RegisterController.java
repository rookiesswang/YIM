package top.learn.web.controller;

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

@Controller
public class RegisterController {

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
            User exisitUser = userService.findByAccount(user.getAccount());
            if (exisitUser != null) {
                result.setMsg("用户名已经存在，注册失败！");
                return result;
            }
            user.setPassword(MD5Utils.getEncryptedPwd(user.getPassword()));
            userService.registerUser(user);
            result.setMsg("注册成功！");
            result.setStatus(ResultStatus.Success);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setMsg("注册失败！");
        return result;
    }
}
