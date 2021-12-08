package jpaHello3.jpaHello;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id//pk 맵핑
    private Long id;

    @Column(name = "name")// 변수와 컬럼명이 다른경우
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)//enum타입의경우 어노테이션으로 구분해줌
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)//db는 날짜시간을 구분함으로 따로 지정해줘야함
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob// 컨텐츠의 크기가 매우 클경우
    private String description;
    //Getter, Setter…
}
