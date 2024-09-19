package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Persona extends Base {

    @Column (name = "Nombre")
    private String nombre;
    @Column (name = "Apellido")
    private String apellido;
    @Column (name = "DNI", unique = true)
    private int dni;

}

