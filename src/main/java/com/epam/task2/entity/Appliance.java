package com.epam.task2.entity;

import com.epam.task2.entity.criteria.Criteria;
// TODO название Applianceable
public interface Appliance {
    boolean containsCriteria(Criteria criteria);
}
