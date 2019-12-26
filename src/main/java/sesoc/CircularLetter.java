package sesoc;

import java.util.Scanner;

public class CircularLetter{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String temp = sc.next();
        sc.close();
        Boolean result = true;
        
        for(int i = 0 ; i < temp.length() / 2 ; i++) {
            char t1 = temp.charAt(i);
            char t2 = temp.charAt(temp.length() -1 -i);
            if(t1==t2) {
                result = false;
                break;
            }
        } if (result)
            System.out.println(temp + "는 회문이 아닙니다.");
        else
            System.out.println(temp + "는 회문입니다.");
    }
}
