package org.example.marketingnotiapiserver.repository

import org.example.marketingnotiapiserver.dto.NotiToAdvertiserEntity
import org.example.marketingnotiapiserver.dto.NotiToAdvertiserMetadata
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
    ): NotiToAdvertiserMetadata {
        val entity = NotiToAdvertiserEntity.new {
            this.message = message
            this.advertiserId = advertiserId
            this.notiToAdvertiserType = notiToAdvertiserType
        }
        return NotiToAdvertiserMetadata.fromEntity(entity)
    }

    fun findByAdvertiserId(advertiserId: UUID): List<NotiToAdvertiserMetadata> {
        return NotiToAdvertiserEntity.find {
            NotiToAdvertiserTable.advertiserId eq advertiserId
        }.map { NotiToAdvertiserMetadata.fromEntity(it) }
    }
}
