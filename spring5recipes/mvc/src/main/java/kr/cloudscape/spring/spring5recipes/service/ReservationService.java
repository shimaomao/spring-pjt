package kr.cloudscape.spring.spring5recipes.service;

import kr.cloudscape.spring.spring5recipes.domain.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> query(String courtName);
}
