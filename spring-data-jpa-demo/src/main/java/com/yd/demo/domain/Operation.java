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

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * Created by ydechmi on 12/03/2016.
 */
@Entity
public class Operation extends AbstractEntity<Long> {


    private String date;

    private BigDecimal price;

    private String type;

    @OneToOne
    private Stock stock;

    protected Operation() {
    }

    public Operation(String date, BigDecimal price, String type) {
        this.date = date;
        this.price = price;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public String getType() {
        return type;
    }

    public Stock getStock() {
        return stock;
    }
}
