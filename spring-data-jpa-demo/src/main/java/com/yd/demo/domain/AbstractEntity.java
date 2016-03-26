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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by ydechmi on 10/03/2016.
 */
@MappedSuperclass
public class AbstractEntity<ID extends Serializable> implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private ID id;

    protected ID getId() {
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity<?> that = (AbstractEntity<?>) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
