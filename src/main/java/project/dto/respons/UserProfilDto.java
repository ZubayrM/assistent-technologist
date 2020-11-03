package project.dto.respons;

import lombok.Builder;
import lombok.Data;
import project.model.Enums.Position;

@Data
@Builder
public class UserProfilDto {
    private String name;
    private String shop;
    private String number;
    private Position position;
}
