package peaksoft.airbnb_j.apis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import peaksoft.airbnb_j.dto.announcement.AnnouncementRequest;
import peaksoft.airbnb_j.dto.announcement.AnnouncementResponse;
import peaksoft.airbnb_j.services.impl.AnnouncementService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainPage {

    private final AnnouncementService announcementService;

    @PostMapping
    public AnnouncementResponse create(
            @RequestBody AnnouncementRequest request,
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("file3")  MultipartFile file3,
            @RequestParam("file4")  MultipartFile file4
            ) throws IOException {
        return announcementService.create(request, file1, file2, file3, file4);
    }

    @PutMapping("{id}")
    public AnnouncementResponse update(@PathVariable long id, @RequestBody AnnouncementRequest request) {
        return announcementService.update(id, request);
    }

    @GetMapping("{id}")
    public AnnouncementResponse findById(@PathVariable long id) {
        return announcementService.findById(id);
    }

    @DeleteMapping("{id}")
    public AnnouncementResponse delete(@PathVariable long id) {
        return announcementService.deleteById(id);
    }

    @GetMapping
    public List<AnnouncementResponse> getAllAnnouncements() {
        return announcementService.getAllAnn();
    }





















}
