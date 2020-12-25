package ru.specialist.DAO.teacher;

import ru.specialist.DAO.base.BaseEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "teachers")
@SequenceGenerator(name = "generator", sequenceName = "teachers_id_seq", initialValue = 1, allocationSize = 1)
public class Teacher extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "generator")
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "addr")
    private String addr;
    @Column(name = "phone")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
