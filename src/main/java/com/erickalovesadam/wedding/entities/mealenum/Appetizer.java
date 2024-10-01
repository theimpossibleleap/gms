package com.erickalovesadam.wedding.entities.mealenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Appetizer {
    BEET_SALAD("Beet Salad"),
    CRAB_CAKE("Crab Cake"),
    HEN_EGG("The Hen Egg");

    private String displayName;
}
