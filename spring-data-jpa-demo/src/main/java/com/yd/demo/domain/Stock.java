/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yd.demo.domain;

import com.yd.demo.domain.AbstractEntity;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ydechmi on 10/03/2016.
 */
@Entity
public class Stock extends AbstractEntity<Long> {


    private String symbole;

    private String company;

    private String market;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "stock_id")
    private Set<Operation> operations=new HashSet<Operation>();

    protected Stock() {
    }

    public Stock(String symbole, String company, String market) {
        this.symbole = symbole;
        this.company = company;
        this.market = market;
    }

    public String getSymbole() {
        return symbole;
    }


    public String getCompany() {
        return company;
    }

    public String getMarket() {
        return market;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void add(Operation operation){
        Assert.notNull(operation);
        this.operations.add(operation);
    }
}
