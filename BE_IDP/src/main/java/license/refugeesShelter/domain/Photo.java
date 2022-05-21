package license.refugeesShelter.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @Column(name = "photo_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photos_id_seq_name")
    @SequenceGenerator(name = "photos_id_seq_name", sequenceName = "photos_id_seq", allocationSize = 1)
    private Long photoId;

    @Column(name = "photo", columnDefinition = "BLOB")
    @Lob
    byte[] photo;
}
