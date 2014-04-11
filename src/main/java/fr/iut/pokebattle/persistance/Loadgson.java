package fr.iut.pokebattle.persistance;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Loadgson {
	public Loadgson() {
		super();
	}

	public  DataObjectAttack[] gsonPokemonEncodeFromString(String Json) {
		String finalJson = "[" + Json + "]";
		return gsonPokemonEncode(new ByteArrayInputStream(finalJson.getBytes()));
	}

	public  DataObjectAttack[] gsonPokemonEncodeFromFile(String File)
			throws FileNotFoundException {
		return gsonPokemonEncode(new FileInputStream(File));
	}
	
	
	private static DataObjectAttack[] gsonPokemonEncode(InputStream inputStream) {
		Gson gson = new Gson();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));

		DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);
		
		return obj[0].getAttaques();

	}
	
	
}
