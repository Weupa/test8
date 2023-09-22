package pl.wiktorowicz.test8.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Square extends GeometricFigure {

    private int sideLength;

    @Override
    public String toString() {
        return "Square";
    }
}
