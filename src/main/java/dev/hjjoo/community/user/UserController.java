package dev.hjjoo.community.user;

import dev.hjjoo.community.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/join")
    public String joinProc(UserEntity entity, RedirectAttributes reAttr) {
        int result = service.join(entity);
        switch (result) {
            case 1:
                //TODO - 회원가입 성공하면 로그인 처리
                return "redirect:/user/login";
        }
        reAttr.addFlashAttribute("msg", "회원가입에 실패하였습니다.");
        return "redirect:/user/join";
    }

    @PostMapping("login")
    public String login(UserEntity entity, RedirectAttributes reAttr) {
        int result = service.login(entity);
        switch (result) {
            case 0:
                reAttr.addFlashAttribute("msg", "오류가 발생하였습니다.");
                break;
            case 1:
                return "redirect:/board/list";
            case 2:
                reAttr.addFlashAttribute("msg", "아이디를 확인하십시오.");
                break;
            case 3:
                reAttr.addFlashAttribute("msg", "비밀번호를 확인하십시오,");
                break;
        }
        reAttr.addFlashAttribute("msg", "회원가입을 실패하였습니다.");
        return "redirect:/user/login";
    }


}
