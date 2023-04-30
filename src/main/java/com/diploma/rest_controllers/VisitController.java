package com.diploma.rest_controllers;

import com.diploma.models.Record;
import com.diploma.models.Visit;
import com.diploma.services.RecordService;
import com.diploma.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class VisitController extends BaseControllerImpl<Visit, VisitService> {

    @Autowired
    private VisitService visitService;

    protected VisitController(VisitService visitService) {
        super(visitService);
    }




}
