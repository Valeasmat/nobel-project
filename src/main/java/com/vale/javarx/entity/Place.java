package com.vale.javarx.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Place {

    @SerializedName("country")
    @Expose
    private Language country;
    @SerializedName("continent")
    @Expose
    private Language continent;
}
