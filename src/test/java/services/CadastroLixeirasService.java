package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.LixeiraModel;
import static io.restassured.RestAssured.given;
public class CadastroLixeirasService {

    final LixeiraModel lixeiraModel = new LixeiraModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String baseUrl = "http://localhost:8080/api";

    public void setFieldsTrash(String field, String value){
        switch (field){
            case "localizacao" -> lixeiraModel.setLocalizacao(value);
            case "capacidadeTotal" -> lixeiraModel.setCapacidadeTotal(Integer.parseInt(value));
            case "capacidadeAtual" -> lixeiraModel.setCapacidadeAtual(Integer.parseInt(value));
            default -> throw new IllegalStateException("Campo inesperado: " + field);
        }
    }

    public void createTrash(String endPoint){
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(lixeiraModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    String idTrash;

    public void retrieveIdTrash() {
        idTrash = String.valueOf(gson.fromJson(response.jsonPath().prettify(), LixeiraModel.class).getIdLixeira());
    }

    public void deleteTrash(String endPoint) {
        String url = String.format("%s%s/%s", baseUrl, endPoint, idTrash);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }


}
