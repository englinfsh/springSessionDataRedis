package com.lin.feng.sheng.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController extends CommonController {


	@Value("${server.port}")
	private int port;
	@RequestMapping("/index/{name}")
    @ResponseBody
    public String index(@PathVariable String name,HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		logger.info("name="+name+"request,port="+port);

        if (null == name) {
            name = "boy!";
        }

        session.setAttribute("userName", name);

        Enumeration<String> pname= request.getParameterNames();
        if(pname!=null){
        	while (pname.hasMoreElements()) {
				String nn = (String) pname.nextElement();
				session.setAttribute(nn, request.getParameter(nn));
			}

        }


        return "hello world " + name;
    }

}
