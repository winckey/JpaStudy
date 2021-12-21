package jpabook.jpashop;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String Hellow(Model model){
//        Model객체???? 그럼 기본자료형은 어떻게 view에 전달을 해줄까?
//
//        1) 파라미터에 Model타입의 객체를 선언. 이후 addAttribute()를 통해 전달
//        2) @ModelAttribute 어노테이션 사용
//
//        Model 객체는 Controller 에서 생성된 데이터를 담아 View 로 전달할 때 사용하는 객체이다.
//        ※ Servlet의 request.setAttribute() 와 비슷한 역할을 함



        model.addAttribute("data" , "hello!!");
        return  "hello";// 화면이름
    }



}
