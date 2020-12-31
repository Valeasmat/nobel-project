package com.vale.javarx.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NobelPrize {
    @SerializedName("awardYear")
    @Expose
    private String awardYear;
    @SerializedName("category")
    @Expose
    private Language language;
    @SerializedName("laureates")
    @Expose
    private List<Laureate> laureates = null;
}
