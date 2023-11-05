package com.airconmoa.airconmoa.estimate.controller;

import com.airconmoa.airconmoa.estimate.dto.*;
import com.airconmoa.airconmoa.estimate.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/estimate")
public class EstimateController {
    private final EstimateService estimateService;
    @PostMapping
    public ResponseEntity<PostEstimateRes> createEstimate(@RequestBody PostEstimateReq postEstimateReq) {
        return ResponseEntity.ok(estimateService.createEstimate(postEstimateReq));
    }

    @GetMapping("/{estimateId}")
    public ResponseEntity<GetEstimateRes> getEstimate(@PathVariable("estimateId") Long estimateId) {
        return ResponseEntity.ok(estimateService.getEstimate(estimateId));
    }
}
