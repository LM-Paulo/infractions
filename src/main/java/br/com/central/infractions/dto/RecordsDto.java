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

    public RecordsDto(LocalDateTime dateTime, Integer speed, String plate, String vehicleClass) {
        this.dateTime = dateTime;
        this.speed = speed;
        this.plate = plate;
        this.vehicleClass = vehicleClass;
    }
}
