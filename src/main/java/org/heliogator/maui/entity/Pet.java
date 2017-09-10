package org.heliogator.maui.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
