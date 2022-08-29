package api_tests;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;  

public class Retrieve_Latest_Listings_API {

	@Test
	public void Retrieve_Latest_Listings_GET() {

		Response response =  RestAssured		
				.given().auth().oauth("B055A7020303C38E46939F6EF2962424", "B38B1D5A3F4196B58F787AABB8CFBDEB", "89C467F76CCF7C81D94B1B6A52CF8B1B", "EF2F981229DFADE172F5B86A55BF99AC")
				.get("https://api.trademe.co.nz/v1/Listings/Latest.{file_format}");

		System.out.println(response.getTime());
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getStatusLine());
		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

}



