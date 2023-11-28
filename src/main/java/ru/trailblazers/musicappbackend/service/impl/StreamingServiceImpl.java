package ru.trailblazers.musicappbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.trailblazers.musicappbackend.service.StreamingService;

@Service
@RequiredArgsConstructor
public class StreamingServiceImpl implements StreamingService {

    private static final String FORMAT = "classpath:tracks/%s.mp3";

    private final ResourceLoader resourceLoader;

    @Override
    public Mono<Resource> getAudio(String title) {
        return Mono.fromSupplier(() -> resourceLoader
                .getResource(String.format(FORMAT, title)));
    }
}
