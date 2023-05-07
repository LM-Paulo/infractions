package br.com.central.infractions.service;

import br.com.central.infractions.dto.RecordsDto;

import br.com.central.infractions.entity.RecordsEntity;
import br.com.central.infractions.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class RecordsService {

    @Autowired
    private RecordsRepository recordsRepository;

    public void createRecord(RecordsDto recordsDto) {
        RecordsEntity recordsEntity = new RecordsEntity();
        recordsEntity.SetEntity(recordsDto);
        recordsRepository.save(recordsEntity);
    }

    public Page<RecordsEntity>listRecords(Sort.Direction direction,
                                          String properties,
                                          Integer page,
                                          Integer size){
        Pageable pageable = PageRequest.of(page,size, Sort.by(direction, properties));
        return recordsRepository.findAll(pageable);

    }

    public RecordsEntity serchRecordsById(Long id) throws NoResultException{
        Optional<RecordsEntity> records = recordsRepository.findById(id);
        if(records.isPresent()){
            return records.get();
        }
        throw new NoResultException();
    }

    @Transactional
    public void updateRecord(Long id, RecordsDto recordsDto){
        Optional<RecordsEntity> findRecord = recordsRepository.findById(id);
        RecordsEntity recordsEntity = findRecord.get();
        recordsEntity.SetEntity(recordsDto);
        recordsRepository.save(recordsEntity);
    }

    public void deleteRecords(Long id){
        recordsRepository.deleteById(id);
    }
}
