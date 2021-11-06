package edu.attractor.demo.entities;

import edu.attractor.demo.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotBlank
    @Size(min = 5)
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6 )
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole userRole;

}
