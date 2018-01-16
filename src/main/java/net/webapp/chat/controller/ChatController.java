package net.webapp.chat.controller;

import net.webapp.chat.model.Chat;
import net.webapp.chat.model.User;
import net.webapp.chat.service.ChatServ;
import net.webapp.chat.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Controller
public class ChatController {
    private ChatServ chatServ;
    private UserServ userServ;

    @Autowired(required = true)
    @Qualifier(value = "chatServ")
    public void setChatServ(ChatServ chatServ) {
        this.chatServ = chatServ;
    }

    public void setUserServ(UserServ userServ) {
        this.userServ = userServ;
    }


    @RequestMapping(name = "login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("user")User user){
        List<User> users = this.userServ.getAllUsers();
        for (User person: users){
        }
        //!!! реализовать механизм авторизации
        return null;
    }

    @RequestMapping(value = "chats", method = RequestMethod.GET)
    public String chatList(Model model){
        model.addAttribute("chat", new Chat());
        model.addAttribute("chatlist", this.chatServ.listChats());
        return "chats";
    }


    @RequestMapping(value = "/chats/add", method = RequestMethod.POST)
    public String addChat(@ModelAttribute("chat") Chat chat){
        this.chatServ.createChat(chat);
        return "redirect:/chats";
    }

    @RequestMapping("/delete/{id}")
    public  String deleteChat(@PathVariable("id") int id){
        this.chatServ.deleteChat(id);
        return "redirect:/chats";
    }

    @RequestMapping("/chatroom/{id}")
    public String chatRoom(@PathVariable("id") int id, Model model){
        model.addAttribute("chatroom", this.chatServ.getChatBID(id));
        return "chatroom";
    }
}
