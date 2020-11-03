package project.dto.respons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.model.Enums.Position;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegDto {

    private String name;
    private String password;
    private Position position;
    private String number;
    private String code;

}
