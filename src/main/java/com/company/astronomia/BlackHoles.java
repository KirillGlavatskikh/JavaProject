package com.company.astronomia;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class BlackHoles implements Serializable {

    @Serial
    private static final long serialVersionUID = 5527723242946021122L;

    private String name;
    private long distanceToEarth;
    private boolean isALive;

    public BlackHoles(String name, long distanceToEarth, boolean isALive) {
        this.name = name;
        this.distanceToEarth = distanceToEarth;
        this.isALive = isALive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDistanceToEarth() {
        return distanceToEarth;
    }

    public void setDistanceToEarth(long distanceToEarth) {
        this.distanceToEarth = distanceToEarth;
    }

    public boolean isALive() {
        return isALive;
    }

    public void setALive(boolean ALive) {
        isALive = ALive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackHoles that = (BlackHoles) o;
        return distanceToEarth == that.distanceToEarth && isALive == that.isALive && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distanceToEarth, isALive);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BlackHoles{");
        sb.append("name='").append(name).append('\'');
        sb.append(", distanceToEarth=").append(distanceToEarth);
        sb.append(", isALive=").append(isALive);
        sb.append('}');
        return sb.toString();
    }
}
