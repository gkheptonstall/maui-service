package org.heliogator.maui.rest.api;

import lombok.Data;
import org.heliogator.maui.entity.Owner;

@Data
public class OwnerDetails {
    private Owner owner;
    private boolean hasPet;
}
