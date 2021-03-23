package hibernatedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernatedemo.model.Message;
import hibernatedemo.util.HibernateUtil;

public class MessageDAO {
	public void saveMessage(Message m) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(m);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Message> getMessages() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Message", Message.class).list();
		}
	}
}
