package model;
// Generated 2017-7-4 15:34:18 by Hibernate Tools 5.2.3.Final

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private int id;
	private String password;
	private byte character;
	private byte gender;
	private String name;

	public User() {
	}

	public User(int id, String password, byte character, byte gender, String name) {
		this.id = id;
		this.password = password;
		this.character = character;
		this.gender = gender;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getCharacter() {
		return this.character;
	}

	public void setCharacter(byte character) {
		this.character = character;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
