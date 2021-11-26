import kotlin.Triple;

import java.util.ArrayList;

public class App {
   public static void main(String [] args) {
      buyMammals(100,100);
      buyTicket(500);
   }

   public static void buyMammals(int budget, int amount) {
      Cock cock = new Cock();
      Hen hen = new Hen();
      Chicken chicken = new Chicken();

      ArrayList<Triple<Integer, Integer, Integer>> combinations = new ArrayList<>();
      ArrayList<Triple<Integer, Integer, Integer>> finalCombinations = new ArrayList<>();

      for(int c = 0; c <= 100; c++) {
         for(int h = 0; h <= 100; h++) {
            for(int ch = 0; ch <= 100; ch++) {
               if((cock.cost()*c + hen.cost()*h + chicken.cost()*ch) == budget) {
                  Triple<Integer, Integer, Integer> combination = new Triple(c, h, ch);
                  combinations.add(combination);
               }
            }
         }
      }

      for(int c = 0; c < combinations.size(); c++) {
         Integer cockNum = combinations.get(c).component1();
         Integer henNum = combinations.get(c).component2();
         Integer chickenNum = combinations.get(c).component3();
         if ((cock.amount()*cockNum + hen.amount()*henNum + chicken.amount()*chickenNum) == budget) {
               Triple<Integer, Integer, Integer> combination = new Triple(cockNum, henNum, chickenNum);
               finalCombinations.add(combination);
         }
      }

      System.out.println("Mammal Combination");
      for(int c = 0; c < finalCombinations.size(); c++) {
         System.out.println("Cock :" + finalCombinations.get(c).getFirst()
                 + " Hen :" + finalCombinations.get(c).getSecond()
                 + " Chicken :" + finalCombinations.get(c).getThird());
      }
   }

   public static void buyTicket(int budget) {
      Car car = new Car();
      Bus bus = new Bus();
      Train train = new Train();
      Plane plane = new Plane();

      System.out.println("Available tickets");
      if(budget >= car.cost()) {
         System.out.println("Driving");
      }
      if(budget >= bus.cost()) {
         System.out.println("Bus");
      }
      if(budget >= train.cost()) {
         System.out.println("Train");
      }
      if(budget >= plane.cost()) {
         System.out.println("Plane");
      }
   }
}