package br.com.central.infractions.simulation;


import br.com.central.infractions.dto.RecordsDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class RadarSimulator implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private final Random random;

    public RadarSimulator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.random = new Random();
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            LocalDateTime dateTime = LocalDateTime.now();
            int speed = random.nextInt(21) + 80;
            String plate = generatePlate();
            String vehicleClass = generateVehicleClass();

            RecordsDto recordsDto = new RecordsDto(dateTime, speed, plate, vehicleClass);
            restTemplate.postForObject("http://localhost:8080/api/records/create", recordsDto, RecordsDto.class);

            Thread.sleep(3000);
        }
    }

    private String generatePlate() {
        StringBuilder plate = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            plate.append((char) (random.nextInt(26) + 'A'));
        }
        plate.append(random.nextInt(10000));
        return plate.toString();
    }

    private String generateVehicleClass() {
        String[] vehicleClasses = { "Carro", "Moto", "Caminhão", "Ônibus", "Van" };
        return vehicleClasses[random.nextInt(vehicleClasses.length)];
    }

}
