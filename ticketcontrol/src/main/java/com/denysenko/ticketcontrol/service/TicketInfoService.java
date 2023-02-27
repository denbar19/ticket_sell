package com.denysenko.ticketcontrol.service;

import com.denysenko.ticketcontrol.entity.Route;
import com.denysenko.ticketcontrol.entity.Ticket;
import com.denysenko.ticketcontrol.entity.TicketInfo;
import com.denysenko.ticketcontrol.resource.PaymentResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TicketInfoService {

    private final TicketControlService ticketControlService;
    private final RouteService routeService;
    private final PaymentResource paymentResource;

    // Билеты по маршрутам
    public Map<Route, Ticket> getNewTicketsInfo() {
        /*List<String> paymentIds = paymentResource.getNewPayments();
        List<String> ticketIds = ticketBuyService.getTicketsByPaymentIds(paymentIds);
        routeService.getRoutesByTickets().collectList().block()
         null;*/
        return null;
    }

    public List<Route> getFailedTicketsInfo() {
        List<String> paymentIds = paymentResource.getFailedPaymentsIds();
        List<String> routeIds = ticketControlService.getTicketsByPaymentIds(paymentIds)
                                                    .collectList()
                                                    .block()
                                                    .stream()
                                                    .map(Ticket::getRouteId)
                                                    .map(String::valueOf)
                                                    .collect(Collectors.toList());
        return routeService.getRoutesById(routeIds).collectList().block();
    }

    public TicketInfo getTicketInfo(String ticketId) {
        return TicketInfo.builder()
                         .route(routeService.getRouteByTicketId(ticketId).block())
                         .paymentStatus(paymentResource.getPaymentStatus(ticketId))
                         .build();
    }

}
