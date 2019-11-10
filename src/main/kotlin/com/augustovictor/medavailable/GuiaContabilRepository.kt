package com.augustovictor.medavailable

import org.springframework.data.repository.Repository

interface GuiaContabilRepository : Repository<GuiaContabil, Long> {
    fun save(guiaContabil: GuiaContabil): GuiaContabil
}