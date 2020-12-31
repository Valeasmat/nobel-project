package com.vale.javarx.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Laureate {

    @SerializedName("id")
    @Expose
    private Integer id;
}
