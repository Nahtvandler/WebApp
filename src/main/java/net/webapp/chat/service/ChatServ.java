package net.webapp.chat.service;

import net.webapp.chat.dao.ChatDao;
import net.webapp.chat.model.Chat;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class ChatServ {
    private ChatDao chatDao;

    public void setChatDao(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    @Transactional
    public void createChat(Chat chat){
        this.chatDao.createChat(chat);
    }

    @Transactional
    public void deleteChat(int id){
        this.chatDao.deleteChat(id);
    }

    @Transactional
    public Chat getChatBID(int id){
        return this.chatDao.getChatBID(id);
    }

    @Transactional
    public List<Chat> listChats(){
        return this.chatDao.listChats();
    }

}
