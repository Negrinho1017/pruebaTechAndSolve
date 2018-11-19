package com.techAndSolve.subway.dominio;

public class CaminoEntreEstaciones  {
    private final String id;
    private final Estacion source;
    private final Estacion destination;
    private final int weight;

    public CaminoEntreEstaciones(String id, Estacion source, Estacion destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }
    public Estacion getDestination() {
        return destination;
    }

    public Estacion getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }
}
