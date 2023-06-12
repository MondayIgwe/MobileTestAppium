package org.database.Entity;

/*
    Plain Old Java Objects (POJO)
 */
public class ClassicModelEntity {

    private String BookName;
    private String PurcharsedDate;
    private int Amount;
    private String Location;
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getPurcharsedDate() {
        return PurcharsedDate;
    }

    public void setPurcharsedDate(String purchahsedDate) {
        PurcharsedDate = purchahsedDate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

}
