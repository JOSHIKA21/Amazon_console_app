import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

class admin {
    String admin_id;
    int admin_pass;

    public admin(String id, int pass) {
        this.admin_id = id;
        this.admin_pass = pass;
    }

    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> sell = new ArrayList<>();
    product p = new product(admin_pass, admin_id, admin_id, admin_pass, admin_pass, admin_pass);
    ArrayList<product> prod = p.productlist();
    user u = new user();
    ArrayList<String> cust = u.customer();

    public void adminRole() {
        System.out.print("Enter Your Admin id: ");
        String id = sc.next();
        System.out.print("Please Enter Password: ");
        int pass = sc.nextInt();
        if (id.equals("admin") && pass == 1111) {
            System.out.println();
            System.out.println("Successfully Logged in ");
            System.out.println();
            String s;
            do {
                System.out.println("What do you want to do?");
                System.out.println("1.Add Seller");
                System.out.println("2.Remove Seller");
                System.out.println("3.View Seller Details");
                System.out.println("4.View Product Details");
                System.out.println("5.View Customer Details");
                System.out.println("6.Exit");
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter your option to perform: ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        addSeller();
                        break;
                    case 2:
                        removeSeller();
                        break;
                    case 3:
                        viewSeller();
                        break;
                    case 4:
                        productList();
                        break;
                    case 5:
                        customerDetails();
                        break;
                    case 6:
                        System.out.println("Thank you! Have a nice day.");
                        return;
                    default:
                        System.out.println("Please enter a valid input.");
                }
                System.out.println("Do you want to continue? Y/N");
                s = sc.next();
            } while (s.equalsIgnoreCase("y"));
        } else {
            System.out.println("Admin id or password mismatch! Try again");
        }
    }

    void addSeller() {
        System.out.print("Enter seller id: ");
        int sid = sc.nextInt();
        System.out.println("Do you want to add seller with id " + sid + "? Yes / No");
        String str = sc.next();
        if (str.equals("Yes") || str.equals("yes") || str.equals("YES")) {
            sell.add(sid);
            System.out.println("Seller access given to " + sid);
        } else {
            System.out.println("Seller didn't added");
        }
    }

    void viewSeller() {
        System.out.println("Seller List: ");
        for (int s1 : sell) {
            System.out.println("Seller id: " + s1);
        }
    }

    void removeSeller() {
        System.out.print("Enter seller id to remove access ");
        int slid = sc.nextInt();
        int idx = sell.indexOf(slid);
        if (idx != -1) {
            System.out.println("Are you sure to remove seller access from " + slid + "? Y/N");
            String st = sc.next();
            if (st.equals("y") || st.equals("Y")) {
                sell.remove(idx);
                System.out.println("Seller access removed");
            } else {
                System.out.println("For your info still seller has access");
            }
        }

    }

    void productList() {
        System.out.println("Product List: ");
        for (product p1 : prod) {
            System.out.println("PRODUCT ID: " + p1.prod_id);
            System.out.println("PRODUCT NAME: " + p1.prod_name);
            System.out.println("PRODUCT CATEGORY: " + p1.prod_catg);
            System.out.println("PRODUCT QUANTITY: " + p1.prod_qnty);
            System.out.println("PRICE: " + p1.price);
            System.out.println("RATING: " + p1.rating);
            System.out.println("...........................................");
        }
    }

    void customerDetails() {
        System.out.println("Customer details");
        for (String us : cust) {
            System.out.println("Customer id: " + us);
        }
    }

}

class product {
    ArrayList<product> prodarr = new ArrayList<>();
    int prod_id;
    String prod_name;
    String prod_catg;
    int prod_qnty;
    double price;
    double rating;

    public product(int prod_id, String prod_name, String prod_catg, int prod_qnty, double price, double rating) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_catg = prod_catg;
        this.prod_qnty = prod_qnty;
        this.price = price;
        this.rating = rating;
    }

    public ArrayList<product> productlist() {
        prodarr.add(new product(101, "Airpods", "Gadgets", 1, 599, 4.5));
        prodarr.add(new product(102, "Headphones", "Gadgets", 1, 300, 4.2));
        prodarr.add(new product(201, "Watches", "Daily Wear", 1, 1099, 3.5));
        prodarr.add(new product(202, "Footwear", "Daily Wear", 2, 549, 4.4));
        prodarr.add(new product(203, "Dresses", "Daily Wear", 3, 999, 4.7));
        prodarr.add(new product(301, "Lipsticks", "Cosmetics", 12, 999, 4.0));
        prodarr.add(new product(202, "Shampo", "Cosmetics", 1, 99, 4.1));
        return prodarr;
    }
}

