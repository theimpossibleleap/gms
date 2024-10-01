package com.erickalovesadam.wedding.controllers;

import com.erickalovesadam.wedding.entities.Guest;
import com.erickalovesadam.wedding.entities.Meal;
import com.erickalovesadam.wedding.entities.RSVPStatus;
import com.erickalovesadam.wedding.entities.mealenum.Appetizer;
import com.erickalovesadam.wedding.entities.mealenum.Dessert;
import com.erickalovesadam.wedding.entities.mealenum.Entree;
import com.erickalovesadam.wedding.repositories.GuestRepository;
import com.erickalovesadam.wedding.services.GuestService;
import com.erickalovesadam.wedding.services.MealService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private MealService mealService;

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(path = {"/", "/guests/search"})
    public String searchGuests(Model model, Guest guest, String keyword) {
        if (keyword != null) {
            List<Guest> guests = guestService.findGuestsByName(keyword);
            model.addAttribute("guests", guests);
        } else {
            model.addAttribute("guests", guestService.findAllGuests());
        }
        return "index";
    }

    /* @GetMapping("/")
    public String index(Model model) {
        List<Guest> guests = guestService.findAllGuests();
        model.addAttribute("guests", guests);
        return "index";
    } */

    @GetMapping("/guests/add")
    public String addGuest(Model model) {
        Guest guest = new Guest();
        Meal meal = new Meal();
        model.addAttribute("guest", guest);
        model.addAttribute("meal", meal);
        model.addAttribute("isEdit", false);
        return "guest-edit";
    }

    @GetMapping("/guests/{guestId}")
    public String guestDetail(Model model, @PathVariable Long guestId) {
        Guest currentGuest = guestService.findGuestById(guestId);
        model.addAttribute("meal", currentGuest.getMeal());
        model.addAttribute("guest", currentGuest);
        return "guest-detail";
    }

    @GetMapping("/guests/{guestId}/edit")
    public String editGuest(Model model, @PathVariable Long guestId) {
        Guest currentGuest = guestService.findGuestById(guestId);

        model.addAttribute("guest", currentGuest);
        model.addAttribute("isEdit", true);
        model.addAttribute("rsvpStatus", RSVPStatus.values());
        model.addAttribute("meal", currentGuest.getMeal());

        return "guest-edit";
    }

    @PostMapping("/guests/save")
    public String saveGuest(@ModelAttribute("guest") @Valid Guest guest, BindingResult result, Model model) {

        if (guest.getGuestId() == null) {
            model.addAttribute("isEdit", false);
        } else {
            model.addAttribute("isEdit", true);
        }

        model.addAttribute("guest", guest);
        model.addAttribute("rsvpStatus", RSVPStatus.values());
        model.addAttribute("meal", guest.getMeal());

        if (result.hasErrors()) {
            return "guest-edit";
        }

        guestService.saveGuest(guest);
        return "redirect:/guests/" + guest.getGuestId();
    }

    @PostMapping("/guests/delete/{guestId}")
    public String deleteGuest(@PathVariable Long guestId) {
        guestService.deleteGuest(guestId);
        return "redirect:/";
    }

    @GetMapping("/guests/reports")
    public String getGuestCount(Model model) {

        LocalDate date = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a z")
                .withZone(ZoneId.of("America/Los_Angeles"));
        LocalTime timeNow = LocalTime.now();
        String timeString = timeNow.format(formatter);

        model.addAttribute("date", date);
        model.addAttribute("time", timeString);

        for (RSVPStatus rsvpStatus : RSVPStatus.values()) {
            Long count = guestRepository.countOfRsvp(rsvpStatus);
            model.addAttribute("rsvp" + rsvpStatus.name(), count);
        }

        for (Appetizer appetizer : Appetizer.values()) {
            Long count = guestRepository.countAppetizer(appetizer);
            model.addAttribute(appetizer.name(), count);
        }

        for (Entree entree : Entree.values()) {
            Long count = guestRepository.countEntree(entree);
            model.addAttribute(entree.name(), count);
        }

        for (Dessert dessert : Dessert.values()) {
            Long count = guestRepository.countDessert(dessert);
            model.addAttribute(dessert.name(), count);
        }

        return "guest-reports";
    }
}