import { TestBed, inject } from '@angular/core/testing';

import { PaginaPrincipalService } from './pagina-principal.service';

describe('PaginaPrincipalService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PaginaPrincipalService]
    });
  });

  it('should be created', inject([PaginaPrincipalService], (service: PaginaPrincipalService) => {
    expect(service).toBeTruthy();
  }));
});
