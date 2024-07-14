//import io.qameta.allure.Description;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Story;
//import io.qameta.allure.restassured.AllureRestAssured;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//
//public class SimpleTests {
//    /**
//     * Some J dock
//     */
//    @Description(useJavaDoc = true)

//    public void testCanSignIn() {
//        given()
//                .filter(new AllureRestAssured())
//                .contentType("application/json")
//                .body("{\"email\":\"test@mail.com\"}")
//                .when()
//                .post("http://localhost:8085/auth/reset")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .and()
//                .assertThat().body("code", equalTo("OK"));
//    }
//}





