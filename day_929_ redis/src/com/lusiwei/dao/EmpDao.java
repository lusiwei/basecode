package com.lusiwei.dao;

import com.lusiwei.pojo.Dept;
import com.lusiwei.pojo.Emp;
import com.lusiwei.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmpDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtil.getDs());
    public List<Emp> queryEmpByDept(Integer dept_id) {
        String sql;
        List<Emp> query;
        if (dept_id == 0) {
            sql="select * from emp";
            query=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        }else {
            sql="select * from emp where dept_id=?";
            query=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class),dept_id);
        }
        return query;
    }

    public List<Dept> queryAllDept() {
        String sql="select * from dept";
        List<Dept> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
        return query;
    }

    public void addEmp(Emp emp) {
        String sql = "insert into emp values(?,?,?,?,?)";
        jdbcTemplate.update(sql, emp.getEmp_id(), emp.getDept_id(), emp.getEmp_name(), emp.getEmp_age(), emp.getEmp_sex());
    }
}