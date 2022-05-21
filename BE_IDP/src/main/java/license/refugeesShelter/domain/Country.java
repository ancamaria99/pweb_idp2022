package license.refugeesShelter.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_id_seq_name")
    @SequenceGenerator(name = "countries_id_seq_name", sequenceName = "countries_id_seq", allocationSize = 1)
    private Long countryId;

    @NotNull
    @Column(name = "name")
    private String name;
}
