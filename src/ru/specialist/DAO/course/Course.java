package ru.specialist.DAO.course;

import ru.specialist.DAO.base.BaseEntity;

import java.io.Serializable;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "select с from Course с")
})

@Entity
@Table(name = "courses")
@SequenceGenerator(name = "seq_generator", sequenceName = "courses_id_seq", initialValue = 1, allocationSize = 1)
public class Course extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_generator")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private String title;
    private int length;
    private String description;

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-50s %4d",
                getId(), getTitle(), getLength());
    }


}
