package utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {
    private String postTagName;

    public static PostDto postDto = new PostDto();
}
