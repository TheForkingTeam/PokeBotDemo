package fr.univaix.iut.pokebattle.twitter;

import fr.univaix.iut.pokebattle.tuse.Credentials;
import org.junit.Test;

import java.io.InputStream;

import static org.fest.assertions.Assertions.assertThat;

public class CredentialsTest {
    @Test
    public void testLoadCredentialsGivenAValidPropertiesFileShouldReturnAValidCredentials() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("./testCredentials.properties");
        Credentials credentials = Credentials.loadCredentials(inputStream);
        assertThat(credentials.getConsumerKey()).isEqualTo("QkVqtZYNgMI1JWPhb9ASmQ");
        assertThat(credentials.getConsumerSecret()).isEqualTo("iaLunlZTALfExpNgfuJZktd5vxI7d5s80MzmuMJixM");
        assertThat(credentials.getToken()).isEqualTo("2362510416-9P9bD0EpUCsYt3hPFO8v3l5FArMtIHj0gwj4ZrI");
        assertThat(credentials.getTokenSecret()).isEqualTo("sGTqbbqdyQcXUL11WJowOLc6YBUK7e6ZsxUVO1PBGODOg");
    }
}