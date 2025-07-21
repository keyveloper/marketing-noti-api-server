package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToInfluencerType

data class NotiToInfluencerMetadata(
    val id: Long,
    val message: String,
    val influencerId: String,
    val notiToInfluencerType: NotiToInfluencerType,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {
        fun of(
            id: Long,
            message: String,
            influencerId: String,
            notiToInfluencerType: NotiToInfluencerType,
            createdAt: Long,
            lastModifiedAt: Long
        ): NotiToInfluencerMetadata {
            return NotiToInfluencerMetadata(
                id = id,
                message = message,
                influencerId = influencerId,
                notiToInfluencerType = notiToInfluencerType,
                createdAt = createdAt,
                lastModifiedAt = lastModifiedAt
            )
        }

        fun fromEntity(entity: NotiToInfluencerEntity): NotiToInfluencerMetadata {
            return of(
                id = entity.id.value,
                message = entity.message,
                influencerId = entity.influencerId,
                notiToInfluencerType = entity.notiToInfluencerType,
                createdAt = entity.createdAt,
                lastModifiedAt = entity.lastModifiedAt
            )
        }
    }
}
