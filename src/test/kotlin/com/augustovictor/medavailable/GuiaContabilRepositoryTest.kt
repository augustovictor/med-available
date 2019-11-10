package com.augustovictor.medavailable

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import javax.persistence.EntityManager

@RunWith(SpringRunner::class)
@DataJpaTest
//@SpringBootTest
@TestPropertySource(properties = ["spring.jpa.hibernate.ddl-auto=create-drop"])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GuiaContabilRepositoryTest {
    @Autowired
    private lateinit var testEntityManager: TestEntityManager

//    @Autowired
//    private lateinit var testEntityManager: EntityManager

    @Autowired
    private lateinit var guiaContabilRepository: GuiaContabilRepository

    @Test
    fun `should save to database`() {
        val guiaImportacaoContrato = ImportacaoContrato()

        val expected = guiaContabilRepository.save(guiaImportacaoContrato)

        val actual = testEntityManager.find(GuiaContabil::class.java, expected.id)

        assertEquals(expected.id, actual.id)
    }
}