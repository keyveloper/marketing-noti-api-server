package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToInfluencerType
import org.example.marketingnotiapiserver.table.NotiToInfluencerTable
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class NotiToInfluencerEntity(id: EntityID<Long>): BaseDateEntity(id, NotiToInfluencerTable) {
    companion object: BaseDateEntityAutoUpdate<NotiToInfluencerEntity>(NotiToInfluencerTable)

    var message: String by NotiToInfluencerTable.message
    var influencerId: UUID by NotiToInfluencerTable.influencerId
    var notiToInfluencerType: NotiToInfluencerType by NotiToInfluencerTable.notiToInfluencerType
}
