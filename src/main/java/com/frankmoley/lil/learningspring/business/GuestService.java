package com.frankmoley.lil.learningspring.business;

import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.data.GuestRepository;
import com.frankmoley.lil.learningspring.data.ReservationRepository;
import com.frankmoley.lil.learningspring.data.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        List<Guest> guests = this.guestRepository.findAll();
        guests.sort(Comparator.comparing(Guest::getFirstName)
                .thenComparing(Guest::getLastName));
        return guests;
    }

    public void addGuest(Guest guest) {
        if(guest == null)
            throw new RuntimeException("Guest cannot be null");
        this.guestRepository.save(guest);
    }
}
