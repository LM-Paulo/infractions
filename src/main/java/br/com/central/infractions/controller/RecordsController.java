package br.com.central.infractions.controller;

import br.com.central.infractions.dto.RecordsDto;

import br.com.central.infractions.exceptions.BusinessException;
import br.com.central.infractions.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.jboss.logging.Logger;

@RestController
@RequestMapping("api/records")
public class RecordsController {

    static Logger logger = Logger.getLogger(RecordsController.class.getName());

    @Autowired
    private RecordsService recordsService;

    @PostMapping("/create")
    public ResponseEntity<?> createRecord(@RequestBody RecordsDto records){
        recordsService.createRecord(records);
        return ResponseEntity.ok("Record created successfully");
    }

    @PostMapping("/update-records/{id}")
    public ResponseEntity<?> updateRecord(@PathVariable("id") Long id,@RequestBody RecordsDto records)throws BusinessException{
        recordsService.updateRecord(id,records);
        return ResponseEntity.ok("Records updated successfully");
    }

    @GetMapping("/list-records")
    public ResponseEntity<?>listRecords(@RequestParam("properties") String properties,
                                      @RequestParam("direction")  Sort.Direction direction,
                                      @RequestParam("page") Integer page,
                                      @RequestParam("size") Integer size){
        return ResponseEntity.ok(recordsService.listRecords(direction,properties,page, size));
    }

    @GetMapping("/search-record-by-id/{id}")
    public ResponseEntity<?> serchRecordsById(@PathVariable("id") Long id)throws BusinessException{
        return ResponseEntity.ok(recordsService.serchRecordsById(id));
    }
    @DeleteMapping("/delete-record/{id}")
    public ResponseEntity<?>deleteRecords(@PathVariable("id") Long id)throws BusinessException{
        recordsService.deleteRecords(id);
        return ResponseEntity.ok("Successfully deleted records");
    }

}
