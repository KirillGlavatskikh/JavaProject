package com.company.astronomia;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class AstronomicalObject implements Serializable {

    @Serial
    private static final long serialVersionUID = -456266595594197746L;

    private String name;
    private String galaxy;
    private long distanceToEarth;
    private long dateOfDiscovery;

    public AstronomicalObject(String name, String galaxy, long distanceToEarth, long dateOfDiscovery) {
        this.name = name;
        this.galaxy = galaxy;
        this.distanceToEarth = distanceToEarth;
        this.dateOfDiscovery = dateOfDiscovery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

    public long getDistanceToEarth() {
        return distanceToEarth;
    }

    public void setDistanceToEarth(long distanceToEarth) {
        this.distanceToEarth = distanceToEarth;
    }

    public long getDateOfDiscovery() {
        return dateOfDiscovery;
    }

    public void setDateOfDiscovery(long dateOfDiscovery) {
        this.dateOfDiscovery = dateOfDiscovery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AstronomicalObject that = (AstronomicalObject) o;
        return distanceToEarth == that.distanceToEarth && Objects.equals(name, that.name) && Objects.equals(galaxy, that.galaxy) && Objects.equals(dateOfDiscovery, that.dateOfDiscovery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, galaxy, distanceToEarth, dateOfDiscovery);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AstronomicalObject{");
        sb.append("name='").append(name).append('\'');
        sb.append(", galaxy='").append(galaxy).append('\'');
        sb.append(", distanceToEarth=").append(distanceToEarth);
        sb.append(", dateOfDiscovery='").append(dateOfDiscovery).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
