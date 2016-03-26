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
import com.yd.demo.repository.StockRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by ydechmi on 11/03/2016.
 */
public class StockRepositoryTest extends AbstractTest {

    @Autowired
    private StockRepository repository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFindBySymbole() throws Exception {

        List<Stock> list=repository.findBySymbole("FR0000120685KN");
        Assert.assertEquals("Natixis",list.get(0).getCompany());

    }

    @Test
    public void testCreateStock() throws Exception {
        Stock stockprice=new Stock("CABFR00000","CAB","CAC40");
        Stock result=repository.save(stockprice);
        Assert.assertThat(result, is(notNullValue()));
        assertThat(result.getCompany(), is("CAB"));
        assertThat(result.getSymbole(), is("CABFR00000"));
    }

    @Test
    public void testFindAll() throws Exception {
        Iterable<Stock> list=repository.findAll();
        assertThat(list,is(notNullValue()));
        Iterator<Stock> it=list.iterator();
        List<Stock> stocks=new ArrayList<Stock>();

        while (it.hasNext()){
            Stock objet=it.next();
            stocks.add(objet);
        }
        assertThat(stocks.size(),is(4));

    }

    @Test
    public void testSaveOperation() throws Exception {
        Stock stock=repository.findBySymbole("FR0000120685KN").get(0);
        Operation operation=new Operation("12/03/2016",new BigDecimal(4.5),"Buy");
        stock.add(operation);
        Stock result=repository.save(stock);

        assertThat(result.getOperations().size(),is(1));

    }

    @Test
    public void testCheckOperation() throws Exception {
        Stock stock=repository.findBySymbole("FR0000131104BNP").get(0);


        assertThat(stock.getOperations().size(),is(1));
        Operation operation=stock.getOperations().iterator().next();
        assertThat(operation,is(notNullValue()));


    }

}