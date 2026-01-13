package com.kongju.middleware.sensorLog.entity;

import com.kongju.middleware.sensorLog.dto.SensorData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipment_id", nullable = false)
    private String equipmentId;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "pressure")
    private Double pressure;

    @Column(name = "humidity")
    private Double humidity;

    @Column(name = "vibration")
    private Double vibration;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "timestamp_ms", nullable = false)
    private Long timestampMs;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // MQTT → Entity 변환
    public static SensorLogEntity fromMqtt(SensorData dto) {
        return SensorLogEntity.builder()
                .equipmentId(dto.getEquipmentId())
                .temperature(dto.getTemperature())
                .pressure(dto.getPressure())
                .humidity(dto.getHumidity())
                .vibration(dto.getVibration())
                .speed(dto.getSpeed())
                .timestamp(dto.getTimestamp())
                .timestampMs(dto.getTimestampMs())
                .build();
    }
}
