package com.erickalovesadam.wedding.repositories;

import com.erickalovesadam.wedding.entities.Guest;
import com.erickalovesadam.wedding.entities.RSVPStatus;
import com.erickalovesadam.wedding.entities.mealenum.Appetizer;
import com.erickalovesadam.wedding.entities.mealenum.Dessert;
import com.erickalovesadam.wedding.entities.mealenum.Entree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    @Query("SELECT COUNT(g) FROM Guest g WHERE g.rsvpStatus = :rsvpStatus")
    Long countOfRsvp(@Param("rsvpStatus") RSVPStatus rsvpStatus);

    @Query("SELECT COUNT(m) FROM Meal m JOIN Guest g ON m.id = g.meal.id WHERE m.appetizer = :appetizer AND g.rsvpStatus = 'YES'")
    Long countAppetizer(@Param("appetizer") Appetizer appetizer);

    @Query("SELECT COUNT(m) FROM Meal m JOIN Guest g ON m.id = g.meal.id WHERE m.entree = :entree AND g.rsvpStatus = 'YES'")
    Long countEntree(@Param("entree") Entree entree);

    @Query("SELECT COUNT(m) FROM Meal m JOIN Guest g ON m.id = g.meal.id WHERE m.dessert = :dessert AND g.rsvpStatus = 'YES'")
    Long countDessert(@Param("dessert") Dessert dessert);

    @Query(value = "SELECT g FROM Guest g WHERE g.firstName like %:keyword% or g.lastName like %:keyword%")
    List<Guest> findByName(@Param("keyword") String keyword);

}
