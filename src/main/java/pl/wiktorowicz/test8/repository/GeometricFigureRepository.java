package pl.wiktorowicz.test8.repository;

import pl.wiktorowicz.test8.model.GeometricFigure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeometricFigureRepository extends JpaRepository<GeometricFigure, Integer> {
}
