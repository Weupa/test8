package pl.wiktorowicz.test8.service.strategy;

import org.springframework.stereotype.Component;
import pl.wiktorowicz.test8.model.Square;
import pl.wiktorowicz.test8.model.command.CreateFigureCommand;

import java.util.Map;

@Component("SQUARE")
public class SquareCreationStrategy implements GeometricFigureCreationStrategy{

    @Override
    public Square create(CreateFigureCommand command) {
        Map<String, String> params = command.getParams();
        return Square.builder()
                .sideLength(Integer.parseInt(params.get("sideLength")))
                .build();
    }
}
