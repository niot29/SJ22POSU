package se.wigell.wtravels.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_BOOKING")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "book_DepDate",length = 12)
    private String departure_date;
    @Column(name = "book_StayWeek;",length = 12)
   protected int stay_week;

    @Column(name = "book_TotalPriceSEK",length = 10)
    private int totalPriceSEK;

    @Column(name = "book_TotalPricePLN",length = 10)
    private int totalPricePLN;

    @ManyToOne(cascade = {CascadeType. PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "booking_Destination_id")
    private DestinationEntity  booking_Destination_id;

    @ManyToOne(cascade = {CascadeType. PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "booking_Customer_id")
    private CustomerEntity  booking_Customer_id;

    @Column(name = "book_Status",length = 2,nullable = false)
    private int bookStatus;

    public BookingEntity() {
    }

    public BookingEntity(String departure_date, int stay_week, int totalPriceSEK, int totalPricePLN, int bookStatus) {
        this.departure_date = departure_date;
        this.stay_week = stay_week;
        this.totalPriceSEK = totalPriceSEK;
        this.totalPricePLN = totalPricePLN;
        this.bookStatus = bookStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public int getStay_week() {
        return stay_week;
    }

    public void setStay_week(int stay_week) {
        this.stay_week = stay_week;
    }

    public DestinationEntity getBooking_Destination_id() {
        return booking_Destination_id;
    }

    public void setBooking_Destination_id(DestinationEntity booking_Destination_id) {
        this.booking_Destination_id = booking_Destination_id;
    }

    public CustomerEntity getBooking_Customer_id() {
        return booking_Customer_id;
    }

    public void setBooking_Customer_id(CustomerEntity booking_Customer_id) {
        this.booking_Customer_id = booking_Customer_id;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getTotalPriceSEK() {
        return totalPriceSEK;
    }

    public void setTotalPriceSEK(int totalPriceSEK) {
        this.totalPriceSEK = totalPriceSEK;
    }

    public int getTotalPricePLN() {
        return totalPricePLN;
    }

    public void setTotalPricePLN(int totalPricePLN) {
        this.totalPricePLN = totalPricePLN;
    }

    @Override
    public String toString() {
        return "BookingEntity{" +
                "id=" + id +
                ", departure_date='" + departure_date + '\'' +
                ", stay_week=" + stay_week +
                ", totalPriceSEK=" + totalPriceSEK +
                ", totalPricePLN=" + totalPricePLN +
                ", booking_Destination_id=" + booking_Destination_id +
                ", booking_Customer_id=" + booking_Customer_id +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
