package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//componentscan으로 이 controller를 찾을 것
@Controller
public class PlusController {
    //RequestMapping 어노테이션 -> controller 메소드와 http 요청을 연결하는 어노테이션
    //get request에서 url-mapping 부분이 plusform일 경우
    @GetMapping(path = "/plusform")
    public String plusform(){
        return "plusForm";
    }

    //post request 일 경우 이 메소드와 해당 http post request를 연결해주는 어노테이션
    //RequestParam 어노테이션은 mapping된 메서드에 붙일 수 있다
    //RequestParam의 name을 HTTP name과 매핑해준(아까 form태그 input상자의 name), required로 필수인지 아닌지 판
    @PostMapping(path="/plus")
    public String plus(@RequestParam(name = "value1", required = true) int value1,
                       @RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
        int result = value1 + value2;

        //modelmap 넣어주면 spring이 이 부분을
        //request scope에 알아서 매핑해준다
        //그래야 jsp에서 request scope에서 값들을 꺼내갈 수 있다
        //map은 key, value 형식 "Value1"키에 value1 값을 넣겠
        modelMap.addAttribute("value1", value1);
        modelMap.addAttribute("value2", value2);
        modelMap.addAttribute("result", result);
        return "plusResult"; //view 이름 반환 -> viewResolver를 통해 pluseReslt라는 뷰를 찾아냄
    }
}
