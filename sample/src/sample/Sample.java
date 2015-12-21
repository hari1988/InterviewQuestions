package sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Sample {

	public static void main(String[] args) {
			String strResp = "{\"latestEvent\":\"\",\"latestPrecall\":\"Pre-Call: Accepted<br><br> Phone: (505) 702-4125<br><br> Date:2015-11-17 08:00:00\"}";
		 	JsonParser parser = new JsonParser();
			JsonObject obj = (JsonObject)parser.parse(strResp);
			JsonElement element = obj.get("latestPrecall");
			
			System.out.println(element.getAsString());

	}

}
