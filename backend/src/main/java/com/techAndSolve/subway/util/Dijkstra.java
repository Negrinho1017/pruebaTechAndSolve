package com.techAndSolve.subway.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.techAndSolve.subway.dominio.CaminoEntreEstaciones;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.dominio.Estacion;

public class Dijkstra {

    private final List<Estacion> nodes;
    private final List<CaminoEntreEstaciones> edges;
    private Set<Estacion> settledNodes;
    private Set<Estacion> unSettledNodes;
    private Map<Estacion, Estacion> predecessors;
    private Map<Estacion, Integer> distance;

    public Dijkstra(RutaGeneral graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<Estacion>(graph.getVertexes());
        this.edges = new ArrayList<CaminoEntreEstaciones>(graph.getEdges());
    }

    public void execute(Estacion source) {
        settledNodes = new HashSet<Estacion>();
        unSettledNodes = new HashSet<Estacion>();
        distance = new HashMap<Estacion, Integer>();
        predecessors = new HashMap<Estacion, Estacion>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Estacion node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    public void findMinimalDistances(Estacion node) {
        List<Estacion> adjacentNodes = getNeighbors(node);
        for (Estacion target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getTime(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getTime(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    public int getTime(Estacion node, Estacion target) {
        for (CaminoEntreEstaciones edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    public List<Estacion> getNeighbors(Estacion node) {
        List<Estacion> neighbors = new ArrayList<Estacion>();
        for (CaminoEntreEstaciones edge : edges) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    public Estacion getMinimum(Set<Estacion> vertexes) {
        Estacion minimum = null;
        for (Estacion vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    public boolean isSettled(Estacion vertex) {
        return settledNodes.contains(vertex);
    }

    public int getShortestDistance(Estacion destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Estacion> getPath(Estacion target) {
        LinkedList<Estacion> path = new LinkedList<Estacion>();
        Estacion step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}
