package com.vale.javarx.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaureateResponse {

    private String category;
    private Integer year;
    private String name;
    private String gender;
    private String countryBirth;
}
