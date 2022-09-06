package com.company.astronomia;

import java.io.*;
import java.util.*;

public class Main {

    private static final String pathJournalAstronomicalObject = "D:/Java Project/src/main/java/com/company/astronomia/JournalAstronomicalObject.txt";
    private static final String pathJournalBlackHole = "D:/Java Project/src/main/java/com/company/astronomia/JournalBlackHole.txt";
    private static final String pathJournalChangeAstronomicalObject = "D:/Java Project/src/main/java/com/company/astronomia/JournalChangeAstronomicalObject.txt";
    private static final String pathJournalChangeBlackHoles = "D:/Java Project/src/main/java/com/company/astronomia/JournalChangeBlackHoles.txt";

    public static void main(String[] args) {

        ArrayList<AstronomicalObject> listAstronomicalObjects = new ArrayList<>();
        List<AstronomicalObject> listChangesAstronomicalObjects = new ArrayList<>();
        ArrayList<BlackHoles> listBlackHoles = new ArrayList<>();
        List<BlackHoles> listChangeBlackHoles = new ArrayList<>();

        listAstronomicalObjects.add(new AstronomicalObject("Mercury", "Milky Way", 91L, 1631L));
        listAstronomicalObjects.add(new AstronomicalObject("Venera", "Milky Way", 41L, 1610L));
        listAstronomicalObjects.add(new AstronomicalObject("Mars", "Milky Way", 78L, 1534L));

        listBlackHoles.add(new BlackHoles("Swan X-1", 6000L, true));
        listBlackHoles.add(new BlackHoles("V Puppis", 960L, true));
        listBlackHoles.add(new BlackHoles("LB-1", 7400L, true));

        menu(listAstronomicalObjects, listChangesAstronomicalObjects, listBlackHoles, listChangeBlackHoles);
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
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Looking for a planet or a black hole?\nTo exit - enter exit");
            while (scanner.hasNext()) {
                String choice = scanner.nextLine();
                if (choice.toLowerCase(Locale.ROOT).equals("exit")) {
                    System.out.println("Exit!");
                    break;
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
                    System.out.println("Object not found!");
                }
                System.out.println("Enter again");
                System.out.println("Looking for a planet or a black hole?\nTo exit - enter exit");
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static AstronomicalObject addNewAstronomicalObject() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name planet");
            String name = scanner.nextLine();
            System.out.println("Enter galaxy");
            String galaxy = scanner.nextLine();
            System.out.println("Enter distance to earth");
            String distance = scanner.nextLine();
            System.out.println("Enter date of discovery");
            String date = scanner.nextLine();
            return new AstronomicalObject(name, galaxy, Long.parseLong(distance), Long.parseLong(date));
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BlackHoles addNewBlackHole() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name black hole");
            String name = scanner.nextLine();
            System.out.println("Enter distance to earth");
            String distance = scanner.nextLine();
            System.out.println("Black hole is a live?(true/false)");
            String isALive = scanner.nextLine();
            return new BlackHoles(name, Long.parseLong(distance), Boolean.parseBoolean(isALive));
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeNewAstronomicalObjectToFile(List<AstronomicalObject> listAstronomicalObjects) {
        listAstronomicalObjects.add(addNewAstronomicalObject());
        bufferAstronomicalObjects((ArrayList<AstronomicalObject>) listAstronomicalObjects);
    }

    public static void writeNewBlackHole(ArrayList<BlackHoles> listBlackHoles) {
        listBlackHoles.add(addNewBlackHole());
        bufferBlackHoles(listBlackHoles);
    }

    public static void bufferAstronomicalObjects(ArrayList<AstronomicalObject> listAstronomicalObjects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathJournalAstronomicalObject))) {
            List<AstronomicalObject> listBufferAstronomicalObjects = new ArrayList<>(listAstronomicalObjects);
            oos.writeObject(listBufferAstronomicalObjects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeChangeAstronomicalObject(ArrayList<AstronomicalObject> listAstronomicalObjects, List<AstronomicalObject> listChangesAstronomicalObjects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathJournalChangeAstronomicalObject))) {
            Scanner scanner = new Scanner(System.in);
            Date date = new Date();
            System.out.println("Enter name planet\nTo exit - enter exit");
            while (scanner.hasNext()) {
                String name = scanner.nextLine();
                if (name.equals("exit")) {
                    System.out.println("Exit!");
                    break;
                }
                for (AstronomicalObject listAstronomicalObject : listAstronomicalObjects) {
                    if (listAstronomicalObject.getName().equals(name)) {
                        System.out.println("Enter new distance to Earth");
                        String newDistance = scanner.nextLine();
                        String changeType = "Change";
                        long distance = listAstronomicalObject.getDistanceToEarth();
                        listAstronomicalObject.setDistanceToEarth(Long.parseLong(newDistance));
                        listChangesAstronomicalObjects.add(new AstronomicalObject(listAstronomicalObject.getName(), date, changeType, listAstronomicalObject.getDistanceToEarth()));
                        oos.writeObject(listChangesAstronomicalObjects);
                        if (Long.parseLong(newDistance) < distance / 2) {
                            System.out.println("!!! ATTENTION !!!\n!!!FAST APPROACH TO EARTH!!!");
                        }
                    }
                }
                System.out.println("Enter again");
                System.out.println("Enter name planet\n To exit - enter exit");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferBlackHoles(ArrayList<BlackHoles> listBlackHoles) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathJournalBlackHole))) {
            List<BlackHoles> listBufferBlackHoles = new ArrayList<>(listBlackHoles);
            oos.writeObject(listBufferBlackHoles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeChangeBlackHoles(ArrayList<BlackHoles> listBlackHoles, List<BlackHoles> listChangeBlackHoles) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathJournalChangeBlackHoles))) {
            Scanner scanner = new Scanner(System.in);
            Date date = new Date();
            System.out.println("Enter name black hole");
            String name = scanner.nextLine();
            for (BlackHoles listBlackHole : listBlackHoles) {
                if (listBlackHole.getName().equals(name)) {
                    String change = "Change";
                    System.out.println("Enter new distance to Earth");
                    String newDistance = scanner.nextLine();
                    System.out.println("Black is a live?(true/false)");
                    String isALive = scanner.nextLine();
                    long distance = listBlackHole.getDistanceToEarth();
                    listBlackHole.setDistanceToEarth(Long.parseLong(newDistance));
                    listBlackHole.setALive(Boolean.parseBoolean(isALive));
                    listChangeBlackHoles.add(new BlackHoles(listBlackHole.getName(), date, change, Long.parseLong(newDistance), Boolean.parseBoolean(isALive)));
                    oos.writeObject(listChangeBlackHoles);
                    if (Long.parseLong(newDistance) < distance / 2) {
                        System.out.println("!!! ATTENTION !!!\n!!! FAST APPROACH TO EARTH !!!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getStatisticsAstronomicalObjects() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathJournalChangeAstronomicalObject))) {
            System.out.println(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getStatisticsBlackHoles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathJournalChangeBlackHoles))) {
            System.out.println(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAstronomicalObject(ArrayList<AstronomicalObject> listAstronomicalObjects) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name astronomical object\nTo exit - enter exit");
            while (scanner.hasNext()) {
                String name = scanner.nextLine();
                if (name.equals("exit")) {
                    System.out.println("Exit!");
                    break;
                }
                listAstronomicalObjects.removeIf(listAstronomicalObject -> listAstronomicalObject.getName().equals(name));
                listAstronomicalObjects.trimToSize();
                System.out.println("Object delete!");
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static void printDialog() {
        System.out.println("""
                Select item:
                1. Show information all objects.
                2. Show objects at a distance.
                3. Add new astronomical object.
                4. Change astronomical object information.
                5. Delete astronomical object.
                6. Get statistic position astronomical objects.
                7. Add new black hole.
                8. Change black hole information.
                9. Get statistic position black holes.
                10. Exit.""");
    }

    public static void menu(ArrayList<AstronomicalObject> listAstronomicalObjects, List<AstronomicalObject> listChangesAstronomicalObjects,
                            ArrayList<BlackHoles> listBlackHoles, List<BlackHoles> listChangeBlackHoles) {
        try (Scanner scanner = new Scanner(System.in)) {
            printDialog();
            boolean methodEntry = true;
            while (methodEntry) {
                String number = scanner.nextLine();
                OperationMenu enumByUser = OperationMenu.enumByUser(number);
                if (enumByUser == null) {
                    System.out.println("Operation not found");
                    printDialog();
                    continue;
                }
                switch (enumByUser) {
                    case SNOW_INFORMATION_ALL_OBJECTS -> showInformationAllObject(listAstronomicalObjects, listBlackHoles);
                    case SHOW_OBJECT_AT_A_DISTANCE -> showObjectByDistance(listAstronomicalObjects, listBlackHoles);
                    case ADD_NEW_ASTRONOMICAL_OBJECT -> writeNewAstronomicalObjectToFile(listAstronomicalObjects);
                    case CHANGE_ASTRONOMICAL_OBJECT_INFORMATION -> writeChangeAstronomicalObject(listAstronomicalObjects, listChangesAstronomicalObjects);
                    case DELETE_ASTRONOMICAL_OBJECT -> deleteAstronomicalObject(listAstronomicalObjects);
                    case GET_STATISTICS_POSITION_ASTRONOMICAL_OBJECTS -> getStatisticsAstronomicalObjects();
                    case ADD_NEW_BLACK_HOLE -> writeNewBlackHole(listBlackHoles);
                    case CHANGE_BLACK_HOLE_INFORMATION -> writeChangeBlackHoles(listBlackHoles, listChangeBlackHoles);
                    case GET_STATISTICS_POSITION_BLACK_HOLES -> getStatisticsBlackHoles();
                    case EXIT -> {
                        methodEntry = false;
                        System.out.println("Completion!");
                    }
                    default -> System.out.println("Value not supported!");
                }
                if (methodEntry)
                    printDialog();
            }
        }
    }
}
