package com.diploma.services;

import com.diploma.models.Record;
import com.diploma.repository.RecordRepository;
import com.diploma.services.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RecordService extends BaseServiceImpl<Record, RecordRepository> {
    public RecordService(RecordRepository repository) {
        super(repository);
    }
}
