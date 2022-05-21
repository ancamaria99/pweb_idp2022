package license.refugeesShelter.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_id_seq_name")
    @SequenceGenerator(name = "bookings_id_seq_name", sequenceName = "bookings_id_seq", allocationSize = 1)
    private Long bookingId;

    @Column(name = "name")
    private String name;

    @Column(name = "average_price_per_night_per_person")
    private float averagePricePerNightPerPerson;

    @Column(name = "link")
    private String link;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "FK_booking_city"))
    private City city;
}
