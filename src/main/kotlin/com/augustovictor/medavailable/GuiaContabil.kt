package com.augustovictor.medavailable

import javax.persistence.*

@Entity
@Table(name = "guia_contabil")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_guia")
abstract class GuiaContabil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}

@Entity
@DiscriminatorValue("importacao_contrato")
class ImportacaoContrato : GuiaContabil()