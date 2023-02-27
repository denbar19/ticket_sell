package com.denysenko.ticketcontrol;

import com.denysenko.ticketcontrol.entity.Route;
import com.denysenko.ticketcontrol.service.TicketInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TicketStateCheckScheduler {

    private final TicketInfoService ticketInfoService;

    @Scheduled(fixedRate = 1500)
    public void checkTickets() {
        log.info("scheduled check");
        log.info("Tickets with NEW payment status by route: {}", ticketInfoService.getNewTicketsInfo());
        log.info("Available seats by route: {}", ticketInfoService.getFailedTicketsInfo()
                                                                  .stream()
                                                                  .collect(Collectors.toMap(Route::getIdentity,
                                                                                            Route::getAvailableSeats)));
    }
}
