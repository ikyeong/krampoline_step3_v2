package com.example.kakao.sample;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api") 
public class SampleRestController {

    private final SampleDataRepository sampleDataRepository;
    private final SampleDataProducer sampleDataProducer;

    @GetMapping("/test")
    public ResponseEntity<?> pingTest() {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/db")
    public ResponseEntity<?> dbTest() {
        List<SampleData> sampleDataList = sampleDataRepository.findAll();
        return ResponseEntity.ok(sampleDataList);
    }

    @GetMapping("/kafka")
    public ResponseEntity<?> toKafkaTest() {
        SampleData sampleData = new SampleData(1, "테스트테스트");
        sampleDataProducer.kafkaPublish(sampleData);
        return ResponseEntity.ok("ok");
    }
}
