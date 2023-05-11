package com.secui.healthone.domain.healthStat.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "health_stat_no")
    private Integer no;
    @Column(name = "user_no")
    private Integer userNo;
    @Column(name = "health_stat_createtime")
    private LocalDateTime createtime;
    @Column(name = "health_stat_height")
    private Float height;
    @Column(name = "health_stat_weight")
    private Float weight;
    @Column(name = "health_stat_bmi")
    private Float bmi;
    @Column(name = "health_stat_body_fat_percentage")
    private Float bodyFatPercentage;
    @Column(name = "health_stat_skeletal_muscle_mass")
    private Float skeletalMuscleMass;
    @Column(name = "health_stat_waist_measurement")
    private Float waistMeasurement;
    @Column(name = "health_stat_blood_pressure")
    private Float bloodPressure;
    @Column(name = "health_stat_fbg")
    private Float fbg;
    @Column(name = "health_stat_hdl_cholesterol")
    private Float hdlCholesterol;
    @Column(name = "health_stat_tg")
    private Float tg;
}