class seller {
    String sellid;
    String name;
    int pin;
    Scanner sc = new Scanner(System.in);
    admin a = new admin(sellid, pin);
    product p1 = new product(pin, name, name, pin, pin, pin);
    ArrayList<product> ls = p1.productlist();

    public seller() {
        this.sellid = sellid;
        this.name = name;
        this.pin = pin;
    }

    public void sellerRoles() {
        System.out.println("Enter Your seller id: ");
        int sid = sc.nextInt();

        System.out.println("Login successful");
        String c;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1.Add Product");
            System.out.println("2.Remove Product");
            System.out.println("3.View Product");
            System.out.println("4. Exit");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    viewProduct();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Please enter a valid option!!");
            }
            System.out.println("Do you want to continue? Y/N");
            c = sc.next();
        } while (c.equals("y") || c.equals("Y"));
    }

    void addProduct() {
        System.out.print("Enter Product id: ");
        int pid = sc.nextInt();
        System.out.print("Enter Product name: ");
        String pname = sc.next();
        System.out.print("Enter Product Category: ");
        String pcatg = sc.next();
        System.out.print("Enter Product Quantity: ");
        int pqnty = sc.nextInt();
        System.out.print("Enter Product Price: ");
        double pprice = sc.nextDouble();
        System.out.print("Enter Product Rating: ");
        double prate = sc.nextDouble();
        product p1 = new product(pid, pname, pcatg, pqnty, pprice, prate);
        ls.add(p1);
        System.out.println("Successfully Added");
    }

    void viewProduct() {
        System.out.println("Product List");
        for (product p : ls) {
            System.out.println("Product Id: " + p.prod_id);
            System.out.println("Product Name: " + p.prod_name);
            System.out.println("Product Category: " + p.prod_catg);
            System.out.println("Product Price: " + p.price);
            System.out.println("Product Rating: " + p.rating);
            System.out.println("...........................................");
        }
    }

    void removeProduct() {
        int i = 0;
        System.out.println("Enter product name to delete");
        String name = sc.next();
        for (product pr : ls) {
            if (name.equals(pr.prod_name)) {
                i = ls.indexOf(pr);
            }
        }
        ls.remove(i);
        System.out.println("Product Removed");
    }

    void viewProfit() {

    }
}

class user {
    String name;
    int id;

    public user() {
        product p = new product(id, name, name, id, id, id);
        this.products = p.productlist();
    }

    ArrayList<product> products = new ArrayList<>();
    ArrayList<String> cus = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    ArrayList<product> cart = new ArrayList<>();

    ArrayList<String> customer() {
        cus.add("1001");
        cus.add("1002");
        return cus;
    }

    void userFacility() {
        System.out.println("Enter your user id: ");
        String id = sc.next();
        if (cus.contains(id)) {
            System.out.println("Login successful");
            String c;
            do {
                System.out.println("What do you want to do? ");
                System.out.println("1.Search Product");
                System.out.println("2.View Product");
                System.out.println("3.Add to Cart");
                System.out.println("4.View Cart");
                System.out.println("5.Remove from cart");
                System.out.println("6.View Bill");
                System.out.println("7.Place Order");
                System.out.println("8.Exit");
                Scanner sc = new Scanner(System.in);
                System.out.print("Please choose an operation: ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        searchProduct();
                        break;
                    case 2:
                        viewProduct();
                        break;
                    case 3:
                        addCart();
                        break;
                    case 4:
                        viewCart();
                        break;
                    case 5:
                        removeCart();
                        break;
                    case 6:
                        viewBill();
                        break;
                    case 7:
                        placeOrder();
                        break;
                    case 8:
                        System.out.println("Thank you! come again");
                    default:
                        System.out.println("Please enter a valid option!!");
                }
                System.out.println("Do you want to continue? Y/N");
                c = sc.next();
            } while (c.equals("y") || c.equals("Y"));
        } else {
            System.out.println("Are you new to our site: ");
            System.out.println("If you want to Log in..? Please press 1");
            String s = sc.next();
            if (s.equals("1")) {
                System.out.print("Please enter your email id: ");
                String email = sc.next();
                System.out.print("Please enter your password to create account");
                String pas = sc.next();
                String uniqueID = System.currentTimeMillis() + "-" + UUID.randomUUID().toString();
                uniqueID = uniqueID.hashCode() + "";
                uniqueID = String.format("%02d", Math.abs(Integer.parseInt(uniqueID)));
                cus.add(uniqueID);
                System.out.println("Account successfully created");
                System.out.println();
                System.out.println("Your user id is: " + uniqueID);
                System.out.println("Use this id to login");
                System.out.println();
            }
        }

    }

