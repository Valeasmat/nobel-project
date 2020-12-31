package com.vale.javarx.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fact {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("place")
    @Expose
    private Place place;

}
