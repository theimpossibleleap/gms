package com.erickalovesadam.wedding.entities;

import com.erickalovesadam.wedding.entities.mealenum.Appetizer;
import com.erickalovesadam.wedding.entities.mealenum.Dessert;
import com.erickalovesadam.wedding.entities.mealenum.Entree;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Appetizer appetizer;

    @Enumerated(EnumType.STRING)
    private Entree entree;

    @Enumerated(EnumType.STRING)
    private Dessert dessert;

}
