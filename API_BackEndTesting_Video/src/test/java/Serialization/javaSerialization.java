package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSgame implements Serializable{
	
	String name;
	int level;
	long score;
	int life;
	
	public NFSgame(String name, int level, long score, int life) {
		
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

public class javaSerialization {

	public static void main(String[] args) throws IOException {
		
		NFSgame user1Obj = new NFSgame("Raju", 10, 27000, 3);
		FileOutputStream fos = new FileOutputStream("./f.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(user1Obj);
		System.out.println("===END===");

	}
}
