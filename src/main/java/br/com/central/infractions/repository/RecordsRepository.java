package br.com.central.infractions.repository;

import br.com.central.infractions.entity.RecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordsRepository extends JpaRepository<RecordsEntity, Long> {

}
