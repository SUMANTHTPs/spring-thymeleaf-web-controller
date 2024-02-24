package com.frankmoley.lil.learningspring.webservice;

import com.frankmoley.lil.learningspring.business.GuestService;
import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private  final DateUtils dateUtils;

    private  final ReservationService reservationService;

    private final GuestService guestService;


    public WebServiceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path = "/guest", method = RequestMethod.GET)
    public List<Guest> getGuests() {
        return this.guestService.getAllGuests();
    }

    @PostMapping("/guest")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuests(@RequestBody Guest guest) {
        this.guestService.addGuest(guest);
    }
}
