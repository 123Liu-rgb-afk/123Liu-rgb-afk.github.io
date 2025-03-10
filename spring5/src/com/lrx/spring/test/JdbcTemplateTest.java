package com.lrx.spring.test;

import com.lrx.spring.bean.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午10:55
 */
public class JdbcTemplateTest {
    @Test
    public void test() {
        //JdbcTemplate jdbcTemplate = new JdbcTemplate();
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("jdbc.Template_ioc.xml");
        DataSource bean = ioc.getBean(DataSource.class);
        Connection connection = null;
        try {
            connection = bean.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(connection);
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ok");

    }

    @Test
    public void addByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.Template_ioc.xml");

        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);

        //1，添加语句1
//        String sql = "insert into monster values (400,'红','刘')";
//        jdbcTemplate.execute(sql);
//
//        System.out.println("ok");

        //2,添加语句2
        String sql = "insert into monster values (?,?,?)";
        int update = jdbcTemplate.update(sql, 500, "牛魔王", "吃饭");

        System.out.println("ok update: " + update);


    }

    @Test
    public void updateByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.Template_ioc.xml");

        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);

        // 1，添加语句1
//        String sql = "UPDATE monster SET skill = '变小' WHERE id = 500";
//        jdbcTemplate.execute(sql);
//
//        System.out.println("ok");

//        //2,修改语句2
//        String sql = "UPDATE monster SET skill = ? WHERE id = ?;";
//        int update = jdbcTemplate.update(sql, "变大","500");
//
//        System.out.println("ok update: " + update);

    }

    @Test
    public void addBatchByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate.xml");

        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
      /*
        public int[] batchUpdate(String sql, List<Object[]> batchArgs) throws DataAccessException {
            return this.batchUpdate(sql, batchArgs, new int[0]);
        }
       */
        String sql = "insert into monster values (?,?,?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{700, "老鼠精", "吃粮食"});

        list.add(new Object[]{8200, "老猫精", "吃老鼠"});

        int[] ints = jdbcTemplate.batchUpdate(sql, list);

        for (int anInt : ints) {
            System.out.println("anInt : " + anInt);
        }
        System.out.println("ok");

    }

    @Test
    public void selectByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.Template_ioc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "SELECT id AS monsterId,NAME,skill FROM monster WHERE id = 100";
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        Monster monster = jdbcTemplate.queryForObject(sql, rowMapper);
        System.out.println(monster);
    }
    @Test
    public void selectMulByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.Template_ioc.xml");

        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "SELECT id AS monsterId,NAME,skill FROM monster WHERE id >= 100";
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        List<Monster> monsterList = jdbcTemplate.query(sql, rowMapper);
        for (Monster monster : monsterList) {
            System.out.println("monster : " + monster);

        }

    }
    @Test
    public void selectScalarByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.Template_ioc.xml");

        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "SELECT NAME FROM monster WHERE id = 100";
        String s = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(s);


    }
    @Test
    public void namePraByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.Template_ioc.xml");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ioc.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);

        String sql = "insert into monster values (:monsterId, :name, :skill)";
        Monster monster = new Monster(1000, "猪八戒", "三十六变");
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(monster);


        int update1 = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println("update1: " + update1);
        Map<String, Object> params = new HashMap<>();
        params.put("monsterId",900);
        params.put("name","孙悟空");
        params.put("skill","七十二变");
        int update = namedParameterJdbcTemplate.update(sql, params);
        System.out.println("ok update: " + update);

    }
}
