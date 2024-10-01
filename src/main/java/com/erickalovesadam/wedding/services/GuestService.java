package com.erickalovesadam.wedding.services;

import com.erickalovesadam.wedding.entities.Guest;
import com.erickalovesadam.wedding.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> findAllGuests() {
        return guestRepository.findAll();
    }

    public List<Guest> findGuestsByName(String keyword) {
        return guestRepository.findByName(keyword);
    }

    public Guest findGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public void saveGuest(Guest guest) {
        guestRepository.save(guest);
    }

    public void deleteGuest(Long guestId) {
        guestRepository.deleteById(guestId);
    }


}