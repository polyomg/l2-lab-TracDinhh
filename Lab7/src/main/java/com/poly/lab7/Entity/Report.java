package com.poly.lab7.Entity;

import java.io.Serializable;

public interface Report extends Serializable {
    Serializable getGroup();
    Double getSum();
    Long getCount();
}
