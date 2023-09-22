package pl.wiktorowicz.test8.model.command;

import lombok.Data;

import java.util.Map;

@Data
public class CreateFigureCommand {

    private String type;
    private Map<String, String> params;
}
