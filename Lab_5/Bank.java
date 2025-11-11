import java.util.Scanner;

class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    Account(String name, int accNo, String accType, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.accType = accType;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Updated balance: Rs " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        System.out.println("Updated balance: Rs " + balance);
    }

    void computeInterest(int years) {
        System.out.println("Interest not applicable for Current Account.");
    }

    void display() {
        System.out.println("\nAccount Holder: " + name);
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Type: " + accType);
        System.out.println("Balance: Rs " + balance);
    }
}

class Savings extends Account {
    double interestRate = 0.05;

    Savings(String name, int accNo, double balance) {
        super(name, accNo, "savings", balance);
    }

    void computeInterest(int years) {
        double interest = balance * Math.pow((1 + interestRate), years) - balance;
        balance += interest;
        System.out.println("Interest added: Rs " + interest + "\n Updated balance: Rs " + balance);
    }
}

class Current extends Account {
    double minBalance = 1000;
    double serviceCharge = 100;

    Current(String name, int accNo, double balance) {
        super(name, accNo, "current", balance);
    }

    void withdraw(double amount) {
        super.withdraw(amount);
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Service charge of Rs " + serviceCharge + " applied, New balance: Rs " + balance);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter account type (savings/current): ");
        String type = sc.nextLine().toLowerCase();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        Account acc;
        if (type.equals("savings")) {
            acc = new Savings(name, accNo, balance);
        } else {
            acc = new Current(name, accNo, balance);
        }

        int c;
        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute Interest");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    acc.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    acc.withdraw(withdraw);
                    break;

                case 3:
                    System.out.print("Enter number of years: ");
                    int years = sc.nextInt();
                    acc.computeInterest(years); 
                    break;

                case 4:
                    acc.display();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }
        while (c != 5);

        sc.close();
    }
}
