package model;

import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    private int id;
    private LocalDateTime dateTime;
    private List<Cart> bill;

    public Bill() {
    }

    public Bill(int id, LocalDateTime dateTime, List<Cart> bill) {
        this.id = id;
        this.dateTime = dateTime;
        this.bill = bill;
    }
}
