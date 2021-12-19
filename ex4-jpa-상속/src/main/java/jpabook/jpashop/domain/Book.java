package jpabook.jpashop.domain;


import javax.persistence.*;

@Entity
public class Book extends Item{


    private String author;

    private int ISBN;
}
