package com.lusiwei.service;

import com.lusiwei.dao.EmpDao;
import com.lusiwei.pojo.Dept;
import com.lusiwei.pojo.Emp;

import java.util.List;

public class EmpService {
    EmpDao empDao=new EmpDao();
    public List<Emp> queryEmpByDept(Integer dept_id) {
        List<Emp> emps = empDao.queryEmpByDept(dept_id);
        return emps;
    }

    public List<Dept> queryAllDept() {
        List<Dept> depts = empDao.queryAllDept();
        return depts;
    }
}
