import java.io.*;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;




 abstract class Flower {
 String name;
 String colour;
 int cost;
 static int total;

 Flower(String name, String colour, int cost) {
  this.name = name;
  this.colour = colour;
  this.cost = cost;
 }

 public String getName() {
  return name;
 }
 public String getColour() {
  return colour;
 }
 public int getCost() {
  return cost;
 }


 public String toString() {
  return name + " " + colour + " " + cost;
 }

 public void printCharacteristics() {

  System.out.println(name + " of " + colour + " colour are available only, " + cost + " pounds");

 }




 static class Daffodil extends Flower {

  Daffodil(String name, String colour, int cost) {
   super(name, colour, cost);
   System.out.println();
   total += cost;
  }




 }
 static class Rose extends Flower {

  Rose(String name, String colour, int cost) {
   super(name, colour, cost);
   total += cost;
  }

 }

 static class Chamomile extends Flower {

  Chamomile(String name, String colour, int cost) {
   super(name, colour, cost);
   total += cost;
  }


 }

 static class Cactus extends Flower {

  Cactus(String name, String colour, int cost) {
   super(name, colour, cost);
   total += cost;
  }

 }



 public static class Bouquet {

  static Collection fill(Collection < Flower > collection) {





   collection.add(new Daffodil("Daffodils", "yellow", 20));


   collection.add(new Rose("Roses", "red", 30));
   collection.add(new Chamomile("Chamomiles", "white", 40));
   collection.add(new Cactus("Cactuses", "green", 50));


   Gson gson = new Gson();
   String jsonNames = gson.toJson(collection);

   System.out.println("Checking convertation into json:"  + "\n" + "jsonNames = " + jsonNames);
   return collection;

  }
  
  public static  void readJsonFromString(){
	  
	  Gson gson = new Gson();
	  String jsonInString = "{'name' : 'Daffodils', 'colour' : 'yellow', 'cost' : '20'}";
	  Daffodil daff = gson.fromJson(jsonInString, Daffodil.class);
	  String jsonInString1 = "{'name' : 'Roses', 'colour' : 'red', 'cost' : '30'}";
	  Rose ros = gson.fromJson(jsonInString1, Rose.class);
	  String jsonInString2 = "{'name' : 'Chamomiles', 'colour' : 'white', 'cost' : '40'}";
	  Chamomile cham = gson.fromJson(jsonInString2, Chamomile.class);
	  String jsonInString3 = "{'name' : 'Cactus', 'colour' : 'green', 'cost' : '50'}";
	  Cactus cac = gson.fromJson(jsonInString3, Cactus.class);
	  System.out.println("Checking reading json from String:" + "\n" + daff + " " + ros +" "+ cham + " "+ cac + "\n");
	  
	  
  }
  
  public static  void readJsonFromFile() throws JsonSyntaxException, JsonIOException, FileNotFoundException{
	  
	  Gson gson = new Gson();
	  
	  Daffodil d =  gson.fromJson(new FileReader("file.json"), Daffodil.class);
	  Rose r =  gson.fromJson(new FileReader("file1.json"), Rose.class);
	  Chamomile c =  gson.fromJson(new FileReader("file2.json"), Chamomile.class);
	  Cactus cc =  gson.fromJson(new FileReader("file3.json"), Cactus.class);
	  
	  System.out.println("Checking reading json from json file:" + "\n" + d + " " + r + " " + c +" "+ cc+ "\n");
	  
	  
  }

 


  public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
	  
	  
   readJsonFromFile();


   readJsonFromString();


   System.out.println("Just printing this list:" + "\n" + fill(new ArrayList < Flower > ()));

   
   
   Daffodil dff = new Daffodil("Daffodils", "yellow", 20);


   dff.printCharacteristics();

   Rose rs = new Rose("Roses", "red", 30);
   rs.printCharacteristics();

   Chamomile ch = new Chamomile("Chamomiles", "white", 40);
   ch.printCharacteristics();

   Cactus ct = new Cactus("Cactuses", "green", 50);
   ct.printCharacteristics();
   System.out.println("The total sum of your bouquet is: " + Flower.total + " pounds");




  }

 }
}
