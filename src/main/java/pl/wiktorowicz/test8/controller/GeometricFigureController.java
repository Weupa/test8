package pl.wiktorowicz.test8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wiktorowicz.test8.model.command.CreateFigureCommand;
import pl.wiktorowicz.test8.model.dto.GeometricFigureDTO;
import pl.wiktorowicz.test8.service.GeometricFigureService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/figures")
public class GeometricFigureController {

    private final GeometricFigureService geometricFigureService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFigure(@RequestBody CreateFigureCommand command) {
        geometricFigureService.save(command);
    }


    @GetMapping
    public Page<GeometricFigureDTO> findAll(Pageable pageable) {
        return geometricFigureService.findAll(pageable);
    }
}
