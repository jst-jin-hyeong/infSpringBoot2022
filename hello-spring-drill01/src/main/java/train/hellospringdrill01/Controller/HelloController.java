package train.hellospringdrill01.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    hello.html -- 문서에 parameter 없이 쓰는법(문서에 값을 반영하므로 Model은 필요하다)
//    return: html  | param: X   | Model: O
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hellooooooooooooo!!!!!!!!!!!!!!!!!!!!!");
        return "hello";
    }

//    hello-template.html -- 문서에 parameter를 쓰므로 @RequestParam 어노테이션을 써야햐한다. 그리고 문서에 값을 반영하므로 Model은 필요하다
//    return: html | param: O | Model: O
    @GetMapping("hello-template")
    public String helloTemplate(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

//    no html -- 문서를 쓰지 않으므로 model은 필요 없고 Param은 필요하다.
//    return: String | param: O  | Model: X
    @GetMapping("hello-nohtml")
    @ResponseBody
    public String helloNohtml(@RequestParam(value="name", required = false) String name){
        return "hello" + name;
    }

//    api --html을 안 쓰니까 Model이 필요 없겠네? 대신 클래스가 필요하다
//    return: JSON(객체. api) | Param: 0 | Model: X
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value="name", required = false) String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    public static class Hello{
    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    }
}