package com.coderscampus.arraylist;



public class CustomListApplication {
	public static void main(String[] args) {
		CustomList<String> list = new CustomArrayList<>();
		 for(int i=1; i<=80; i++) {
			 list.add("element" + i);
		 }

		 for(int i=0; i<list.getSize();i++) {
			System.out.println(list.get(i));
		}
	}
	}

