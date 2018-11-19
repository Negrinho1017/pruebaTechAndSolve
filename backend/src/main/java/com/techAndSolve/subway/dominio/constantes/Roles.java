package com.techAndSolve.subway.dominio.constantes;

public enum Roles {
	
	USUARIO_CORRIENTE(1), USUARIO_ADMINISTRADOR(2);
	private Integer value;

	Roles(Integer a) {
		this.value = a;
	}

	public Integer getValue() {
		return value;
	}
}
