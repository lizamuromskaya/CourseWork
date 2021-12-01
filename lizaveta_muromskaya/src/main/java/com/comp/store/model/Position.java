package com.comp.store.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="position")
public class Position {

    @Id
    @Column(name="position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="position_name")
    private String name;

    @Column(name="position_salary")
    private Long salary;

    @OneToMany(mappedBy = "position")
    Set<Seller> sellerSet = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Set<Seller> getSellerSet() {
        return sellerSet;
    }

    public void setSellerSet(Set<Seller> sellerSet) {
        this.sellerSet = sellerSet;
    }

//    public Set<Seller> getSellerSet() {
//        return sellerSet;
//    }
//
//    public void setSellerSet(Set<Seller> sellerSet) {
//        this.sellerSet = sellerSet;
//    }
}
