/*
 *@date: 18/10/2019
 *@explainment; lab dersinde yapılamayan ödevin çözümü 
 *basit hata yaptın dikkat et!!!
 */
package randomgenerate;

import java.util.Random;
import java.util.Scanner;


public class RandomGenerate {

 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       
       
        Random rnd = new Random();
        int random = rnd.nextInt(100);
        
        int sayac = 0;
        int number = 0;
        while(number != random) {
            
        System.out.println("1 ila 100 arasında bir sayı giriniz: ");
        number = input.nextInt();
            
            if(number < random){
                System.out.println("yükselt...");               
            }    
            else if(number > random){
                System.out.println("alçalt...");             
            }
            sayac++;          
        }
        
        if(number == random){
            System.out.println("doğru");
            System.out.println(sayac + " denemede başarılı oldunuz...");
        }
        
    }
    
}
