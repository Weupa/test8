package pl.wiktorowicz.test8.service.strategy;

import pl.wiktorowicz.test8.model.GeometricFigure;
import pl.wiktorowicz.test8.model.command.CreateFigureCommand;

public interface GeometricFigureCreationStrategy {

    GeometricFigure create(CreateFigureCommand command);
}
