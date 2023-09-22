package pl.wiktorowicz.test8.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public abstract class GeometricFigure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
