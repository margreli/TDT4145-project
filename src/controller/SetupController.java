package controller;

import java.io.*;
import java.util.Properties;

public class SetupController {
    private ControllerManager manager;
    private BufferedReader br;

    public SetupController(ControllerManager manager){
        this.manager = manager;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void firstTimeSetUp() {
        Properties props = new Properties();
        props.setProperty("hosturl", "jdbc:mysql://localhost/");
        props.setProperty("dbname", "workoutdiary");
        String input;
        System.out.println("Enter username for your server:");
        try{
            input = br.readLine();
            props.setProperty("dbuser", input);
            System.out.println("Enter password for your server:");
            input = br.readLine();
            props.setProperty("dbpass", input);
            try {
                FileWriter writer = new FileWriter("resources/config.properties", false);
                props.store(writer,"--Database Settings--");
                writer.flush();
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e){
            System.out.println("An error happened when trying to read input.");
        }
        manager.getDatabaseController().connectToDB();
        setUp();
    }

    public void setUp() {

        System.out.println("What do you want to do?\n" +
                "1. Run first time setup\n" +
                "2. Exit setup"
        );
        String input;
        boolean notValidInput = true;
        try {
            while (notValidInput) {
                input = br.readLine();
                if (input.equals("1")){
                    firstTimeSetUp();
                    notValidInput = false;
                } else if (input.equals("2")){
                    notValidInput = false;
                }
            }
        } catch (IOException e) {
            System.out.println("An error happened when trying to read input.");
        }

    }

    private void dbSettings() {

    }

    private void createDB() {

    }

    private void populateDB() {

    }
}
