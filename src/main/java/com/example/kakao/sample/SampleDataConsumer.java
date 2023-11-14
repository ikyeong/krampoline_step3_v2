package com.example.kakao.sample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SampleDataConsumer {
	private final ObjectMapper om;

	@KafkaListener(topics = {"notion"}, groupId = "group-id-linknamu")
	public void notionConsumer(String message) {
		System.out.println("===========Notion============");
		System.out.println(message);
	}

	@KafkaListener(topics = {"google_docs"}, groupId = "group-id-linknamu")
	public void googleDocsConsumer(String message) {
		System.out.println("===========google_docs============");
		System.out.println(message);
	}

	@KafkaListener(topics = {"kakao"}, groupId = "group-id-linknamu")
	public void kakaoConsumer(String message) {
		System.out.println("===========kakao============");
		System.out.println(message);
	}
}
