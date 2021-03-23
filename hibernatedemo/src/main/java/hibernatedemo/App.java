package hibernatedemo;

import java.util.Date;
import java.util.List;

import hibernatedemo.dao.MessageDAO;
import hibernatedemo.model.Message;

public class App {
    public static void main(String[] args) {
        MessageDAO dao = new MessageDAO();
        Message m = new Message();
        m.setText("Hello World "+ new Date());
        dao.saveMessage(m);

        List<Message> ms = dao.getMessages();
        ms.forEach(s -> System.out.println(s.getText()));
    }
}