package com.company.astronomia;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class Main {

    private static final String pathJournalAstronomicalObject = "D:/Java Project/src/main/java/com/company/astronomia/JournalAstronomicalObject.txt";
    private static final String pathJournalBlackHole = "D:/Java Project/src/main/java/com/company/astronomia/JournalBlackHole.txt";

    public static void main(String[] args) {

        List<AstronomicalObject> listAstronomicalObjects = new ArrayList<>();
        List<AstronomicalObject> listChangesAstronomicalObjects = new ArrayList<>();
        List<BlackHoles> listBlackHoles = new ArrayList<>();

        listAstronomicalObjects.add(new AstronomicalObject("Mercury", "Milky Way", 91L, 1631L));
        listAstronomicalObjects.add(new AstronomicalObject("Venera", "Milky Way", 41L, 1610L));
        listAstronomicalObjects.add(new AstronomicalObject("Mars", "Milky Way", 78L, 1534L));

        listBlackHoles.add(new BlackHoles("Swan X-1", 6000L, true));
        listBlackHoles.add(new BlackHoles("V Puppis", 960L, true));
        listBlackHoles.add(new BlackHoles("LB-1", 7400L, true));

        //showInformationAllObject(listAstronomicalObjects,listBlackHoles);
        //showObjectByDistance(listAstronomicalObjects, listBlackHoles);

        //writeNewAstronomicalObjectToFile();
        //System.out.println(listAstronomicalObjects);
        readFile();
    }

    public static void showInformationAllObject(List<AstronomicalObject> listAstronomicalObjects, List<BlackHoles> listBlackHoles) {
        for (AstronomicalObject listAstronomicalObject : listAstronomicalObjects) {
            System.out.println(listAstronomicalObject);
        }
        for (BlackHoles listBlackHole : listBlackHoles) {
            System.out.println(listBlackHole);
        }
    }

    public static void showObjectByDistance(List<AstronomicalObject> listAstronomicalObjects, List<BlackHoles> listBlackHoles) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Looking for a planet or a black hole?\nTo exit - enter exit");
        outer:
        while (scanner.hasNext()) {
            String choice = scanner.nextLine();
            if (choice.toLowerCase(Locale.ROOT).equals("exit")) {
                System.out.println("Exit!");
                break outer;
            } else if (choice.toLowerCase(Locale.ROOT).equals("planet")) {
                System.out.println("Enter distance");
                String line = scanner.nextLine();
                long distance = Long.parseLong(line);
                for (AstronomicalObject listAstronomicalObject : listAstronomicalObjects) {
                    if (listAstronomicalObject.getDistanceToEarth() == distance) {
                        System.out.println(listAstronomicalObject);
                    }
                }
            } else if (choice.toLowerCase(Locale.ROOT).equals("black hole")) {
                System.out.println("Enter distance");
                String line = scanner.nextLine();
                long distance = Long.parseLong(line);
                for (BlackHoles listBlackHole : listBlackHoles) {
                    if (listBlackHole.getDistanceToEarth() == distance) {
                        System.out.println(listBlackHole);
                    }
                }
            } else {
                System.out.println("Enter again");
            }
            System.out.println("Enter again");
            System.out.println("Looking for a planet or a black hole?\nTo exit - enter exit");
        }
    }

    public static AstronomicalObject addNewAstronomicalObject() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter name planet");
            String name = scanner.nextLine();
            System.out.println("Enter galaxy");
            String galaxy = scanner.nextLine();
            System.out.println("Enter distance to earth");
            String distance = scanner.nextLine();
            System.out.println("Enter date of discovery");
            String date = scanner.nextLine();
            return new AstronomicalObject(name, galaxy, Long.parseLong(distance), Long.parseLong(date));
        }
    }

    public static Object addNewBlackHole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter name black hole");
            String name = scanner.nextLine();
            System.out.println("Enter distance to earth");
            String distance = scanner.nextLine();
            System.out.println("Black hole is a live?(true/false");
            String isALive = scanner.nextLine();
            return new BlackHoles(name, Long.parseLong(distance), Boolean.parseBoolean(isALive));
        }
    }

    public static void writeNewAstronomicalObjectToFile() {
        try (FileOutputStream fos = new FileOutputStream((pathJournalAstronomicalObject), true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            AstronomicalObject astronomicalObject = addNewAstronomicalObject();
            oos.writeObject(astronomicalObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNewBlackHole() {
        try (FileOutputStream fos = new FileOutputStream(pathJournalBlackHole);
             ObjectOutputStream ois = new ObjectOutputStream(fos)) {
            Object object = addNewBlackHole();
            ois.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
       try (FileInputStream fis = new FileInputStream(pathJournalAstronomicalObject);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
           List<AstronomicalObject> readList = new ArrayList<>();
           for (int i = 0; i < fis.available(); i++) {
                readList.add((AstronomicalObject) ois.readObject());
               System.out.println(readList);
           }
           } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
