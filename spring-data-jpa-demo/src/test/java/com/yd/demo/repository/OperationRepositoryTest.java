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

package com.yd.demo.repository;

import com.yd.demo.AbstractTest;
import com.yd.demo.domain.Operation;
import com.yd.demo.domain.Stock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by ydechmi on 12/03/2016.
 */
public class OperationRepositoryTest extends AbstractTest {

    @Autowired
    OperationRepository repository;



    @Test
    public void testFindAll() throws Exception {
      Iterable<Operation> it=repository.findAll();
        assertThat(it,is(notNullValue()));
        Iterator<Operation> iterator=it.iterator();
        List<Operation> list=new ArrayList<Operation>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        assertThat(list.size(),is(1));
        
    }

    @Test
    public void testFindStock() throws Exception {
        Operation operation=repository.findOne(1l);
        assertThat(operation,is(notNullValue()));
        Stock stock=operation.getStock();
        assertThat(stock,is(notNullValue()));
        assertThat(stock.getSymbole(),is("FR0000131104BNP"));
        assertThat(stock.getCompany(),is("BNP PARISBAS"));
        assertThat(stock.getMarket(),is("CAC 40"));


    }
}