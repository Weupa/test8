package pl.wiktorowicz.test8.service.strategy;

import org.springframework.stereotype.Component;
import pl.wiktorowicz.test8.model.Circle;
import pl.wiktorowicz.test8.model.command.CreateFigureCommand;

import java.util.Map;

@Component("CIRCLE")
public class CircleCreationStrategy implements GeometricFigureCreationStrategy {

    @Override
    public Circle create(CreateFigureCommand command) {
        Map<String, String> params = command.getParams();
        return Circle.builder()
                .radius(Integer.parseInt(params.get("radius")))
                .build();
    }
}
