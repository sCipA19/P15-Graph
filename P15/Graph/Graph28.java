package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph28 {
    private final int vertices;
    private final Map<Integer, ArrayList<Edge>> adjList;

    public Graph28(int vertices) {
        this.vertices = vertices;
        adjList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        adjList.get(asal).add(new Edge(tujuan, jarak));
    }

    public void removeEdge(int asal, int tujuan) {
        adjList.get(asal).removeIf(edge -> edge.tujuan == tujuan);
    }

    public void degree(int vertex) {
        int degree = adjList.get(vertex).size();
        System.out.println("Degree of vertex " + vertex + " is " + degree);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print(" -> " + edge.tujuan + " (jarak: " + edge.jarak + ")");
            }
            System.out.println();
        }
    }

    public boolean cekEdge(int asal, int tujuan) {
        for (Edge edge : adjList.get(asal)) {
            if (edge.tujuan == tujuan) {
                return true;
            }
        }
        return false;
    }

    public void updateJarak(int asal, int tujuan, int jarak) {
        for (Edge edge : adjList.get(asal)) {
            if (edge.tujuan == tujuan) {
                edge.jarak = jarak;
                return;
            }
        }
    }

    public int hitungEdge() {
        int totalEdges = 0;
        for (ArrayList<Edge> edges : adjList.values()) {
            totalEdges += edges.size();
        }
        return totalEdges;
    }

    private static class Edge {
        int tujuan;
        int jarak;

        Edge(int tujuan, int jarak) {
            this.tujuan = tujuan;
            this.jarak = jarak;
        }
    }
}
