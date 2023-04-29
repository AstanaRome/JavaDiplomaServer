package com.diploma.repository;

import com.diploma.models.Doctor;
import com.diploma.models.Record;
import com.diploma.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends BaseRepository<Record> {
    @Query("SELECT r FROM Record r WHERE r.user.id is null")
    public List<Record> getAllFreeRecords();

}
