package hibernatedemo;

import java.util.Date;
import java.util.List;

import hibernatedemo.dao.MessageDAO;
import hibernatedemo.model.Message;

public class App {
    public static void main(String[] args) {
        MessageDAO mDao = new MessageDAO();
        Message m = new Message();
        m.setText("Hello World "+ new Date());
        mDao.saveStudent(m);

        List<Message> ms = mDao.getStudents();
        ms.forEach(s -> System.out.println(s.getText()));
    }
}