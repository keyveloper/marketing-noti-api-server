package org.example.marketingnotiapiserver.table

import org.example.marketingnotiapiserver.enums.NotiToInfluencerType
import org.jetbrains.exposed.sql.Column
import java.util.*

object NotiToInfluencerTable : BaseDateLongIdTable("noti_to_influencer") {
    val message: Column<String> = text("message")
    val influencerId: Column<UUID> = uuid("influencer_id").index()
    val notiToInfluencerType: Column<NotiToInfluencerType> =
        enumerationByName("noti_to_influencer_type", 50, NotiToInfluencerType::class)
}
