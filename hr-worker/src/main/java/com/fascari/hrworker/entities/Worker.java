package com.fascari.hrworker.entities;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_worker")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;
}