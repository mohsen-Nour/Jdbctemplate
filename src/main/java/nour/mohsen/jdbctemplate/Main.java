package nour.mohsen.jdbctemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author mohsen
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch4Configuration.class);
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        List<Long> list = new ArrayList<>();
        list.add(1l);

        Account account = accountDao.find(list).get(0);
        System.out.println(account.getId());
        System.out.println(account.getOwnerName());
        System.out.println(account.getBalance());
        System.out.println(account.getAccessTime());
        System.out.println(account.isLocked());
    }

}
