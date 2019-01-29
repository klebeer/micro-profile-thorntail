package ec.devnull.group.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GROUP_INFO")
@NamedQueries({
        @NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g")
})
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @Basic(optional = false)
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    private String description;


}
