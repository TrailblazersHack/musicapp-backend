package ru.trailblazers.musicappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.trailblazers.musicappbackend.service.StreamingService;

@RestController
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService service;

    @GetMapping(value = "/audio/{title}", produces = "audio/mp3")
    public Mono<Resource> getAudios(@PathVariable String title) {
        return service.getAudio(title);
    }
}
