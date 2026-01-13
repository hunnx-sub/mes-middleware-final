package com.kongju.middleware.sensorLog.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {

    @JsonProperty("equipment_id")
    private String equipmentId;

    @JsonProperty("temperature")
    private Double temperature;

    @JsonProperty("pressure")
    private Double pressure;

    @JsonProperty("vibration")
    private Double vibration;

    @JsonProperty("humidity")
    private Double humidity;

    @JsonProperty("speed")
    private Integer speed;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("timestamp_ms")
    private Long timestampMs;
}
