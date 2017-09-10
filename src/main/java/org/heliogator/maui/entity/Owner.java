package org.heliogator.maui.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Owner {

    @Id
    @GeneratedValue
    private long id;

    private String name;
}
