package com.erickalovesadam.wedding.entities.mealenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum Entree {
    CHICKEN("Fogline Farms Chicken"),
    BEEF("Beef Tenderloin"),
    BUCATINI("Bucatini Cacio E Pepe"),
    RIGATONI("Rigatoni All'Amatriciana"),
    GNOCCHI("Potato Gnocchi");

    private final String displayName;
}
