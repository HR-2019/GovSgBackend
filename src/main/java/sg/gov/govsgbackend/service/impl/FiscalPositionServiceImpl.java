package sg.gov.govsgbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sg.gov.govsgbackend.entity.FiscalPosition;
import sg.gov.govsgbackend.exception.ResourceNotFoundException;
import sg.gov.govsgbackend.repository.FiscalPositionRepository;
import sg.gov.govsgbackend.service.FiscalPositionService;

@Service
public class FiscalPositionServiceImpl implements FiscalPositionService {

    @Autowired
    private FiscalPositionRepository fiscalPositionRepository;

    @Override
    public FiscalPosition createFiscalPosition(FiscalPosition fiscalPosition) {
        return fiscalPositionRepository.save(fiscalPosition);
    }

    @Override
    public FiscalPosition getFiscalPositionById(Long fiscalPositionId) {
        return fiscalPositionRepository.findById(fiscalPositionId).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public FiscalPosition updateFiscalPosition(Long fiscalPositionId, FiscalPosition fiscalPositionRequest) {
        FiscalPosition fiscalPosition = fiscalPositionRepository.findById(fiscalPositionId).orElseThrow(() -> new ResourceNotFoundException());
        fiscalPosition.setYearOfBalance(fiscalPositionRequest.getYearOfBalance());
        fiscalPosition.setActualRevisedEstimated(fiscalPositionRequest.getActualRevisedEstimated());
        fiscalPosition.setCategory(fiscalPositionRequest.getCategory());
        fiscalPosition.setItem(fiscalPositionRequest.getItem());
        fiscalPosition.setAmount(fiscalPositionRequest.getAmount());
        fiscalPosition.setPercentOfGdp(fiscalPositionRequest.getPercentOfGdp());
        return fiscalPositionRepository.save(fiscalPosition);
    }

    @Override
    public ResponseEntity<?> deleteFiscalPosition(Long fiscalPositionId) {
        FiscalPosition fiscalPosition = fiscalPositionRepository.findById(fiscalPositionId).orElseThrow(() -> new ResourceNotFoundException());
        fiscalPositionRepository.delete(fiscalPosition);
        return ResponseEntity.noContent().build();
    }

    @Override
    public Page<FiscalPosition> getAllFiscalPositions(Pageable pageable) {
        return fiscalPositionRepository.findAll(pageable);
    }
}
