package TaskAnno;

@stuTable("student")
public class Student {
    @stuField(columnName = "id",type = "int",length = 10)
    private int id;
    @stuField(columnName = "sname",type = "varchar",length = 10)
    private String name;
    @stuField(columnName = "sage",type = "int",length = 3)
    private int age;
}
