package nour.mohsen.jdbctemplate;

import java.sql.SQLException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author mohsen
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Ch4Configuration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
    }

}
