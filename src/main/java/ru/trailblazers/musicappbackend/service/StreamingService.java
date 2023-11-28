package ru.trailblazers.musicappbackend.service;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

public interface StreamingService {

    Mono<Resource> getAudio(String title);
}
