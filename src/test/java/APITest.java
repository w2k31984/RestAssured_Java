import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
         /*Creando el metodo para primer test.*/
    void testCase1(){
        Response response= get( "https://reqres.in/api/users?page=2");


        System.out.println("Response:"+response.asString());
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Body:"+response.getBody().asString());
        System.out.println("Time taken:"+response.getTime());
        System.out.println("Header:"+response.getHeader("content-type"));


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

    @Test
         /*Creando el metodo para el segundo test*/
    void testCase2(){
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                assertThat().
                statusCode(200);

    }

    @Test

       /*Creando el metodo para el tercer test*/
    void testCase3(){
        given().
                when().
                get("https://reqres.in/api/users/23").
                then().
                assertThat().
                statusCode(404);
    }

    @Test
      /*Creando el metodo para el tercer test basado en metodo de llamada POST*/
    void testCase4(){
        given().
                when().
                get( "https://reqres.in/api/users?delay=3").
                then().
                assertThat().
                statusCode(200);


    }
}
