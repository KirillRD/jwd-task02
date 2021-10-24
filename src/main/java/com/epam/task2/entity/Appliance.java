package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;

import java.util.HashSet;

public interface Appliance {
    boolean containsCriteria(Criteria criteria);
}
