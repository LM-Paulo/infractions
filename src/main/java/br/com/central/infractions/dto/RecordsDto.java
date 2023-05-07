package br.com.central.infractions.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class RecordsDto {

    private Long id;

    private LocalDateTime dateTime;

    private Integer speed;

    private String plate;

    private String vehicleClass;

}
