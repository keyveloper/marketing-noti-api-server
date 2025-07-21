package org.example.marketingnotiapiserver.repository

import org.example.marketingnotiapiserver.dto.NotiToAdvertiserEntity
import org.example.marketingnotiapiserver.dto.NotiToAdvertiser
import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.example.marketingnotiapiserver.table.NotiToAdvertiserTable
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class NotiToAdvertiserRepository {

    fun save(
        message: String,
        advertiserId: UUID,
        notiToAdvertiserType: NotiToAdvertiserType
    ): NotiToAdvertiser {
        val entity = NotiToAdvertiserEntity.new {
            this.message = message
            this.advertiserId = advertiserId
            this.notiToAdvertiserType = notiToAdvertiserType
        }
        return NotiToAdvertiser.fromEntity(entity)
    }

    fun findByAdvertiserId(advertiserId: UUID): List<NotiToAdvertiser> {
        return NotiToAdvertiserEntity.find {
            NotiToAdvertiserTable.advertiserId eq advertiserId
        }.map { NotiToAdvertiser.fromEntity(it) }
    }
}
