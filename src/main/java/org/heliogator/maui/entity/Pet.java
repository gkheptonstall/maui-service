package org.heliogator.maui.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

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
