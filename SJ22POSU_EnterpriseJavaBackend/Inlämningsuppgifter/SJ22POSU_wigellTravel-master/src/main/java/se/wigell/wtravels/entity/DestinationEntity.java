package se.wigell.wtravels.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_DESTINATION")
public class DestinationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "dest_HotelNamn",length = 30,nullable = false)
    private String destHotelNamn;

    @Column(name = "dest_desc",length = 100)
    private String destDesc;

    @Column(name = "dest_PriceWeek",length = 10)
    private int priceWeek;

    @Column(name = "dest_Status",length = 2,nullable = false)
    private int destStatus;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "destination_address_id")
    private AddressEntity  destination_address_id;

    public DestinationEntity() {
    }

    public DestinationEntity(String destHotelNamn, String destDesc, int priceWeek, int destStatus) {
        this.destHotelNamn = destHotelNamn;
        this.destDesc = destDesc;
        this.priceWeek = priceWeek;
        this.destStatus = destStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestHotelNamn() {
        return destHotelNamn;
    }

    public void setDestHotelNamn(String destHotelNamn) {
        this.destHotelNamn = destHotelNamn;
    }

    public String getDestDesc() {
        return destDesc;
    }

    public void setDestDesc(String destDesc) {
        this.destDesc = destDesc;
    }

    public int getDestStatus() {
        return destStatus;
    }

    public void setDestStatus(int destStatus) {
        this.destStatus = destStatus;
    }

    public AddressEntity getDestination_address_id() {
        return destination_address_id;
    }

    public void setDestination_address_id(AddressEntity destination_address_id) {
        this.destination_address_id = destination_address_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPriceWeek() {
        return priceWeek;
    }

    public void setPriceWeek(int priceWeek) {
        this.priceWeek = priceWeek;
    }

    @Override
    public String toString() {
        return "DestinationEntity{" +
                "id=" + id +
                ", destHotelNamn='" + destHotelNamn + '\'' +
                ", destDesc='" + destDesc + '\'' +
                ", priceWeek=" + priceWeek +
                ", destStatus=" + destStatus +
                ", destination_address_id=" + destination_address_id +
                '}';
    }
}
