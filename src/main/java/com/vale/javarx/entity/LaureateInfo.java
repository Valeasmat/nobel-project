package com.vale.javarx.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaureateInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fullName")
    @Expose
    private Language fullName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("birth")
    @Expose
    private Fact birth;
    @SerializedName("death")
    @Expose
    private Fact death;

}
