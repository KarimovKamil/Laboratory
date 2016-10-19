package ru.itis.kpfu.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.kpfu.model.Credentials;
import ru.itis.kpfu.servlets.utils.MD5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CredentialsDaoJdbcTemplateImpl implements CredentialsDao {

    private DriverManagerDataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private MD5 md5 = new MD5();

    public CredentialsDaoJdbcTemplateImpl() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/laba");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void add(Credentials credentials) {
        String sql = "INSERT INTO credentials(id, login, password, salt) " +
                "VALUES (:id, :login, :password, :salt);";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", credentials.getId());
        params.put("login", credentials.getLogin());
        params.put("password", credentials.getPassword());
        params.put("salt", md5.encode(credentials.getPassword()));
        jdbcTemplate.update(sql, params);
    }

    public void update(Credentials credentials) {
        String sql = "UPDATE credentials SET (login, password, salt) " +
                "= (:login, :password, :salt) WHERE id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        if (credentials.getLogin().equals("")) {
            credentials.setLogin(findByPrimaryKey(credentials.getId()).getLogin());
        }

        if (credentials.getPassword().equals("")) {
            credentials.setPassword(findByPrimaryKey(credentials.getId()).getPassword());
        }

        params.put("id", credentials.getId());
        params.put("login", credentials.getLogin());
        params.put("password", credentials.getPassword());
        params.put("salt", md5.encode(credentials.getPassword()));

        jdbcTemplate.update(sql, params);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM credentials WHERE id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        jdbcTemplate.update(sql, params);
    }

    private RowMapper<Credentials> credentialMapper() {
        return (resultSet, i) -> {
            Credentials credential = new Credentials();
            credential.setId(resultSet.getLong("id"));
            credential.setLogin(resultSet.getString("login"));
            credential.setPassword(resultSet.getString("password"));
            credential.setSalt(resultSet.getString("salt"));
            return credential;
        };
    }

    public List findAll() {
        String sql = "SELECT * FROM credentials;";
        return jdbcTemplate.query(sql, credentialMapper());
    }

    public Credentials findByPrimaryKey(Long id) {
        String sql = "SELECT * FROM credentials WHERE id = :id;";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(sql, params, credentialMapper());
    }

    public Credentials findByName(String name) {
        String sql = "SELECT * FROM credentials WHERE login = :name;";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        return jdbcTemplate.queryForObject(sql, params, credentialMapper());
    }
}
