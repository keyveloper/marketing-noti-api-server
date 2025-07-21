package org.example.marketingnotiapiserver.repository

import org.example.marketingnotiapiserver.dto.NotiToAdvertiserEntity
import org.example.marketingnotiapiserver.dto.NotiToAdvertiserMetadata
import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.example.marketingnotiapiserver.table.NotiToAdvertiserTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class NotiToAdvertiserRepository {

    fun save(
        message: String,
        advertiserId: String,
        notiToAdvertiserType: NotiToAdvertiserType
    ): NotiToAdvertiserMetadata {
        return transaction {
            val entity = NotiToAdvertiserEntity.new {
                this.message = message
                this.advertiserId = advertiserId
                this.notiToAdvertiserType = notiToAdvertiserType
            }
            NotiToAdvertiserMetadata.fromEntity(entity)
        }
    }

    fun findByType(notiToAdvertiserType: NotiToAdvertiserType): List<NotiToAdvertiserMetadata> {
        return transaction {
            NotiToAdvertiserEntity.find {
                NotiToAdvertiserTable.notiToAdvertiserType eq notiToAdvertiserType
            }.map { NotiToAdvertiserMetadata.fromEntity(it) }
        }
    }

    fun findByAdvertiserId(advertiserId: String): List<NotiToAdvertiserMetadata> {
        return transaction {
            NotiToAdvertiserEntity.find {
                NotiToAdvertiserTable.advertiserId eq advertiserId
            }.map { NotiToAdvertiserMetadata.fromEntity(it) }
        }
    }
}
