import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Library{
   private ArrayList<String> bookList = new ArrayList<String>();
   public Library(){
       availableBooks();
   }
   public void ask(){
       System.out.println("IF YOU WANT TO ISSUE A BOOK ENTER 1 , IF YOU WANT TO ADD A BOOK ENTER 2");
       Scanner sc = new Scanner(System.in);
       int input = sc.nextInt();
       if (input>2 || input<1){
           System.out.println("Invalid command");
           ask();
       } else if (input==1) {
           issueBook();
       } else if (input==2) {
           addBooks();
       }
   }

   public void addBooks(){
       System.out.println("Enter the title of book you wanna add to library");
       Scanner sc = new Scanner(System.in);
       String book = sc.nextLine();
       this.bookList.add(book);
       System.out.println("The book "+book+ " has been added to library successfully");
       Continue();
   }

    private void availableBooks(){
        this.bookList.add("Shelock Holmes By Arthur Canon Doyle");
        this.bookList.add("It ends with us By Collen Hover");
        this.bookList.add("It starts with us By Collen Hover");
        this.bookList.add("Think like a monk By Jay Shetty");
        this.bookList.add("Atomic Habits");
        this.bookList.add("Rich dad poor dad");
    }
    public void issueBook(){
       if(bookList.isEmpty()){
           System.out.println("Sorry, No Book is available this moment");
       }
       else {
           for (int i = 0; i < bookList.size(); i++) {
               System.out.println((i + 1) + ". " + bookList.get(i));
           }
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter Index No. of the book you want: ");
           int index = sc.nextInt();
           if (index > bookList.size() || index==0) {
               System.out.println("Invalid Index No. -_-");
               issueBook();
           } else {
               System.out.println("The book " + bookList.get(index - 1) + " is successfully issued");
               this.bookList.remove(index - 1);
           }
       }
    }
    public void Continue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 0 to end session , 1 to continue looking , 2 to add book");
        int reply = sc.nextInt();
        if (reply>2||reply<0){
            System.out.println("Invalid Command");
            Continue();
        }
        else if(reply==0){
            System.out.println("Bye......");
        }
        else if(reply==1){
            issueBook();
            Continue();
        } else if (reply==2) {
            addBooks();
        }
    }

}
public class Online_Library {
    public static void main(String[] args) {
        System.out.println("WELCOME TO OUR ONLINE LIBRARY MADE BY JA3");
        Library library = new Library();
        library.ask();
        library.Continue();

    }
}
