package com.autowaste.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor  // Necessário para o Spring criar o objeto a partir do JSON
@AllArgsConstructor
@Table(name = "TB_AUTOWASTE_COLETA")
public class Coleta  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColeta;

    @Getter
    @Setter
    private Long idLixeira;

    @Getter
    @Setter
    private LocalDate dataAgendada;

    @Getter
    @Setter
    private LocalTime horaAgendada;

    @Getter
    @Setter
    private String status;
}
