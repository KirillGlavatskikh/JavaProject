package com.company.astronomia;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BlackHoles implements Serializable {

    @Serial
    private static final long serialVersionUID = -9033590604033361029L;

    private String name;
    private Long distanceToEarth;
    private Boolean isALive;
    private String changeType;
    private Date date;
    private Boolean flagForToString;

    public BlackHoles(String name, Long distanceToEarth, Boolean isALive) {
        flagForToString = true;
        this.name = name;
        this.distanceToEarth = distanceToEarth;
        this.isALive = isALive;
    }

    public BlackHoles(String name, Date date, String changeType, Long distanceToEarth, Boolean isALive) {
        flagForToString = false;
        this.name = name;
        this.date = date;
        this.changeType = changeType;
        this.distanceToEarth = distanceToEarth;
        this.isALive = isALive;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDistanceToEarth() {
        return distanceToEarth;
    }

    public void setDistanceToEarth(long distanceToEarth) {
        this.distanceToEarth = distanceToEarth;
    }

    public Boolean isALive() {
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
        return distanceToEarth == that.distanceToEarth && isALive == that.isALive && flagForToString == that.flagForToString && Objects.equals(name, that.name) && Objects.equals(changeType, that.changeType) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distanceToEarth, isALive, changeType, date, flagForToString);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BlackHoles{");
        if (flagForToString) {
            sb.append("name='").append(name).append('\'');
            sb.append(", distanceToEarth=").append(distanceToEarth);
            sb.append(", isALive=").append(isALive);
            sb.append('}');
        } else {
            sb.append("name='").append(name).append('\'');
            sb.append(", date='").append(date);
            sb.append(", change type='").append(changeType);
            sb.append(", distance to Earth='").append(distanceToEarth);
            sb.append(", is a live='").append(isALive);
            sb.append('}');
        }
        return sb.toString();
    }
}
