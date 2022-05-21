package license.refugeesShelter.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shelters")
public class Shelter {

    @Id
    @Column(name = "shelter_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shelters_id_seq_name")
    @SequenceGenerator(name = "shelters_id_seq_name", sequenceName = "shelters_id_seq", allocationSize = 1)
    private Long shelterId;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "number_of_booked_slots")
    private Long numberOfBookedSlots;

    @NotNull
    @Column(name = "total_number_of_slots")
    private Long totalNumberOfSlots;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "FK_shelters_photos"))
    Photo photo;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "FK_shelter_city"))
    private City city;

    public Shelter updateFields(Shelter shelter) {
        this.name = shelter.getName();
        this.description = shelter.getDescription();
        this.phone = shelter.getPhone();
        this.numberOfBookedSlots = shelter.getNumberOfBookedSlots();
        this.totalNumberOfSlots = shelter.getTotalNumberOfSlots();
        this.photo = shelter.getPhoto();

        return this;
    }
}
