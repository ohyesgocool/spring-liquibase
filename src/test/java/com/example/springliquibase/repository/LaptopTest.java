package com.example.springliquibase.repository;

import com.example.springliquibase.model.Laptop;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@DirtiesContext
@Slf4j
public class LaptopTest
{
    @Autowired
    LaptopRepository laptopRepository;

    @Test
    public void laptopTest()
    {
        // GIVEN
        Laptop laptop = new Laptop();
        laptop.setColour("Grey");
        laptop.setStorage("500 GB");
        laptop.setModelName("Mac book pro");
        laptop.setManufacturer("Apple");
        log.info("Saving new laptop item to Laptop Repository"+laptop);

        this.laptopRepository.save(laptop);

        // WHEN
        laptop = this.laptopRepository.findAll().get(0);
        log.info("querying laptop Database"+laptop);

        // THEN
        assertThat(laptop, notNullValue());
    }
}
