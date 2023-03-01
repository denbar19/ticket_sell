package com.denysenko.ticketcontrol.mapper.mapstruct;

import com.denysenko.ticketcontrol.controller.dto.RouteDto;
import com.denysenko.ticketcontrol.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RouteMapper {

    RouteDto toRouteDto(Route route);

    Route toRoute(RouteDto routeDto);
}
