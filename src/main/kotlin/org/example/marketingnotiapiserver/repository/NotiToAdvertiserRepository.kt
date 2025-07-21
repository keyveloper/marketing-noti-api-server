package org.example.marketingnotiapiserver.repository

import org.example.marketingnotiapiserver.dto.NotiToAdvertiserEntity
import org.example.marketingnotiapiserver.dto.NotiToAdvertiserMetadata
import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.example.marketingnotiapiserver.table.NotiToAdvertiserTable
import org.springframework.stereotype.Repository

@Repository
class NotiToAdvertiserRepository {

    fun save(
        message: String,
        advertiserId: String,
        notiToAdvertiserType: NotiToAdvertiserType
    ): NotiToAdvertiserMetadata {
        val entity = NotiToAdvertiserEntity.new {
            this.message = message
            this.advertiserId = advertiserId
            this.notiToAdvertiserType = notiToAdvertiserType
        }
        return NotiToAdvertiserMetadata.fromEntity(entity)
    }

    fun findByAdvertiserId(advertiserId: String): List<NotiToAdvertiserMetadata> {
        return NotiToAdvertiserEntity.find {
            NotiToAdvertiserTable.advertiserId eq advertiserId
        }.map { NotiToAdvertiserMetadata.fromEntity(it) }
    }
}
