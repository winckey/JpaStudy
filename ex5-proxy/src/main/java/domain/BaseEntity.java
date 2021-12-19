package domain;


import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass//entity로는 관리하지않고 정보만 전달
public abstract class BaseEntity{

   private String createBy;

   private String lastModifyBy;


   private LocalDateTime createDate;

   private LocalDateTime lastModifyDate;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(LocalDateTime lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}
