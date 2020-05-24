package student_system.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import student_system.entity.Tag;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Student<List> {
    private String  id;
    private String  name;
    private Integer age;
    private Date bir;
    private String phone;
    private String qq;
    private String attr;//生肖
    private String starts;//星座
    private String mark;//备注

    private String cityid;//城市id
    private String clazzid;//班级id
    private String groupid;//小组id

    private City city;//定义一个城市对象用来保存当前学生的就业城市信息

    private Clazz clazz;//定义一个班级对象用来保存当前学生所在班级信息

    private Group group;//定义一个小组对象用来保存当前学生所在的小组信息
    //private List<Tag> tags;

    private java.util.List<Tag> tags;//定义一个标签的集合用来保存当前学生的标签信息

}
