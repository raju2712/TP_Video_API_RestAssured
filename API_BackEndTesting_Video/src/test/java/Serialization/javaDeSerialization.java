package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class javaDeSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("./f.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		NFSgame user1 = (NFSgame) ois.readObject();
		System.out.println(user1.name);
		System.out.println(user1.level);
		System.out.println(user1.life);
		System.out.println(user1.score);

	}

}
