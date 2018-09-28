package pojo;

public class City {
    private Integer id;
    private String cname;
    private Integer pId;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", pId=" + pId +
                '}';
    }
}
