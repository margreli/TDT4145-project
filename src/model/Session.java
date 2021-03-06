package model;

import java.text.SimpleDateFormat;
import java.util.Date;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Session {
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private ObjectProperty<Date> startDate;
	private ObjectProperty<Date> endDate;
	private String inOrOut = "in";
	private SimpleIntegerProperty personalShape;
	private SimpleIntegerProperty prestation;
	private StringProperty note;

	Session(Date startDate, Date endDate, String inOrOut, Integer personalShape, Integer prestation, String note) {
		this.startDate = new SimpleObjectProperty<>(startDate);
		this.endDate = new SimpleObjectProperty<>(endDate);
		this.inOrOut = inOrOut;
		this.personalShape = new SimpleIntegerProperty(personalShape);
		this.prestation = new SimpleIntegerProperty(prestation);
		this.note = new SimpleStringProperty(note); 
	}
	
	public Date getStartDate() {
		if (startDate == null) {
			return null;
		} else {
			return startDate.get();
		}
	}
	
	public Date getEndDate() {
		if (endDate == null) {
			return null;
		} else {
			return endDate.get();
		}
	}
	
	public String getStartDateString() {
		if (startDate == null) {
			return null;
		} else {
			return formatter.format(startDate.get());
		}
	}
	
	public String getEndDateString() {
		if (endDate == null) {
			return null;
		} else {
			return formatter.format(endDate.get());
		}
	}
	
	public int getPersonalShape() {
		return personalShape.get();
	}
	
	public int getPrestation() {
		return prestation.get();
	}
	
	public String getNote() {
		return note.get();
	}

	public String getInOrOut() {
	    return inOrOut;
    }

}
