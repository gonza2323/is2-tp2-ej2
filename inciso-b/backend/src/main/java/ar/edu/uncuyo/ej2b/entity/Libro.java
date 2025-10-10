package ar.edu.uncuyo.ej2b.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer fecha;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Integer paginas;

    private boolean eliminado;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Autor> autores;
}
