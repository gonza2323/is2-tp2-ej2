package ar.edu.uncuyo.ej2b.mapper;

import ar.edu.uncuyo.ej2b.dto.LocalidadDto;
import ar.edu.uncuyo.ej2b.entity.Localidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocalidadMapper {


    Localidad toEntity(LocalidadDto dto);


    void updateEntityFromDto(LocalidadDto dto, @MappingTarget Localidad localidad);

    LocalidadDto toDto(Localidad localidad);

    List<LocalidadDto> toDtos(List<Localidad> localidades);
}
