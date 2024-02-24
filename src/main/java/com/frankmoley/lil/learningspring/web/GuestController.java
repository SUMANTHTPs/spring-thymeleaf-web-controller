package com.frankmoley.lil.learningspring.web;

import com.frankmoley.lil.learningspring.business.GuestService;
import com.frankmoley.lil.learningspring.data.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model) {
        List<Guest> guestsList = guestService.getAllGuests();
        model.addAttribute("guestsList", guestsList);
        return "guestsres";
    }
}
