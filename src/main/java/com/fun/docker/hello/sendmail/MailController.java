package com.fun.docker.hello.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    @ResponseBody
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send() {
        mailService.sendMail("r u ok", "i am fine");
    }

    @ResponseBody
    @RequestMapping(value = "/sendInvoice", method = RequestMethod.GET)
    public void sendInvoice() {
        mailService.sendAttachmentsMail("zzzhaoxy@163.com", "发票1", "您的发票已到1", "E:\\Wechatworkface\\WeChat Files\\zxy_step\\FileStorage\\File\\2019-07\\test.pdf");
        System.out.println("merge test");
    }
}
