package com.pruebas;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import com.pruebas.entidades.User;

@Controller
public class IndexController {
    
    @RequestMapping(value={"/index.htm","/"})
    public String IndexPage(){
        return "index";
    }
    public User createUser(){
        return new User();
    }

    public Event validateUser(User user,MessageContext messageContext){
        MessageBuilder error = new MessageBuilder().error();
        Boolean errorform = false;
        System.out.println("username : "+user.getUsername());
        if(user.getUsername().equals("")) {
            error.source("username");
            error.defaultText("The username is required !");
            messageContext.addMessage(error.build());
            errorform = true;
        }
        if(user.getPassword().equals("")) {
            error.source("password");
            error.defaultText("The password is required !");
            messageContext.addMessage(error.build());
            errorform = true;
        }
        if(user.getEmail().equals("")) {
            error.source("email");
            error.defaultText("The email is required !");
            messageContext.addMessage(error.build());
            errorform = true;
        }
        if (errorform) {
            return new EventFactorySupport().error(this);
        } else
            return new EventFactorySupport().success(this);
    }   
}