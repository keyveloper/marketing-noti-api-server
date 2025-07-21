package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import java.util.*

data class NotiToAdvertiserMetadata(
    val id: Long,
    val message: String,
    val advertiserId: UUID,
    val notiToAdvertiserType: NotiToAdvertiserType,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {
        fun of(
            id: Long,
            message: String,
            advertiserId: UUID,
            notiToAdvertiserType: NotiToAdvertiserType,
            createdAt: Long,
            lastModifiedAt: Long
        ): NotiToAdvertiserMetadata {
            return NotiToAdvertiserMetadata(
                id = id,
                message = message,
                advertiserId = advertiserId,
                notiToAdvertiserType = notiToAdvertiserType,
                createdAt = createdAt,
                lastModifiedAt = lastModifiedAt
            )
        }

        fun fromEntity(entity: NotiToAdvertiserEntity): NotiToAdvertiserMetadata {
            return of(
                id = entity.id.value,
                message = entity.message,
                advertiserId = entity.advertiserId,
                notiToAdvertiserType = entity.notiToAdvertiserType,
                createdAt = entity.createdAt,
                lastModifiedAt = entity.lastModifiedAt
            )
        }
    }
}
