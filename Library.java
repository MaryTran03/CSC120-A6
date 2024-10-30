import java.util.Hashtable;
import java.util.Map;
/* This is a stub for the Library class */
public class Library extends Building {
    private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String,Boolean>();
      System.out.println("You have built a library!");
    }

    public void addTitle(String title){
      if(this.containsTitle(title) == true){
        throw new RuntimeException("Title already in collection");
      } else {
        this.collection.put(title,true);
      }
    } 

    public String removeTitle(String title){
      if(this.containsTitle(title) == false){
        throw new RuntimeException("Title not in collection. Can't be removed");
      } else {
        this.collection.remove(title);
        return title;
      }
    }
  
    public void checkOut(String title){
      if(isAvailable(title) == true) {
        this.collection.replace(title,false);
      } else {
        throw new RuntimeException("Title has been borrowed and is not available to be checked out.");
      }
    } 
    
    public void returnBook(String title){
      if(!this.collection.containsKey(title)){
        throw new RuntimeException("Title wasn't checked out from this library. Wrong library perhaps?");
      } else {
        this.collection.replace(title,true);
      }
    } 

    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    public boolean isAvailable(String title){
      if (containsTitle(title) == false){
        throw new RuntimeException("Title is not available in the library");
      } else {
        return this.collection.get(title);
      }
    }

    public void printCollection(){
        // Print the header row
        System.out.printf("%-40s %-10s%n", "Book Title", "Available");
        System.out.println("---------------------------------------- ----------");

        // Print each book-availability status pair
        for (Map.Entry<String, Boolean> entry : this.collection.entrySet()) {
            System.out.printf("%-40s %-10s%n", entry.getKey(), entry.getValue());    
          }
        }

    public static void main(String[] args) {
      Library Neilson = new Library("Neilson","7 Neilson Drive",4);

      // Add books
      Neilson.addTitle("Hunger Games");
      Neilson.addTitle("Harry Potter");
      Neilson.addTitle("Fifty Shades of Grey");
      Neilson.addTitle("R for Data Science");
      Neilson.addTitle("The Miracle in Cell No 7");
      Neilson.addTitle("10 things I love about you");
      Neilson.addTitle("The Outsiders");

      // Remove books
      try {
        Neilson.removeTitle("Hunger Games");        
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      try {
        Neilson.removeTitle("Fifty Shades of Black");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      // Check out books
  
      try {
        Neilson.checkOut("Fifty Shades of Black");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      try {
        Neilson.checkOut("Fifty Shades of Grey");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      Neilson.checkOut("R for Data Science");
      Neilson.checkOut("The Outsiders");

      // Return Book
      
      try {
        Neilson.returnBook("Fifty Shades of Grey");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      try {
        Neilson.returnBook("Hunger Games");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      // Print the collection
      Neilson.printCollection();

    }
  }
