package ru.trailblazers.musicappbackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.trailblazers.musicappbackend.api.TrackApi;
import ru.trailblazers.musicappbackend.dto.request.TrackRequest;
import ru.trailblazers.musicappbackend.dto.response.TrackResponse;
import ru.trailblazers.musicappbackend.service.TrackService;
import ru.trailblazers.musicappbackend.util.sound.MultipartFileSender;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.*;

@RestController
@RequiredArgsConstructor
public class TrackController implements TrackApi {


    private final TrackService service;
    private static final String UPLOAD_DIR = "uploads";

    @GetMapping(value = "/audio", produces = "audio/mp3")
    public ResponseEntity<byte[]> getAudioFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // загрузка аудиофайла из директории resources
        InputStream in = getClass().getResourceAsStream("/tracks/EnjoyTheSilence.mp3");
        byte[] audioBytes = IOUtils.toByteArray(in);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("audio/mp3"));


        MultipartFileSender.fromPath(new ClassPathResource("/tracks/EnjoyTheSilence.mp3").getFile().toPath())
                .with(request)
                .with(response)
                .serveResource();
        return new ResponseEntity<>(audioBytes, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/test", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamAudioBytes(HttpServletResponse response) throws IOException {
        try {
            var out = response.getOutputStream();
            ClassPathResource resource = new ClassPathResource("/tracks/EnjoyTheSilence.mp3");
            InputStream fileIn = resource.getInputStream();
            byte[] bytes = fileIn.readAllBytes();
            return Flux.create(fluxSink -> {
                try {
                    out.write(bytes);
                    out.flush();
                    out.close();
                    fluxSink.complete();
                } catch (IOException exception) {
                    fluxSink.error(exception);
                }
            });
        } catch (IOException e) {
            return Flux.error(e);
        }
    }

//    @GetMapping(value = "/tracks/audio", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<InputStreamResource> getAudioFile() throws IOException {
//        // получение файла из вашего backend-сервера
//        File file = new File("D:\\ITIS\\3course\\Hakaton\\musicapp-backend\\musicapp-backend\\src\\main\\resources\\tracks\\EnjoyTheSilence.mp3");
//        InputStream inputStream = new FileInputStream(file);
//
//        // создание объекта InputStreamResource для передачи потока данных клиенту
//        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
//
//        // создание объекта ResponseEntity с заголовками и статусом ответа
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=audio.mp3");
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
//        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(inputStreamResource);
//    }

    @Override
    public TrackResponse createTrack(TrackRequest request) {
        return null;
    }

    @Override
    public TrackResponse getTrackById(UUID trackId) {
        return null;
    }

    @Override
    public List<TrackResponse> getTracks() {
        return null;
    }

    @Override
    public TrackResponse updateTrack(UUID trackId, TrackRequest request) {
        return null;
    }

    @Override
    public void deleteTrackById(UUID trackId) {

    }
}
