package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GoodsController {

    @GetMapping(path = "/goods/{id}")
    public String getGoodsById(@PathVariable(name = "id") int id,
                               @RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent,
                               HttpServletRequest request,
                               ModelMap model){
        // @RequestMapping의 path에 변수명을 입력받기 위해선 place holder가 필요합니다
        // place holder name == PathVariable name 일 경우 mappinge 됩니
        // PathVariable을 사용해서 url path에 있는 변수를 받아올 수 있습니다.
        String path = request.getServletPath();
        System.out.println("ID: "+id);
        System.out.println("User Agent: "+userAgent);
        System.out.println("path: "+path);

        model.addAttribute("id",id);
        model.addAttribute("userAgent",userAgent);
        model.addAttribute("path",path);

        return "goodsById";
    }


}
