package edu.upc.etsetb.arqsoft.miniexceljc.model;

import java.util.*;

public class Spreadsheet {
    private Map<Coordinate, Cell> cells;
    private Map<Coordinate, Set<Coordinate>> subscriptions;

    public Spreadsheet() {
        this.cells = new HashMap<>();
    }

    public Map<Coordinate, Cell> getCells() {
        return cells;
    }

    public void setCell(Coordinate coordinate, Cell cell) {
        cells.put(coordinate, cell);
    }

    public void unSetCell(Coordinate coordinate) {
        cells.remove(coordinate);
        removeSubscriber(coordinate);
    }

    public Cell getCell(Coordinate coordinate) {
        return cells.get(coordinate);
    }

    public Set<Coordinate> getSubscribers(Coordinate subscription) {
        if (this.subscriptions.containsKey(subscription)) {
            return this.subscriptions.get(subscription);
        } else {
            return new HashSet<>();
        }
    }

    public void addSubscriber(Coordinate subscriber, Coordinate subscription) {
        if (this.subscriptions.containsKey(subscription)) {
            this.subscriptions.get(subscription).add(subscriber);
        } else {
            Set<Coordinate> subscriptions = new HashSet<>();
            subscriptions.add(subscriber);
            this.subscriptions.put(subscription, subscriptions);
        }
    }

    private void removeSubscriber(Coordinate subscriber) {
        for (Set<Coordinate> subscribers: this.subscriptions.values()) {
            subscribers.remove(subscriber);
        }
    }

    public Value getCellValue(Coordinate coordinate) {
        return null;
    }
}
