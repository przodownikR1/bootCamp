package pl.java.scalatech.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {
    @RequestMapping("/ping")
    String ping(){
        return "pong";
    }
    
}