    void searchProduct() {
        System.out.print("Enter product name to search: ");
        String name = sc.next();
        boolean found = false;
        for (product p1 : products) {
            if (p1.prod_name.contains(name) || p1.prod_catg.contains(name)) {
                System.out.println("PRODUCT ID: " + p1.prod_id);
                System.out.println("PRODUCT NAME: " + p1.prod_name);
                System.out.println("PRODUCT CATEGORY: " + p1.prod_catg);
                System.out.println("PRODUCT QUANTITY: " + p1.prod_qnty);
                System.out.println("PRICE: " + p1.price);
                System.out.println("RATING: " + p1.rating);
                System.out.println("........._________........");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product matching with " + name);
        }
    }

    void viewProduct() {
        System.out.println("Product List: ");
        for (product p1 : products) {
            System.out.println("PRODUCT ID: " + p1.prod_id);
            System.out.println("PRODUCT NAME: " + p1.prod_name);
            System.out.println("PRODUCT CATEGORY: " + p1.prod_catg);
            System.out.println("PRODUCT QUANTITY: " + p1.prod_qnty);
            System.out.println("PRICE: " + p1.price);
            System.out.println("RATING: " + p1.rating);
            System.out.println("...........................................");
        }
    }

    void addCart() {
        String cartprod;
        int qnty;
        int flag = 0, i;
        System.out.print("Enter product name to add to cart: ");
        cartprod = sc.next();
        System.out.print("Enter quantutyy of choosen product: ");
        qnty = sc.nextInt();
        for (product p1 : products) {
            if (p1.prod_name.equals(cartprod)) {
                for (i = 0; i < p1.prod_qnty; i++) {
                    cart.add(p1);
                    flag = 1;
                }
            }
        }
        if (flag == 1) {
            System.out.println("Product added to cart");
        } else if (flag == 0) {
            System.out.println("Product not available");
        }
        System.out.println();
    }

    void viewCart() {
        int num = 1;
        for (product p1 : cart) {
            System.out.println(num + "Product id: " + p1.prod_id);
            System.out.println("Product name: " + p1.prod_name);
            System.out.println("Product Category: " + p1.prod_catg);
            System.out.println("Product quantity: " + p1.prod_qnty);
            num += 1;
        }
        System.out.println();
    }

    void removeCart() {
        String name;
        int in = 0;
        System.out.print("Enter product name to be removed: ");
        name = sc.next();
        for (product p1 : cart) {
            if (p1.prod_name.equals(p1)) {
                in = cart.indexOf(name);
            }
        }
        cart.remove(in);
        System.out.println("Product removed");
        System.out.println();
    }

    void viewBill() {
        int num = 1;
        int bill = 0;
        for (product p1 : cart) {
            System.out.println(num + "Name: " + p1.prod_name);
            bill += p1.price;
            num += 1;
        }
        System.out.println("Your total bill amount is: Rs " + bill);
        System.out.println();
    }

    void placeOrder() {
        viewBill();
        System.out.println("Enter your Addredd: ");
        String address = sc.next();
        System.out.println();
        System.out.println("Your order is placed");
    }
}

public class amazon {
    public static void main(String[] args) {
        admin a1 = new admin("admin", 1111);
        seller s1 = new seller();
        user u1 = new user();
        String st;
        do {
            System.out.println("-------------------------------------------------");
            System.out.println("Welcome to our E-commerce site: ");
            System.out.println("Please choose your role:");
            System.out.println("1.Admin");
            System.out.println("2.Sellers");
            System.out.println("3.User");
            System.out.println("-------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your role: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    a1.adminRole();
                    break;
                case 2:
                    s1.sellerRoles();
                case 3:
                    u1.userFacility();
                default:
                    break;
            }
            System.out.println("Do you want to change role? Y/N");
            st = sc.next();
        } while (st.equalsIgnoreCase("y"));
    }
}
