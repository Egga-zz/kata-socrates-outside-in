package de.egga.classicist;

/**
 * @author egga
 */
public class TestClock implements DateProvider {

    private String date;

    public TestClock(String initialDate) {
        this.date = initialDate;
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
