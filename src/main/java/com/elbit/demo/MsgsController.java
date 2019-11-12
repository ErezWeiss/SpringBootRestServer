package com.elbit.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MsgsController {

    @RequestMapping("/")
    public String index() {
        System.out.println("any request was catched");
        return "Congratulations from MsgsController.java";
    }

    @RequestMapping(path = "/getMsg", method=RequestMethod.GET)
    public String GetMessage(){
        System.out.println("get request!!!");
        return MsgsContainer.getInstance().GetAllMsgsSinceMidnight();
    }

    @RequestMapping(path = "/postMsg", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message postMessage(@RequestBody Message message) {
        System.out.println("post request was inputted");
        MsgsContainer.getInstance().AddMsg(message);
        System.out.println(MsgsContainer.getInstance().toString());
        MsgsContainer.getInstance().GetAllMsgsSinceMidnight();
        return message;
    }

}