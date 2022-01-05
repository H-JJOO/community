package dev.hjjoo.community.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("login")
    public void login() {}

    @GetMapping("/join")
    public void join() {}

    @GetMapping("/idChk/{uid}")//@PathVariable 변수명이랑 이름 맞춰야
    @ResponseBody//return 이 Json 으로 된다, 받을때는 RequestBody
    public Map<String, Integer> idChk(@PathVariable String uid) {
        System.out.println("uid : " + uid);

        Map<String, Integer> res = new HashMap<>();
        res.put("result", service.idChk(uid));

        return res;
        // {"result" : 1} 문자열을 Json 형태로 변환
    }


}
