import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.

    // open scanner
    Scanner in = new Scanner(System.in);
    // print asking how many rounds, add into variable rounds
    System.out.println("How many rounds?");
    int rounds = Integer.parseInt(in.nextLine());
    // Print, "Welcome! What's up?" and add to transcript String
    System.out.println("Welcome! What's up?");
    String transcript="Welcome! What's up?";
    
    String input;
    String response= "";
    String[] bland = {"Uh huh..." , "Cool!" , "Interesting." , "Thank you for sharing."};

    for(int h=0; h<rounds; h++) {
      // take in input
      input = in.nextLine();
      // add input to transcript String
      transcript= transcript+ "\n" + input;

      response=input;
      
      
      // New attempt using split. word by word for loop checking for mirrorable words
      String[] inArr = input.split(" ");
      boolean unchanged = true;
      for(int i=0; i<inArr.length; i++) {
        if(inArr[i].contains(".")) {
          inArr[i]=inArr[i].replace(".","?");
        }
        if(inArr[i].equals("I") || inArr[i].equals("I?")) {
          inArr[i] = inArr[i].replace("I", "you");
          unchanged = false;
        }
        else if(inArr[i].equals("me")|| inArr[i].equals("me?")) {
          inArr[i] = inArr[i].replace("me", "you");
          unchanged = false;
        }
        else if(inArr[i].equals("Me")|| inArr[i].equals("Me?")) {
          inArr[i] = inArr[i].replace("Me", "You");
          unchanged = false;
        }
        else if(inArr[i].equals("am")|| inArr[i].equals("am?")) {
          inArr[i] = inArr[i].replace("am", "are");
          unchanged = false;
        }
        else if(inArr[i].equals("Am")|| inArr[i].equals("Am?")) {
          inArr[i] = inArr[i].replace("Am", "Are");
          unchanged = false;
        }
        else if(inArr[i].equals("are")|| inArr[i].equals("are?")) {
          inArr[i] = inArr[i].replace("are", "am");
          unchanged = false;
        }
        else if(inArr[i].equals("Are")|| inArr[i].equals("Are?")) {
          inArr[i] = inArr[i].replace("Are", "Am");
          unchanged = false;
        }
        else if(inArr[i].equals("you") || inArr[i].equals("You")|| inArr[i].equals("You?")|| inArr[i].equals("you?")) {
          inArr[i] = inArr[i].replace("you", "I");
          inArr[i] = inArr[i].replace("You", "I");
          unchanged = false;
        }
        else if(inArr[i].equals("my")|| inArr[i].equals("my?")) {
          inArr[i] = inArr[i].replace("my", "your");
          unchanged = false;
        }
        else if(inArr[i].equals("My")|| inArr[i].equals("My?")) {
          inArr[i] = inArr[i].replace("My", "Your");
          unchanged = false;
        }
        else if(inArr[i].equals("your")|| inArr[i].equals("your?")) {
          inArr[i] = inArr[i].replace("your", "my");
          unchanged = false;
        }
        else if(inArr[i].equals("Your")|| inArr[i].equals("Your?")) {
          inArr[i] = inArr[i].replace("Your", "My");
          unchanged = false;
        }

      }

      if(unchanged) {
        // if nothing has changed it means there's no mirror words, so we use the canned response array.
        response = bland[(int)(Math.random()*bland.length)];
      }
      else {
        // reconnects array of seperate words into a String with spaces
        response = "";
        for(int i=0; i<inArr.length-1; i++) {
          response+=inArr[i];
          response+=" ";
        }
        response+=inArr[inArr.length-1];
      }
      
      System.out.println(response);
      // add response to transcript
      transcript= transcript+ "\n" + response;
    }
      
    System.out.println("Thanks for chatting!\n" + "\nTRANSCRIPT: \n" + transcript);
    // Print, "Thanks for chatting!" and transcript
    in.close();
  }
}
