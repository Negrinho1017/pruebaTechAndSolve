import { TestBed, inject } from '@angular/core/testing';

import { ListadoRespuestasAlUsuarioService } from './listado-respuestas-al-usuario.service';

describe('ListadoRespuestasAlUsuarioService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListadoRespuestasAlUsuarioService]
    });
  });

  it('should be created', inject([ListadoRespuestasAlUsuarioService], (service: ListadoRespuestasAlUsuarioService) => {
    expect(service).toBeTruthy();
  }));
});
