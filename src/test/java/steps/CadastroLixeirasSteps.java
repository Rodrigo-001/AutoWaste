package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroLixeirasService;

import java.util.List;
import java.util.Map;

public class CadastroLixeirasSteps {
    CadastroLixeirasService cadastroLixeirasService = new CadastroLixeirasService();
    @Dado("que eu tenha os seguintes dados da lixeira:")
    public void queEuTenhaOsSeguintesDadosDaLixeira(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroLixeirasService.setFieldsTrash(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de lixeiras")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeLixeiras(String endPoint) {
        cadastroLixeirasService.createTrash(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroLixeirasService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        String responseBody = cadastroLixeirasService.response.asString(); // Obtém a resposta como String
        Assert.assertEquals(message, responseBody); // Verifica a string diretamente
    }

    @Dado("que eu recupere o ID da lixeira criada no contexto")
    public void queEuRecupereOIDDaLixeiraCriadaNoContexto() {
        cadastroLixeirasService.retrieveIdTrash();
    }
    @Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de lixeira")
    public void euEnviarARequisiçãoComOIDParaOEndpointDeDeleçãoDeLixeira(String endPoint) {
        cadastroLixeirasService.deleteTrash(endPoint);
    }

}
