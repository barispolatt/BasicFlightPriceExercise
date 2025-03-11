import java.util.Scanner;

public class FlightPriceCalculator {
    public static void main(String[] args) {
        double distance, normalPrice, childDiscount = 0.5, youngDiscount = 0.1, oldDiscount = 0.3, typeDiscount = 0.2, lastPrice = 0;
        int age, type;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter flight distance (in kilometers): ");
        distance = input.nextDouble();

        System.out.print("Enter your age: ");
        age = input.nextInt();

        System.out.print("Enter flight type:\n1. One-way Ticket\n2. Two-way Ticket: ");
        type = input.nextInt();



        // invalid value control
        if (distance <= 0 || age < 0 || (type != 1 && type != 2)) {
            System.out.println("Invalid input! Please enter correct values.");
            return;
        }

        normalPrice = distance * 0.1;

        // age discount
        if (age < 12) {
            lastPrice = normalPrice - (normalPrice * childDiscount);
        } else if (age < 24) {
            lastPrice = normalPrice - (normalPrice * youngDiscount);
        } else if (age >= 65) {
            lastPrice = normalPrice - (normalPrice * oldDiscount);
        } else {
            lastPrice = normalPrice;
        }

        // Ticket type discount (just for two way)
        if (type == 2) {
            lastPrice -= normalPrice * typeDiscount;
            lastPrice *= 2; // 2 times price because it is two way ticket
        }

        // print last price
        System.out.printf("Total ticket price: %.2f TL\n", lastPrice);
    }
}
