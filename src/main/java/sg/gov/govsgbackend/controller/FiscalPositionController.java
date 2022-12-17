package sg.gov.govsgbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sg.gov.govsgbackend.entity.FiscalPosition;
import sg.gov.govsgbackend.service.FiscalPositionService;
import sg.gov.govsgbackend.util.Message;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fiscal-positions")
public class FiscalPositionController {

    @Autowired
    private FiscalPositionService fiscalPositionService;

    @PostMapping("/")
    public ResponseEntity<FiscalPosition> createFiscalPosition(@Valid @RequestBody FiscalPosition fiscalPosition){
        FiscalPosition fiscalPositionNew = fiscalPositionService.createFiscalPosition(fiscalPosition);
        return ResponseEntity.status(HttpStatus.CREATED).body(fiscalPositionNew);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiscalPosition> getFiscalPositionById(@PathVariable(name = "id") Long fiscalPositionId){

        FiscalPosition fiscalPosition = fiscalPositionService.getFiscalPositionById(fiscalPositionId);
        return ResponseEntity.ok(fiscalPosition);

    }

    @GetMapping("/")
    public Page<FiscalPosition> getAllFiscalPositions(Pageable pageable){
        Page<FiscalPosition> fiscalPositionPage = fiscalPositionService.getAllFiscalPositions(pageable);
        List<FiscalPosition> fiscalPositions = fiscalPositionPage.getContent();
        return new PageImpl<>(fiscalPositions, pageable, fiscalPositions.size());
    }

    @PutMapping("/{id}")
    public FiscalPosition updateFiscalPosition(@PathVariable(name = "id") Long fiscalPositionId, @Valid @RequestBody FiscalPosition fiscalPosition){

        return fiscalPositionService.updateFiscalPosition(fiscalPositionId, fiscalPosition);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFiscalPosition(@PathVariable(name = "id") Long fiscalPositionId){

        return fiscalPositionService.deleteFiscalPosition(fiscalPositionId);

    }

}
