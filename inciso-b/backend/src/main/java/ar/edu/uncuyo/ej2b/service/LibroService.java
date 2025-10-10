package ar.edu.uncuyo.ej2b.service;

import ar.edu.uncuyo.ej2b.dto.LibroDto;
import ar.edu.uncuyo.ej2b.entity.Autor;
import ar.edu.uncuyo.ej2b.entity.Libro;
import ar.edu.uncuyo.ej2b.error.BusinessException;
import ar.edu.uncuyo.ej2b.mapper.LibroMapper;
import ar.edu.uncuyo.ej2b.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroService {
    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;
    private final AutorService autorService;

    @Transactional(readOnly = true)
    public Libro buscarLibro(Long id) {
        return libroRepository.findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> new BusinessException("El libro no existe"));
    }

    @Transactional(readOnly = true)
    public LibroDto buscarLibroDto(Long id) {
        Libro libro = buscarLibro(id);
        return libroMapper.toDto(libro);
    }

    @Transactional(readOnly = true)
    public List<LibroDto> listarLibrosDtos() {
        List<Libro> libros = libroRepository.findAllByEliminadoFalseOrderByTitulo();
        return libroMapper.toDtos(libros);
    }

    @Transactional
    public Libro crearLibro(LibroDto libroDto) {
        Libro libro = libroMapper.toEntity(libroDto);
        libro.setId(null);

        for (Long autorId : libroDto.getAutoresIds()) {
            Autor autor = autorService.buscarAutor(autorId);
            libro.getAutores().add(autor);
        }

        return libroRepository.save(libro);
    }

    @Transactional
    public Libro modificarLibro(LibroDto libroDto) {
        Libro libro = buscarLibro(libroDto.getId());

        libroMapper.updateEntityFromDto(libroDto, libro);

        libro.getAutores().clear();
        for (Long autorId : libroDto.getAutoresIds()) {
            Autor autor = autorService.buscarAutor(autorId);
            libro.getAutores().add(autor);
        }

        return libroRepository.save(libro);
    }

    @Transactional
    public void eliminarLibro(Long id) {
        Libro libro = buscarLibro(id);
        libro.setEliminado(true);
        libroRepository.save(libro);
    }
}
