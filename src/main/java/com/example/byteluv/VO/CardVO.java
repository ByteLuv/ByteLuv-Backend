package com.example.byteluv.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class CardVO {
    private String cardTitle;
    private String cardBody;
}
