package co.jast.monolito.tracking.domain.model.commands;

import java.util.Date;

/**
 * Add Tracking Event Command
 */
public class AddTrackingEventCommand {
    private String bookingId;
    private Date eventTime;
    private String eventType;
    private String location;
    private String voyageNumber;


    public AddTrackingEventCommand() {
    }

    public AddTrackingEventCommand(String bookingId, Date eventTime, String eventType, String location, String voyageNumber) {
        this.bookingId = bookingId;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.location = location;
        this.voyageNumber = voyageNumber;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getEventTime() {
        return this.eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVoyageNumber() {
        return this.voyageNumber;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }
}
