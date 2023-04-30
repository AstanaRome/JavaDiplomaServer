package com.diploma.repository;

import com.diploma.models.Record;
import com.diploma.models.Visit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends BaseRepository<Visit> {


}
