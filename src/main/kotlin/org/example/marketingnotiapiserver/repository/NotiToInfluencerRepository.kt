package org.example.marketingnotiapiserver.repository

import org.example.marketingnotiapiserver.dto.NotiToInfluencerEntity
import org.example.marketingnotiapiserver.dto.NotiToInfluencerMetadata
import org.example.marketingnotiapiserver.enums.NotiToInfluencerType
import org.example.marketingnotiapiserver.table.NotiToInfluencerTable
import org.springframework.stereotype.Repository

@Repository
class NotiToInfluencerRepository {

    fun save(
        message: String,
        influencerId: String,
        notiToInfluencerType: NotiToInfluencerType
    ): NotiToInfluencerMetadata {
        val entity = NotiToInfluencerEntity.new {
            this.message = message
            this.influencerId = influencerId
            this.notiToInfluencerType = notiToInfluencerType
        }
        return NotiToInfluencerMetadata.fromEntity(entity)
    }

    fun findByInfluencerId(influencerId: String): List<NotiToInfluencerMetadata> {
        return NotiToInfluencerEntity.find {
            NotiToInfluencerTable.influencerId eq influencerId
        }.map { NotiToInfluencerMetadata.fromEntity(it) }
    }
}
