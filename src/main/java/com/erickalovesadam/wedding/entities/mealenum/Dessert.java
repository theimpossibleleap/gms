package com.erickalovesadam.wedding.entities.mealenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Dessert {
    OPERA_CAKE("Opera Cake"),
    MANGO_CHEESECAKE("Mango-Passionfruit Cheesecake"),
    APPLE_ENTREMET("Apple Entremet");

    private final String displayName;
}
