package net.webapp.chat.dao;


import net.webapp.chat.model.Chat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Chat> getAllMessage(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Chat> messList = session.createQuery("from chat").list();
        return messList;
    }

    public void createChat(Chat chat){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(chat);
        //здесь необходимо "создавать новый чат" но не совсем понятно как организовать это в структуре бд
        //upd Создаем новый чат как обьект с именем и айди, в данный момент планируется использовать
        //сущность чат-комнаты только как id при создании сокета, т.е каждая чат-комната это массив сокетов
        //подключенных к ней. В такой модели сообщения не сохраняются а пересылаются напрямую сокетам
        //но реализация модели с сохранением в бд мне не ясна, одна сущность-одна таблица.
        //если создавать чат комнаты как новые таблицы, в таком случае надо что-то придумывать с сущностями.
        //проще логировать сообщения и хранить на сервере, а бд использовать исключительно для хранения данных
        //о юзверях и чат комнатах
    }

    public void deleteChat(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Chat chat = (Chat) session.load(Chat.class, new Integer(id));
        if (chat!=null){
            session.delete(chat);
        }
        //аналогично с созданием, только удаление.
    }

    public Chat getChatBID(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Chat chat = (Chat) session.load(Chat.class, new Integer(id));
        return chat;
    }

    public List<Chat> listChats(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Chat> chatList = session.createQuery("from chat").list();
        return chatList;
    }
}
