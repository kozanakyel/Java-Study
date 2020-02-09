
package quadraticequations;

import java.util.Scanner;

public class QuadraticEquations {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter values for a, b, and c
        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        // Create a QuadraticEquation object
        QuadraticEquat quadraticEquation = new QuadraticEquat(a, b, c);

        // Compute the real roots of the quadriatic equation if any.
        System.out.print("The equation has ");
        if (quadraticEquation.getDiscriminant() < 0)
            System.out.println("no real roots");
        else if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("two roots " + quadraticEquation.getRoot1() + 
                " and " + quadraticEquation.getRoot2());
        }
        else {
            System.out.println("one root " + (quadraticEquation.getRoot1() > 0 ? 
                quadraticEquation.getRoot1() : quadraticEquation.getRoot2()));
        }
    }
    
}
