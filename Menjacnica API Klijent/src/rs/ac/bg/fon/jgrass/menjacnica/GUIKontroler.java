package rs.ac.bg.fon.jgrass.menjacnica;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;




public class GUIKontroler {
	private static Menjacnica frame;
	private static File fajl = new File("data/log.json");
	private static String url = "http://free.currencyconverterapi.com/api/v3/countries";
	
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
	
	public static LinkedList<Zemlja> preuzimiZemlje() {
		LinkedList<Zemlja> zemlje = new LinkedList<Zemlja>();
		try {
			String result = GUIKontroler.preuzmiURL(GUIKontroler.url);
			Gson gson = new GsonBuilder().create();
			MyMap m = gson.fromJson(result, MyMap.class);
			for(Zemlja z : m.getResults().values()) {
				zemlje.add(z);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return zemlje;
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
	
	
	public static double konvertuj(String q) {
		String url1 = "http://free.currencyconverterapi.com/api/v3/convert?q=" + q;
		try {
			String result = preuzmiURL(url1);
			Gson gson = new GsonBuilder().create();
			JsonObject query = gson.fromJson(result, JsonObject.class).getAsJsonObject("query");
			int count = query.get("count").getAsInt();
			if(count == 0) {
				return 0;
			}
			JsonObject results = gson.fromJson(result, JsonObject.class).getAsJsonObject("results");
			JsonObject qObj = gson.fromJson(results, JsonObject.class).getAsJsonObject(q);
			return qObj.get("val").getAsDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static void ispisiPoruku() {
		JOptionPane.showMessageDialog(frame, "Ne postoje podaci o konverziji ove dve valute!");
	}
	
	public static void sacuvajUFajl(String izValuta, String uValuta, double kurs) {
		JsonObject object = new JsonObject();
		JsonArray array = new JsonArray();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		String datumVreme = format.format(new Date());
		
		object.addProperty("datumVreme", datumVreme);
		object.addProperty("izValuta", izValuta);
		object.addProperty("uValuta", uValuta);
		if(kurs == 0) {
			object.addProperty("kurs", "kurs");
		} else {
			object.addProperty("kurs", kurs);
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		if(fajl.exists()) {
			try {
				FileReader reader = new FileReader(fajl);
				array = gson.fromJson(reader, JsonArray.class);
				reader.close();
	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
			
		array.add(object);
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fajl));
			out.append(gson.toJson(array));
			out.close();
		} catch (Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
	}

}
