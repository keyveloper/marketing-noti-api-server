package org.example.marketingnotiapiserver.repository

import org.example.marketingnotiapiserver.dto.NotiToInfluencerEntity
import org.example.marketingnotiapiserver.dto.NotiToInfluencerMetadata
import org.example.marketingnotiapiserver.enums.NotiToInfluencerType
import org.example.marketingnotiapiserver.table.NotiToInfluencerTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class NotiToInfluencerRepository {

    fun save(
        message: String,
        influencerId: String,
        notiToInfluencerType: NotiToInfluencerType
    ): NotiToInfluencerMetadata {
        return transaction {
            val entity = NotiToInfluencerEntity.new {
                this.message = message
                this.influencerId = influencerId
                this.notiToInfluencerType = notiToInfluencerType
            }
            NotiToInfluencerMetadata.fromEntity(entity)
        }
    }

    fun findByType(notiToInfluencerType: NotiToInfluencerType): List<NotiToInfluencerMetadata> {
        return transaction {
            NotiToInfluencerEntity.find {
                NotiToInfluencerTable.notiToInfluencerType eq notiToInfluencerType
            }.map { NotiToInfluencerMetadata.fromEntity(it) }
        }
    }

    fun findByInfluencerId(influencerId: String): List<NotiToInfluencerMetadata> {
        return transaction {
            NotiToInfluencerEntity.find {
                NotiToInfluencerTable.influencerId eq influencerId
            }.map { NotiToInfluencerMetadata.fromEntity(it) }
        }
    }
}
