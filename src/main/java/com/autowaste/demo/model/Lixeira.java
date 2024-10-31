package com.autowaste.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor  // Necessário para o Spring criar o objeto a partir do JSON
@AllArgsConstructor
@Table(name = "TB_AUTOWASTE_LIXEIRA")
public class Lixeira implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLixeira;

    @Getter
    @Setter
    private String localizacao;

    @Getter
    @Setter
    private Integer capacidadeTotal;

    @Getter
    @Setter
    private Integer capacidadeAtual;

}
