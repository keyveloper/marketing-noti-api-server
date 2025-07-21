package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.example.marketingnotiapiserver.table.NotiToAdvertiserTable.notiToAdvertiserType
import java.util.*

data class NotiToAdvertiser(
    val id: Long,
    val message: String,
    val advertiserId: UUID,
    val notiToAdvertiserType: NotiToAdvertiserType,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {
        fun fromEntity(entity: NotiToAdvertiserEntity): NotiToAdvertiser {
            return NotiToAdvertiser(
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
