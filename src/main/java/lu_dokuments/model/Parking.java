package lu_dokuments.model;

import javax.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parking_id")
    private int parkingId;

    @Column(name = "description")
    private String parkingDescription;

    @Column(name = "lector_fk")
    private int lectorParkingFk;

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingDescription() {
        return parkingDescription;
    }

    public void setParkingDescription(String parkingDescription) {
        this.parkingDescription = parkingDescription;
    }

    public int getLectorParkingFk() {
        return lectorParkingFk;
    }

    public void setLectorParkingFk(int lectorParkingFk) {
        this.lectorParkingFk = lectorParkingFk;
    }
}
