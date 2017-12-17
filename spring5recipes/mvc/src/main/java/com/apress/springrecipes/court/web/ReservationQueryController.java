// FINAL
package com.apress.springrecipes.court.web;

import com.apress.springrecipes.court.domain.Reservation;
import com.apress.springrecipes.court.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
// Bind controller to URL /reservationQuery 
// initial view will be resolved to the name returned in the default GET method
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

    private final ReservationService reservationService;

    // Wire service in constructor, available in application context 
    public ReservationQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Controller will always look for a default GET method to call first, irrespective of name
    // In this case, named setupForm to ease identification
    @GetMapping
    public void setupForm() {
        // This method has no input parameters, has no logic, and has a void return value. This means two things.
        // By having no input parameters and no logic, a view only displays data hard-coded
        // in the implementation template (e.g., JSP) since no data is being added by the controller.
        // By having a void return value, a default view name based on the request URL is used -
        // therefore, since the requesting URL is /reservationQuery, a return view named reservationQuery is assumed.
        // (i.e.@RequestMapping(/reservationQuery))

        // Based on resolver configuration the reservationQuery view
        // will be mapped to a JSP in /WEB-INF/jsp/reservationQuery.jsp
    }

    // Controller will always look for a default POST method irrespective of name
    // when a submission ocurrs on the URL (i.e.@RequestMapping(/reservationQuery)) 
    // In this case, named submitForm to ease identification
    @PostMapping
    // Submission will come with courtName field, also add Model to return results 
    public String sumbitForm(@RequestParam("courtName") String courtName, Model model) {

        List<Reservation> reservations = java.util.Collections.emptyList();
        // Make a query if parameter is not null
        if (courtName != null) {
            reservations = reservationService.query(courtName);
        }
        // Update model to include reservations
        model.addAttribute("reservations", reservations);
        // Return view as a string
        // Based on resolver configuration the reservationQuery view
        // will be mapped to a JSP in /WEB-INF/jsp/reservationQuery.jsp
        return "reservationQuery";
    }
}