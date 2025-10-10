package ar.edu.uncuyo.ej2b.controller;

import ar.edu.uncuyo.ej2b.dto.AutorDto;
import ar.edu.uncuyo.ej2b.entity.Autor;
import ar.edu.uncuyo.ej2b.mapper.AutorMapper;
import ar.edu.uncuyo.ej2b.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;
    private final AutorMapper autorMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAutor(@PathVariable Long id) {
        AutorDto autor = autorService.buscarAutorDto(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping
    public ResponseEntity<?> listarAutores() {
        List<AutorDto> autores = autorService.listarAutoresDtos();
        return ResponseEntity.ok(autores);
    }

    @PostMapping
    public ResponseEntity<?> crearAutor(@Valid @RequestBody AutorDto autorDto) {
        Autor autor = autorService.crearAutor(autorDto);
        AutorDto dto = autorMapper.toDto(autor);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarAutor(@PathVariable Long id, @Valid @RequestBody AutorDto autorDto) {
        autorDto.setId(id);
        Autor autor = autorService.modificarAutor(autorDto);
        AutorDto dto = autorMapper.toDto(autor);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }
}
