package ru.trailblazers.musicappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.trailblazers.musicappbackend.api.TrackApi;
import ru.trailblazers.musicappbackend.dto.request.TrackRequest;
import ru.trailblazers.musicappbackend.dto.response.TrackResponse;
import ru.trailblazers.musicappbackend.service.TrackService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TrackController implements TrackApi {


    private final TrackService service;
    private static final String UPLOAD_DIR = "uploads";

    @GetMapping("/get/{filename}")
    public ResponseEntity<InputStreamResource> getMp3File(@PathVariable String filename) throws IOException {
        Resource resource = new ClassPathResource(String.format("tracks/%s", filename));
        if (resource.exists()) {
            InputStream inputStream = resource.getInputStream();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentLength(resource.contentLength());
            headers.setContentDispositionFormData("attachment", "Depeche Mode - Enjoy The Silence (Mike Shinoda Reinterpretation).mp3");
            return new ResponseEntity<>(new InputStreamResource(inputStream), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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
