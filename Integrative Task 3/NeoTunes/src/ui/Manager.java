package ui;

import java.util.Scanner;
import model.Controller;

public class Manager {
    private Scanner sc;
    private Controller controller;

    public Manager() {
        sc = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.showMenu();
    }

    public void showMenu() {
        System.out.println("Hello");
    }
}