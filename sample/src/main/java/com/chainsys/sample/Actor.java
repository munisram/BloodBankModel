package com.chainsys.sample;

public class Actor {
	
	
	private String name;
	private int id;
	private Song song;
	
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	public Actor (int num,String name) {
		
		
		System.out.println(num+"welcome"+name);
	}
public Actor (int num,String name,int number) {
		
		
		System.out.println(num+"welcome"+name+number);
	}

	public void name(String n) {
		System.out.println(n+"dfghbn");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void printDate() {
		
		System.out.println(this.id);
		System.out.println(this.name);
		
	}
}
