package fr.univaix.iut.persistance;

import static org.junit.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.junit.Test;
import fr.iut.pokebattle.persistance.DataObjectAttack;
import fr.iut.pokebattle.persistance.Loadgson;
import fr.iut.pokebattle.persistance.PokeStats;

public class PersistanceTest {
	private Loadgson loader = new Loadgson();

	@Test
	public void testLoadgsonAttaqueFromString() throws FileNotFoundException {

		assertEquals(
				"DataObjectAttack{niveau='Départ', nom='Éclair', puissance=40, precision=100, pp=30}",
				loader.gsonPokemonEncodeFromString("{\"numéro\": \"025\",\"nom\": \"Pikachu\",\"nomen\": \"Pikachu\",\"nomja\": \"ピカチュウ\",\"nomromaji\": \"Pikachū\",\"nomtm\": \"Pikachu\",\"nomde\": \"Pikachu\",\"nomko\": \"피카츄''Pikachyu''\",\"nomch\": \"皮卡丘''Píkǎqiū''\",\"légende\": \"ArtworkparKenSugimori\",\"ndex\": \"025\",\"jdex\": \"022\",\"hdex\": \"156\",\"sdex\": \"104\",\"fdex\": \"023\",\"adex\": \"002\",\"odex\": \"R-005\",\"opdex\": \"N-154\",\"espece\": \"Souris\",\"taille\": \"0.4\",\"poids\": \"6.0\",\"fmratio\": \".500\",\"couleur\": \"Jaune\",\"oeufpas\": \"2560\",\"effortval\": \"+2Vit.\",\"type1\": \"Électrique\",\"expval\": \"82\",\"expmax\": \"1000000\",\"captureval\": \"190\",\"groupoeuf1\": \"Sol\",\"groupoeuf2\": \"Fée\",\"capspe1\": \"Statik\",\"forme\": \"8\",\"pokemon\": \"Pikachu\",\"numero\": \"025\",\"artwork_supp1-nom\": \"Génération1\",\"artwork_supp1-img\": \"PikachuRB.png{{!}}x140px\",\"artwork_supp2-nom\": \"''Jaquettede[[PokémonJaune]]''\",\"artwork_supp2-img\": \"Pikachu_-_Pokémon_Jaune.png\",\"artwork_supp3-nom\": \"[[PokémonRanger2]]\",\"artwork_supp3-img\": \"Pikachu-Ranger2.png{{!}}x140px\",\"artwork_supp4-nom\": \"[[PokémonDonjonMystère]]\",\"artwork_supp4-img\": \"Pikachu-DM.png{{!}}x140px\",\"artwork_supp5-nom\": \"[[PokémonDonjonMystère2]]\",\"artwork_supp5-img\": \"Pikachu-DM2.png{{!}}x140px\",\"artwork_supp6-nom\": \"[[PokémonDonjonMystère:ExplorateursduCielExplorateursduCiel]]\",\"artwork_supp6-img\": \"Pikachu-EdC.png\",\"pinballRB-gif\": \"oui\",\"pinballRS\": \"oui\",\"pinballRS-gif\": \"oui\",\"pdm\": \"oui\",\"almia\": \"oui\",\"diff_rs-rfvf\": \"oui\",\"diff_dp-pt\": \"oui\",\"diff-fm\": \"oui\",\"attaques\": [{\"niveau\": \"Départ\",\"nom\": \"Éclair\",\"puissance\": \"40\",\"precision\": \"100\",\"pp\": \"30\"},{\"niveau\": \"Départ\",\"nom\": \"Rugissement\",\"puissance\": \"-\",\"precision\": \"100\",\"pp\": \"40\"},{\"niveau\": \"N.6\",\"nom\": \"Mimi-Queue\",\"puissance\": \"-\",\"precision\": \"100\",\"pp\": \"30\"},{\"niveau\": \"N.9\",\"nom\": \"Cage-Éclair\",\"puissance\": \"-\",\"precision\": \"100\",\"pp\": \"20\"},{\"niveau\": \"N.16\",\"nom\": \"Vive-Attaque\",\"puissance\": \"40\",\"precision\": \"100\",\"pp\": \"30\"},{\"niveau\": \"N.15\",\"nom\": \"Reflet\",\"puissance\": \"-\",\"precision\": \"-\",\"pp\": \"15\"},{\"niveau\": \"N.20\",\"nom\": \"Souplesse\",\"puissance\": \"80\",\"precision\": \"75\",\"pp\": \"20\"},{\"niveau\": \"N.26\",\"nom\": \"Tonnerre\",\"puissance\": \"95\",\"precision\": \"100\",\"pp\": \"15\"},{\"niveau\": \"N.26\",\"nom\": \"Météores\",\"puissance\": \"60\",\"precision\": \"-\",\"pp\": \"20\"},{\"niveau\": \"N.33\",\"nom\": \"Hâte\",\"puissance\": \"-\",\"precision\": \"-\",\"pp\": \"30\"},{\"niveau\": \"N.43\",\"nom\": \"Fatal-Foudre\",\"puissance\": \"120\",\"precision\": \"70\",\"pp\": \"10\"},{\"niveau\": \"N.50\",\"nom\": \"Mur Lumière\",\"puissance\": \"-\",\"precision\": \"-\",\"pp\": \"30\"}]}")[0]
						.toString());

	}

	@Test
	public void testLoadgsonAttaqueFromFile() throws FileNotFoundException {
		assertEquals(
				"DataObjectAttack{niveau='Départ', nom='Éclair', puissance=40, precision=100, pp=30}",
				loader.gsonPokemonEncodeFromFile("pikachuattacking.json")[0].toString());
	}

	
	@Test
	public void testgsonPokemonEncode() throws FileNotFoundException {
	
		FileInputStream fs = new FileInputStream("pikachuattacking.json");
		DataObjectAttack DAO[] = loader.gsonPokemonAttackEncode(fs);
		assertEquals( "DataObjectAttack{niveau='Départ', nom='Éclair', puissance=40, precision=100, pp=30}", DAO[0].toString() );
		
	}
	
	@Test
	public void testjsonAttacktoPokestats() throws FileNotFoundException {
		PokeStats pok = new PokeStats();
		DataObjectAttack attck[] = loader.gsonPokemonEncodeFromFile("pikachuattacking.json");
		
		assertEquals("DataObjectAttack{niveau='Départ', nom='Éclair', puissance=40, precision=100, pp=30}", attck[0].toString());
	}
	
	

}
