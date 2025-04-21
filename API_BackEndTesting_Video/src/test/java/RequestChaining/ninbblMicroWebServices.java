package RequestChaining;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.Random;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ninbblMicroWebServices {

	public static void main(String[] args) {
		//https://nimbbl.biz/docs/api-reference/introduction/
		
		//To get Bearer Token
		//set base uri
		baseURI = "https://api.nimbbl.tech/";
		
		//Authorization POST request to generate token
		
		String authorizationRequestBody = "{\r\n"
				+ "  \"access_key\": \"access_key_pKx7rWVgVpbXQvq2\",\r\n"
				+ "  \"access_secret\": \"access_secret_DX3w55VKAkXbx7aB\"\r\n"
				+ "}";
		
		Response authResp = given().contentType(ContentType.JSON).body(authorizationRequestBody)
				       .post("api/v3/generate-token");
		authResp.then().log().all();
		String bearerToken = authResp.jsonPath().get("token");
		
		//Create an Order
		String invoiceId = "Inv"+new Random().nextInt();
		String createOrderRequestBody = "{\"amount_before_tax\": 2100,\"tax\": 105,\"total_amount\": 2205,\"user\": {\r\n"
				+ "    \"email\": \"wonderwoman@themyscira.gov\",\r\n"
				+ "    \"first_name\": \"Diana\",\r\n"
				+ "    \"last_name\": \"Prince\",\r\n"
				+ "    \"country_code\": \"+91\",\r\n"
				+ "    \"mobile_number\": \"9876543210\"\r\n"
				+ "  },\r\n"
				+ "  \"shipping_address\": {\r\n"
				+ "    \"address_1\": \"1080 Beach Mansion\",\r\n"
				+ "    \"street\": \"Magic Beach Drive\",\r\n"
				+ "    \"landmark\": \"Opposite Magic Mountain\",\r\n"
				+ "    \"area\": \"Elyria\",\r\n"
				+ "    \"city\": \"Atlantis\",\r\n"
				+ "    \"state\": \"Castalia\",\r\n"
				+ "    \"pincode\": \"100389\",\r\n"
				+ "    \"address_type\": \"Beach House\"\r\n"
				+ "  },\r\n"
				+ "  \"currency\": \"INR\",\r\n"
				+ "  \"invoice_id\": \""+invoiceId+"\",\r\n"
				+ "  \"referrer_platform\": \"string\",\r\n"
				+ "  \"referrer_platform_version\": \"string\",\r\n"
				+ "  \"ip_address\": \"106.201.232.161\",\r\n"
				+ "  \"merchant_shopfront_domain\": \"https://merchant-shopfront.example.com\",\r\n"
				+ "  \"offer_enabled\": false,\r\n"
				+ "  \"validate_order_line_item\": false,\r\n"
				+ "  \"order_line_items\": [\r\n"
				+ "    {\r\n"
				+ "      \"sku_id\": \"item_2783027490\",\r\n"
				+ "      \"title\": \"Best Sliced Alphonso Mango\",\r\n"
				+ "      \"description\": \"The Alphonso mango is a seasonal fruit harvested from mid-April through the end of June. The time from flowering to harvest is about 90 days, while the time from harvest to ripening is about 15 days.The fruits generally weigh between 150 and 300 grams (5.3 and 10.6 oz), have a rich, creamy, tender texture and delicate, non-fibrous, juicy pulp. As the fruit matures, the skin of an Alphonso mango turns golden-yellow with a tinge of red across the top of the fruit\",\r\n"
				+ "      \"image_url\": \"https://en.wikipedia.org/wiki/Alphonso_mango#/media/File:Alphonso_mango.jpg\",\r\n"
				+ "      \"rate\": 1050,\r\n"
				+ "      \"quantity\": \"2\",\r\n"
				+ "      \"amount_before_tax\": \"2100.00\",\r\n"
				+ "      \"tax\": \"105.00\",\r\n"
				+ "      \"total_amount\": \"2205.00\",\r\n"
				+ "      \"serial_numbers\": [\r\n"
				+ "        \"359043372654548\",\r\n"
				+ "        \"359043371395481\"\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"bank_account\": {\r\n"
				+ "    \"account_number\": \"10038849992883\",\r\n"
				+ "    \"name\": \"Diana Prince\",\r\n"
				+ "    \"ifsc\": \"ICIC0000011\"\r\n"
				+ "  },\r\n"
				+ "  \"custom_attributes\": {\r\n"
				+ "    \"name\": \"Diana\",\r\n"
				+ "    \"place\": \"Themyscira\",\r\n"
				+ "    \"animal\": \"Jumpa\",\r\n"
				+ "    \"thing\": \"Tiara\"\r\n"
				+ "  }\r\n"
				+ "}}";
		Response createOrderResp = given().header("Authorization", "Bearer " + bearerToken).body(createOrderRequestBody).contentType(ContentType.JSON)
		.post("api/v3/create-order");
		createOrderResp.then().log().all();
		
		String orderId = createOrderResp.jsonPath().get("order_id");
		String userToken = createOrderResp.jsonPath().get("user.token");
		
		//Initiate Payment
		
		LinkedHashMap<String, String> initiatePaymentHeader = new LinkedHashMap<String, String>();
		initiatePaymentHeader.put("Authorization", "Bearer " + bearerToken);
		initiatePaymentHeader.put("x-nimbbl-user-token",userToken);
		String initiatePaymentRequsetBody = "{\r\n"
				+ "  \"order_id\": \""+orderId+"\",\r\n"
				+ "  \"callback_url\": \"https://mangoseller.awesome/transaction-response\",\r\n"
				+ "  \"payment_mode_code\": \"net_banking\",\r\n"
				+ "  \"bank_code\": \"axis\",\r\n"
				+ "}";
				
		Response initiatePaymentResponseBody = given().headers(initiatePaymentHeader).body(initiatePaymentRequsetBody).contentType(ContentType.JSON)
		.post("api/v3/initiate-payment");
		initiatePaymentResponseBody.then().log().all();
		String reDirectUrl = initiatePaymentResponseBody.jsonPath().get("next[0].url");
		String transactionId = initiatePaymentResponseBody.jsonPath().get("transaction_id");
		
		System.out.println("re DirectUrl is : "+ reDirectUrl);
		System.out.println("transaction Id is : "+ transactionId);
		
		//webhook payment confirmation
		
		
		
		
	}

}
