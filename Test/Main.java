class Vehicle{ 
    
      public void VehicleTypes(){
          System.out.println("General Vehicle");
  }
  }
  
 class Car extends Vehicle{
     
 
     public void VehicleTypes(){
          System.out.println("Car Vehicle");
  }
 }
 

 class Bike extends Vehicle{
          public void VehicleTypes(){
          System.out.println("Bike Vehicle");
  }
 }
 
public class Main{
    
 public static void main(String[]args){
     
     Car c = new Car();
     c.VehicleTypes();
     
 }
}