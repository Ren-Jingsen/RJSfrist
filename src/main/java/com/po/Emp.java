package com.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ${user}
 * @create 2019-11-20-10:04
 */
@Entity
public class Emp {
    private int id;
    private String name;
    private int age;
    private String sex;
    private int deptid;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", deptid=" + deptid +
                '}';
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "deptid")
    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}

        Emp emp = (Emp) o;

        if (id != emp.id) return false;
        if (age != emp.age) return false;
        if (deptid != emp.deptid) return false;
        if (name != null ? !name.equals(emp.name) : emp.name != null) {return false;}
        if (sex != null ? !sex.equals(emp.sex) : emp.sex != null) {return false;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + deptid;
        return result;
    }
}
