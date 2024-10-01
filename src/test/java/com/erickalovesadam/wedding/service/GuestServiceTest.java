package com.erickalovesadam.wedding.service;

import com.erickalovesadam.wedding.entities.Guest;
import com.erickalovesadam.wedding.entities.Meal;
import com.erickalovesadam.wedding.entities.mealenum.Appetizer;
import com.erickalovesadam.wedding.repositories.GuestRepository;
import com.erickalovesadam.wedding.services.GuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GuestServiceTest {

    @MockBean
    private GuestRepository guestRepository;

    @Autowired
    private GuestService guestService;

    @Test
    void testGetUserById() {
        Guest mockGuest = new Guest();
        mockGuest.setGuestId(1L);
        mockGuest.setFirstName("Adam");
        mockGuest.setLastName("Test");

        when(guestRepository.findById(1L)).thenReturn(Optional.of(mockGuest));

        Guest mockResult = guestService.findGuestById(1L);

        System.out.println("User ID: " + mockGuest.getGuestId());
        System.out.println("Mock Guest: " + mockGuest.getFirstName() + " " + mockGuest.getLastName());

        if (mockResult != null) {
            System.out.println("User Found: " + mockResult.getFirstName() + " " + mockResult.getLastName());
        } else {
            System.out.println("User not found.");
        }

        assertNotNull(mockResult);
        assertEquals(mockGuest.getFirstName(), mockResult.getFirstName());
        assertEquals(mockGuest.getLastName(), mockResult.getLastName());
        verify(guestRepository).findById(1L);
    }

    @Test
    void testGetMealsByGuestId() {
        Guest mockGuest = new Guest();
        mockGuest.setGuestId(1L);
        mockGuest.setFirstName("Adam");
        mockGuest.setLastName("Test");

        Meal mockMeal = new Meal();
        mockMeal.setAppetizer(Appetizer.BEET_SALAD);
        mockGuest.setMeal(mockMeal);

        when(guestRepository.findById(1L)).thenReturn(Optional.of(mockGuest));

        Guest mockResult = guestService.findGuestById(1L);

        System.out.println("Mock Meal: " + mockMeal.getAppetizer());

        if (mockResult != null) {
            System.out.println("Meal Found: " + mockMeal.getAppetizer());
        } else {
            System.out.println("Meal not found.");
        }

        assertNotNull(mockResult);
        assertEquals(mockMeal.getAppetizer(), mockResult.getMeal().getAppetizer());
        verify(guestRepository).findById(1L);

    }

}
