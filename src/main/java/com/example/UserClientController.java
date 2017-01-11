package com.example;

import com.example.feign.NounClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags={"USER_CLIENT_SERVICE"})
public class UserClientController {

   /* @Autowired
    private RestTemplate restTemplate;*/
   @Autowired
   private DemoService service;

    @ApiOperation(value="注册方法", notes = "如题")
    @GetMapping("/register")
    public String register(){
       return service.register();
    }


    @Autowired
    private NounClient nounClient;

    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return
                "<h3>造句:</h3><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>"
                ;
    }

    public String buildSentence() {
        String sentence = "There was a problem assembling the sentence!";
        try{
            sentence =  nounClient.getWord();
        } catch ( Exception e ) {
            System.out.println(e);
        }
        return sentence;
    }

    /**
     * swagger-ui文档首页
     * @return
     */
    @ApiIgnore
    @RequestMapping("/info")
    public ModelAndView swaggerInfo() {
        String url="redirect:swagger-ui.html";
        return new ModelAndView(url);
    }
}
