package com.example.spring.concourse.demo;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void whenFindByName_thenReturnPerson() {

        // given
        Person person = new Person();
        person.setName("Jon");

        entityManager.persist(person);
        entityManager.flush();

        // when
        Person foundPerson = personRepository.findByName(person.getName());

        // then
        assertThat(foundPerson.getName())
            .isEqualTo(person.getName());
    }

}