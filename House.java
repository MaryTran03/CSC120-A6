/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house!");
  }

  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();
  }
  
  public boolean isResident(String name){
    return this.residents.contains(name);
  }
  public void moveIn(String name){
    if (isResident(name)){
      throw new RuntimeException("The resident is already in the house");
    } else {
      this.residents.add(name);
    }
  }

  public String moveOut(String name){
    if (isResident(name)){
      throw new RuntimeException("The resident is already in the house");
    } else {
      this.residents.remove(name);
      return name;
    }
  
  }
  public static void main(String[] args) {
    House Ziskind = new House("Ziskind", "1 Henshaw Avenue",3, true);
    Ziskind.moveIn("Trang");
    System.out.println(Ziskind);
  }

}

