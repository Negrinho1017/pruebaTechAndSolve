import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoRespuestasAlUsuarioComponent } from './listado-respuestas-al-usuario.component';

describe('ListadoRespuestasAlUsuarioComponent', () => {
  let component: ListadoRespuestasAlUsuarioComponent;
  let fixture: ComponentFixture<ListadoRespuestasAlUsuarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoRespuestasAlUsuarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoRespuestasAlUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
