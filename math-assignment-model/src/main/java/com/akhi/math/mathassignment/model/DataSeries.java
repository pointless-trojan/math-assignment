package com.akhi.math.mathassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class DataSeries {

    @JsonProperty
    private List<String> series;
}
