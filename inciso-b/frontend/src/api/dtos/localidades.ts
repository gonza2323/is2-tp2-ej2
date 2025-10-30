import { z } from 'zod';

export const LocalidadCreateDto = z.object({
  denominacion: z.string().nonempty ("El nombre no puede estar vacío"),
});
export type LocalidadCreateDto = z.infer<typeof LocalidadCreateDto>;

export const LocalidadDetailDto = z.object({
  id: z.number(),
  denominacion: z.string().min(1),
});
export type LocalidadDetailDto = z.infer<typeof LocalidadDetailDto>;

export const LocalidadSummaryDto = LocalidadDetailDto;
export type LocalidadSummaryDto = z.infer<typeof LocalidadSummaryDto>;

export const LocalidadUpdateDto = LocalidadDetailDto;
export type LocalidadUpdateDto = z.infer<typeof LocalidadUpdateDto>;
