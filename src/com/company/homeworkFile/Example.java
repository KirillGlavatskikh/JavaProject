package com.company.homeworkFile;

import java.io.Serial;
import java.io.Serializable;

public class Example implements Serializable {

    @Serial
    private static final long serialVersionUID = -7565967629399584096L;

    private int id;
    private String name;

    public Example(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Example{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
