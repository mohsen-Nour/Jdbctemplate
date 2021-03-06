package nour.mohsen.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 *
 * @author mohsen
 */
public class AccountDaoJdbcImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

    }

    RowMapper<Account> fullColumnRowMapper = new RowMapper<Account>() {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getLong("id"));
            account.setOwnerName(rs.getString("owner_name"));
            account.setBalance(rs.getDouble("balance"));
            account.setAccessTime(rs.getTimestamp("access_time"));
            account.setLocked(rs.getBoolean("locked"));
            return account;
        }
    };

    @Override
    public void insert(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(List<Account> accounts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account find(long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account find(String ownerName) {
        return namedParameterJdbcTemplate.queryForObject("select id,owner_name,balance,access_time,locked from bank.account where owner_name =:ownerName"
                ,Collections.singletonMap("ownerName", ownerName), fullColumnRowMapper);
    }

    @Override
    public List<Account> find(List<Long> accountIds) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
                "accountIds", accountIds);
        return namedParameterJdbcTemplate.query("select * from bank.account where id in (:accountIds)", sqlParameterSource,fullColumnRowMapper);
    }

//    @Override
//    public List<Account> find(String ownerName) {
//
//    }
    
    @Override
    public List<Account> find(boolean locked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
