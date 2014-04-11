package fr.iut.pokebattle.persistance;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class Loadgson {
	public Loadgson() {
		super();
	}

	public  DataObjectAttack[] gsonPokemonEncodeFromString(String Json) {
		return gsonPokemonEncode(new ByteArrayInputStream(Json.getBytes()));
	}

	public  DataObjectAttack[] gsonPokemonEncodeFromFile(String File)
			throws FileNotFoundException {
		return gsonPokemonEncode(new FileInputStream("pikachu.json"));
	}
	
	private static DataObjectAttack[] gsonPokemonEncode(InputStream inputStream) {
		Gson gson = new Gson();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));

		DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);
		// renvoie la premiere attaque
		return obj[0].getAttaques();

	}

	
}
