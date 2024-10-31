package model;

import com.google.gson.annotations.Expose;
import lombok.Data;
@Data
public class LixeiraModel {
    @Expose(serialize = false)
    private Long idLixeira;
    @Expose
    private String localizacao;
    @Expose
    private Integer capacidadeTotal;
    @Expose
    private Integer capacidadeAtual;
}
