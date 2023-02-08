import java.util.*;
public class Main{
    static int randomGuess;
    public static void main(String[] args){

        int number,winningNum;
        Scanner input= new Scanner(System.in);

        while(true){

            winningNum=lottery();
            //System.out.println(winningNum);
            System.out.println("Enter your number of choice between 1 and 50");
            number=input.nextInt();


            if(number == winningNum){
                System.out.println("You've won the lottery!");
                break;
            }
        }
    }

    public static int lottery(){
        randomGuess= (int)(Math.random()*51);
        return randomGuess;
    }
}