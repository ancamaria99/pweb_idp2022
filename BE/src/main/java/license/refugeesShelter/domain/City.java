package license.refugeesShelter.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_id_seq_name")
    @SequenceGenerator(name = "cities_id_seq_name", sequenceName = "cities_id_seq", allocationSize = 1)
    private Long cityId;

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "FK_city_country"))
    private Country country;
}
