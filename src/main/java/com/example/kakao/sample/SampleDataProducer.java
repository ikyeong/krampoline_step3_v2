package com.example.kakao.sample;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SampleDataProducer {
	private final ObjectMapper om;
	private final KafkaTemplate<String, String> kafkaTemplate;

	public void kafkaPublish(SampleData sampleData) {
		try {
			String message = om.writeValueAsString(sampleData);
			ListenableFuture<SendResult<String, String>> futureNotion =
				kafkaTemplate.send("notion", message);

			ListenableFuture<SendResult<String, String>> futureGoogle =
				kafkaTemplate.send("google_docs", message);

			ListenableFuture<SendResult<String, String>> futureKakao =
				kafkaTemplate.send("kakao", message);
		} catch (JsonProcessingException ignored){
		}


	}
}
