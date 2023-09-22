package pl.wiktorowicz.test8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wiktorowicz.test8.model.GeometricFigure;
import pl.wiktorowicz.test8.model.command.CreateFigureCommand;
import pl.wiktorowicz.test8.model.dto.GeometricFigureDTO;
import pl.wiktorowicz.test8.repository.GeometricFigureRepository;
import pl.wiktorowicz.test8.service.strategy.GeometricFigureCreationStrategy;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class GeometricFigureService {

    private final GeometricFigureRepository geometricFigureRepository;
    private final Map<String, GeometricFigureCreationStrategy> geometricFigureCreationStrategyMap;


    public GeometricFigureDTO save(CreateFigureCommand command) {
        GeometricFigureCreationStrategy strategy = geometricFigureCreationStrategyMap.get(command.getType());

        if (strategy == null) {
            throw new IllegalArgumentException("Nieznany typ figury: " + command.getType());
        }
        GeometricFigure figure = strategy.create(command);
        geometricFigureRepository.save(figure);

        return GeometricFigureDTO.fromEntity(figure);
    }


    public Page<GeometricFigureDTO> findAll(Pageable pageable) {
        return geometricFigureRepository.findAll(pageable).map(GeometricFigureDTO::fromEntity);
    }
}