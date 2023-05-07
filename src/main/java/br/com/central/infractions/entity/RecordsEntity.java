package br.com.central.infractions.entity;

import br.com.central.infractions.dto.RecordsDto;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RecordsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Integer speed;

    @Column(nullable = false)
    private String plate;

    @Column(nullable = false)
    private String vehicleClass;

    public void SetEntity(RecordsDto recordsDto){
        this.dateTime = recordsDto.getDateTime();
        this.speed = recordsDto.getSpeed();
        this.plate = recordsDto.getPlate();
        this.vehicleClass = recordsDto.getVehicleClass();
    }
}
