package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Results;

public class QualityController {

    private BufferedReader br;
    
	private DatabaseController dbController;

	public QualityController(DatabaseController dbController) {
		this.dbController = dbController;
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
    public void getSession() throws IOException {
        System.out.println("Do you want \n"
        		+ "1. heaviest lift or \n"
        		+ "2. longest run?");
        String inout = null;
        while(inout == null ){
            String input = br.readLine();
            dbController.showTable("SELECT * FROM Results;", "results");

            if (input.equals("1")){
            	String query = "SELECT sessionStartDateAndTime, exerciseName, MAX(weight) " + 
        				"FROM Results " + 
        				"GROUP BY exerciseName;";
            	dbController.showTable(query, "inResults");
            	inout = input;
            }
            else if(input == "2"){
                String query = "SELECT sessionStartDateAndTime, exerciseName, MAX(distance) " + 
        				"FROM Results " + 
        				"GROUP BY sessionStartDateAndTime;";
                dbController.showTable(query, "outResults");
                inout = input;
            }
            else{
                System.out.println("Det er ikke en godkjent treningstype (in/out)");
            }
        }
    }
}
