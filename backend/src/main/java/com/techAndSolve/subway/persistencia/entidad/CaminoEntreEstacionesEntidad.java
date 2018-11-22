package com.techAndSolve.subway.persistencia.entidad;

public class CaminoEntreEstacionesEntidad {
	private String id;
    private EstacionEntidad source;
    private EstacionEntidad destination;
    private int weight;
    
	public CaminoEntreEstacionesEntidad(String id, EstacionEntidad source, EstacionEntidad destination, int weight) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EstacionEntidad getSource() {
		return source;
	}

	public void setSource(EstacionEntidad source) {
		this.source = source;
	}

	public EstacionEntidad getDestination() {
		return destination;
	}

	public void setDestination(EstacionEntidad destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
