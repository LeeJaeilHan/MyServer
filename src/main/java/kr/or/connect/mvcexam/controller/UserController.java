package kr.or.connect.mvcexam.controller;

import kr.or.connect.mvcexam.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping(path = "/userform")
    public String userform(){
        return "userform";
    }

    @PostMapping(path="/regist")
    public String regist(@ModelAttribute User user){
        //가방처럼 가지고 다니는 DTO -> ModelAttribute
        //이전의 RequestParam을 사용하지 않고 ModelAttribute를 이용해서 쉽게 출력 가능
        return "regist";
    }


}
