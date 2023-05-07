package br.com.central.infractions.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class RecordsDto {

    private UUID id;

    private LocalDateTime dateTime;

    private Integer speed;

    private String plate;

    private String vehicleClass;


}
