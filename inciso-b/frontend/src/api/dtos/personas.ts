import { z } from 'zod';

export const DomicilioCreateDto = z.object({
  id: z.number().optional(),
  calle: z
    .string({
      required_error: "Debe indicar la calle",
    })
    .min(1, "Debe indicar la calle")
    .max(50, "Máximo 50 caracteres"),
  numeracion: z
    .number({
      required_error: "Debe indicar la numeración",
      invalid_type_error: "Debe indicar la numeración",
    }),
  localidadId: z
    .number({
      required_error: "Debe seleccionar una localidad",
      invalid_type_error: "Debe seleccionar una localidad",
    }),
});

export type DomicilioCreateDto = z.infer<typeof DomicilioCreateDto>;

export const DomicilioUpdateDto = DomicilioCreateDto;
export type DomicilioUpdateDto = z.infer<typeof DomicilioCreateDto>;

export const DomicilioDetailDto = DomicilioCreateDto;
export type DomicilioDetailDto = z.infer<typeof DomicilioCreateDto>;

export const DomicilioSummaryDto = DomicilioCreateDto;
export type DomicilioSummaryDto = z.infer<typeof DomicilioCreateDto>;


export const PersonaCreateDto = z.object({
  id: z.number().optional(),
  nombre: z
    .string({
      required_error: "El nombre no puede estar vacío",
    })
    .min(1, "El nombre no puede estar vacío")
    .max(50, "Máximo 50 caracteres"),
  apellido: z
    .string({
      required_error: "El apellido no puede estar vacío",
    })
    .min(1, "El apellido no puede estar vacío")
    .max(50, "Máximo 50 caracteres"),
  dni: z
    .number({
      required_error: "Debe indicar el DNI",
      invalid_type_error: "Debe indicar el DNI",
    }),
  domicilio: DomicilioCreateDto, 
});

export type PersonaCreateDto = z.infer<typeof PersonaCreateDto>;

export const PersonaUpdateDto = PersonaCreateDto;
export type PersonaUpdateDto = z.infer<typeof PersonaCreateDto>;

export const PersonaDetailDto = PersonaCreateDto;
export type PersonaDetailDto = z.infer<typeof PersonaCreateDto>;

export const PersonaSummaryDto = PersonaCreateDto;
export type PersonaSummaryDto = z.infer<typeof PersonaCreateDto>;