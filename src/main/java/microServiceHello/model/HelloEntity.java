package microServiceHello.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "count_for_end_point")
@Getter
@Setter
public class HelloEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "count")
    private Long count;

}
