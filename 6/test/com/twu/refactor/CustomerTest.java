package com.twu.refactor;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static com.twu.refactor.MovieTypeEnum.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    private static final String GOLD_PATH = "test/data";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");

    private Movie python = new Movie("Monty Python and the Holy Grail", REGULAR);
    private Movie ran = new Movie("Ran", REGULAR);
    private Movie la = new Movie("LA Confidential", NEW_RELEASE);
    private Movie trek = new Movie("Star Trek 13.2", NEW_RELEASE);
    private Movie wallace = new Movie("Wallace and Gromit", CHILDRENS);

    @Before
    public void setUpData() {
        dinsdale.addRental(new Rental(python, 3));
        dinsdale.addRental(new Rental(ran, 1));
        dinsdale.addRental(new Rental(la, 2));
        dinsdale.addRental(new Rental(trek, 1));
        dinsdale.addRental(new Rental(wallace, 6));
    }

    @Test
    public void shouldOutputEmptyStatement() throws Exception {
        Customer customer = new Customer("Golden Shark");
        verifyOutput(customer.statement(), "outputEmpty");
    }

    @Test
    public void shouldOutputCustomerStatement() throws Exception {
        verifyOutput(dinsdale.statement(), "output1");
    }

    @Test
    public void shouldOutputChangedStatement() throws Exception {
        la.setTypeEnum(REGULAR);
        verifyOutput(dinsdale.statement(), "outputChange");
    }

    protected void verifyOutput(String actualValue, String fileName) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine;
        while ((thisFileLine = file.readLine()) != null) {
            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));
        }
    }

}
