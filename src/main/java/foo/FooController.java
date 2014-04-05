package foo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Tom Mac
 * Date: 4/5/14
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/foo")
public class FooController {

    @RequestMapping(value = "/bar")
    @ResponseBody
    public String getBar(){
        return "I am Bar";
    }

}
