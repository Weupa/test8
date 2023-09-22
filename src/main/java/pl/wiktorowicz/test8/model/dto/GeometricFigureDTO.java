package pl.wiktorowicz.test8.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wiktorowicz.test8.model.GeometricFigure;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@NoArgsConstructor
public class GeometricFigureDTO {

    private int id;
    private String type;
    private Map<String, Object> params = new HashMap<>();

    public static GeometricFigureDTO fromEntity(GeometricFigure entity) {
        GeometricFigureDTO dto = new GeometricFigureDTO();
        dto.setId(entity.getId());
        dto.setType(entity.toString());

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(entity);
                dto.getParams().put(field.getName(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }
}
