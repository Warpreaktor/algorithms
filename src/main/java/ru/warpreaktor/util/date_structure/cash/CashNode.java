package ru.warpreaktor.util.date_structure.cash;

import java.time.LocalDateTime;
import java.util.Objects;

public class CashNode implements Comparable<CashNode>{
    int value;
    LocalDateTime lastRequest;

    public CashNode(int value, LocalDateTime lastRequest) {
        this.value = value;
        this.lastRequest = lastRequest;
    }

    public LocalDateTime getLastRequest() {
        return lastRequest;
    }

    public void setLastRequest(LocalDateTime lastRequest) {
        this.lastRequest = lastRequest;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashNode cashNode = (CashNode) o;
        return getValue() == cashNode.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public int compareTo(CashNode o) {
        return o.getLastRequest().compareTo(this.getLastRequest());
    }
}
