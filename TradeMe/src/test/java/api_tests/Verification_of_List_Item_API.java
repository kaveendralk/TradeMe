package api_tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;
import io.restassured.RestAssured;

public class Verification_of_List_Item_API {
	
	@Test
	public void List_Item_POST() throws IOException {
				
	      byte[] b = Files.readAllBytes(Paths.get("payLoad.json"));

	      String bdy = new String(b);

	      RestAssured.baseURI = "https://api.trademe.co.nz/v1";

	      RestAssured.given().header("Content-type", "application/json").body(bdy)
	      .auth().oauth("B055A7020303C38E46939F6EF2962424", "B38B1D5A3F4196B58F787AABB8CFBDEB", "89C467F76CCF7C81D94B1B6A52CF8B1B", "EF2F981229DFADE172F5B86A55BF99AC")

	      .when().post("/Selling.{json}").then().log().all()

	      .assertThat().statusCode(201);

	}

}
