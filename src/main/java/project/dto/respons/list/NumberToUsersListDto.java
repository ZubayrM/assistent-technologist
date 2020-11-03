package project.dto.respons.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumberToUsersListDto {
    private String shop;

    private List<UserDto> list = new ArrayList<>();

}
