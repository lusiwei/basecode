package com.lusiwei.pojo;

public class Emp {
    private Integer emp_id;
    private Integer dept_id;
    private String emp_name;
    private Integer emp_age;
    private String emp_sex;

    public Emp() {
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Integer getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(Integer emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "emp_id=" + emp_id +
                ", dept_id=" + dept_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_age=" + emp_age +
                ", emp_sex='" + emp_sex + '\'' +
                '}';
    }
}
