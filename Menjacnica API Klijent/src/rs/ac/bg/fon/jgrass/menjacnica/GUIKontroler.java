package rs.ac.bg.fon.jgrass.menjacnica;

import java.awt.EventQueue;
import java.awt.List;
import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.omg.Messaging.SyncScopeHelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class GUIKontroler {
	private static Menjacnica frame;
	public static String url = "http://free.currencyconverterapi.com/api/v3/countries";
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Menjacnica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public static LinkedList<String> preuzimiZemlje() {
		LinkedList<String> nazivi = new LinkedList<String>();
		try {
			String result = GUIKontroler.preuzmiURL(GUIKontroler.url);
			Gson gson = new GsonBuilder().create();
			MyMap m = gson.fromJson(result, MyMap.class);
			for(Zemlja z : m.getResults().values()) {
				nazivi.add(z.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nazivi;
	}
	
	public static String preuzmiURL(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		
		boolean endReading = false;
		String response = "";
		
		while (!endReading) {
			String s = in.readLine();
			
			if (s != null) {
				response += s;
			} else {
				endReading = true;
			}
		}
		in.close();

		return response.toString();
		
	}
}
