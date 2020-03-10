package com.akhi.math.mathassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class DataSeries {

    @JsonProperty
    private List<String> series;
}
