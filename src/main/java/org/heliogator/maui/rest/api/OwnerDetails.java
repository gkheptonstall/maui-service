package org.heliogator.maui.rest.api;

import org.heliogator.maui.entity.Owner;

import lombok.Data;

@Data
public class OwnerDetails {
    private Owner owner;
    private boolean hasPet;
}
