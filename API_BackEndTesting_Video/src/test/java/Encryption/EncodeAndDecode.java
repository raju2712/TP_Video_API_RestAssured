package Encryption;

import java.util.Base64;
import org.junit.Test;

public class EncodeAndDecode {

	@org.testng.annotations.Test
	public void encode() {
		
		String encodeData = new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(encodeData);
		
		String decodeData = new String(Base64.getDecoder().decode(encodeData.getBytes()));
		System.out.println(decodeData);
	}
}
