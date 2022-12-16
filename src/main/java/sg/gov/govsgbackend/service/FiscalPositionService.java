package sg.gov.govsgbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import sg.gov.govsgbackend.entity.FiscalPosition;

public interface FiscalPositionService {

    FiscalPosition createFiscalPosition(FiscalPosition fiscalPosition);

    FiscalPosition getFiscalPositionById(Long fiscalPositionId);

    FiscalPosition updateFiscalPosition(Long fiscalPositionId, FiscalPosition fiscalPositionRequest);

    ResponseEntity<?> deleteFiscalPosition(Long fiscalPositionId);

    Page<FiscalPosition> getAllFiscalPositions(Pageable pageable);

}
