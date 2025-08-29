package br.com.kleitonmarques.arquiteturaspring;

import br.com.kleitonmarques.arquiteturaspring.todos.MailSender;
import br.com.kleitonmarques.arquiteturaspring.todos.TodoRepository;
import br.com.kleitonmarques.arquiteturaspring.todos.TodoService;
import br.com.kleitonmarques.arquiteturaspring.todos.TodoValidator;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("passaword");

        Connection connection = dataSource.getConnection();
        EntityManager entityManager = null;

        TodoRepository repository = null; //new SimpleJpaRepository<TodoRepository, Integer>();
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender sender = new MailSender();
        TodoService todoService = new TodoService(repository, todoValidator, sender);

//        BeanGerenciado beanGerenciado = new BeanGerenciado(null);
//        beanGerenciado.setValidator(todoValidator);
//        if (codicao == true) {
//           beanGerenciado.setValidator();
//        }
    }
}
