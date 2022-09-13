package com.company.astronomia;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AstronomicalObject implements Serializable {

    @Serial
    private static final long serialVersionUID = 6780178565575309561L;

    private String name;
    private String galaxy;
    private Long distanceToEarth;
    private Long dateOfDiscovery;
    private Date date;
    private String changeType;
    private Boolean flagForToString;

    public AstronomicalObject(String name, String galaxy, Long distanceToEarth, Long dateOfDiscovery) {
        flagForToString = true;
        this.name = name;
        this.galaxy = galaxy;
        this.distanceToEarth = distanceToEarth;
        this.dateOfDiscovery = dateOfDiscovery;
    }

    public AstronomicalObject(String name, Date date, String changeType, Long distanceToEarth) {
        flagForToString = false;
        this.name = name;
        this.date = date;
        this.changeType = changeType;
        this.distanceToEarth = distanceToEarth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
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

    public Long getDistanceToEarth() {
        return distanceToEarth;
    }

    public void setDistanceToEarth(long distanceToEarth) {
        this.distanceToEarth = distanceToEarth;
    }

    public Long getDateOfDiscovery() {
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
        return Objects.equals(name, that.name) && Objects.equals(galaxy, that.galaxy) && Objects.equals(distanceToEarth, that.distanceToEarth) && Objects.equals(dateOfDiscovery, that.dateOfDiscovery) && Objects.equals(date, that.date) && Objects.equals(changeType, that.changeType) && Objects.equals(flagForToString, that.flagForToString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, galaxy, distanceToEarth, dateOfDiscovery, date, changeType, flagForToString);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AstronomicalObject{");
        if (flagForToString) {
            sb.append("name='").append(name).append('\'');
            sb.append(", galaxy='").append(galaxy).append('\'');
            sb.append(", distanceToEarth=").append(distanceToEarth);
            sb.append(", dateOfDiscovery='").append(dateOfDiscovery).append('\'');
            sb.append('}');
        } else {
            sb.append("name='").append(name).append('\'');
            sb.append(", date='").append(date).append('\'');
            sb.append(", change type='").append(changeType).append('\'');
            sb.append(", distance to earth='").append(distanceToEarth).append('\'');
            sb.append('}');
        }
        return sb.toString();
    }
}
