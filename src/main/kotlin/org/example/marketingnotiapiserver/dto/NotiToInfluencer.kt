package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToInfluencerType
import java.util.*

data class NotiToInfluencer(
    val id: Long,
    val message: String,
    val influencerId: UUID,
    val notiToInfluencerType: NotiToInfluencerType,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {
        fun fromEntity(entity: NotiToInfluencerEntity): NotiToInfluencer {
            return NotiToInfluencer(
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
