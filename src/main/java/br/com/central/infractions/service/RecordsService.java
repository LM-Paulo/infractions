package br.com.central.infractions.service;

import br.com.central.infractions.dto.RecordsDto;
import br.com.central.infractions.entity.RecordsEntity;
import br.com.central.infractions.exceptions.BusinessException;
import br.com.central.infractions.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Optional;

@Service
public class RecordsService {

    private final static Logger logger = Logger.getLogger(RecordsService.class.getName());

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

    public RecordsEntity serchRecordsById(Long id)throws BusinessException{
        Optional<RecordsEntity> records = recordsRepository.findById(id);
        if(records.isPresent()){
            return records.get();
        }
        logger.log(Level.SEVERE,"register not found",BusinessException.class);
        throw new BusinessException("register not found");
    }

    @Transactional
    public void updateRecord(Long id, RecordsDto recordsDto)throws BusinessException {
        Optional<RecordsEntity> findRecord = recordsRepository.findById(id);
        if (findRecord.isPresent()){
            RecordsEntity recordsEntity = findRecord.get();
            recordsEntity.SetEntity(recordsDto);
            recordsRepository.save(recordsEntity);
        }else {
            logger.log(Level.SEVERE,"Unable to perform update",BusinessException.class);
            throw new BusinessException("Unable to perform update");
        }

    }

    public void deleteRecords(Long id)throws BusinessException{
        Optional<RecordsEntity> findRecord = recordsRepository.findById(id);
        if (findRecord.isPresent()){
            recordsRepository.deleteById(id);
        }else {
            logger.log(Level.SEVERE,"Unable to delete record",BusinessException.class);
            throw new BusinessException("Unable to delete record");
        }

    }
}
