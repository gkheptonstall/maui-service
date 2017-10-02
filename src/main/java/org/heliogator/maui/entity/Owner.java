package org.heliogator.maui.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Owner {

    @Id
    @GeneratedValue
    private long id;

    private String name;
}
