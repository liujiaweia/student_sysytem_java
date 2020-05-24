package student_system.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Group {
    private String id;
    private String name;
    private String content;
    private String clazzid;

    private Clazz clazz;//用来保存当前小组班级信息

    private List<String> tags = new ArrayList<>();//用来存储自己组标签
}
