package org.example.marketingnotiapiserver.table

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.jetbrains.exposed.sql.Column
import java.util.*

object NotiToAdvertiserTable : BaseDateLongIdTable("noti_to_advertiser") {
    val message: Column<String> = varchar("message", 500)
    val advertiserId: Column<UUID> = uuid("advertiser_id").index()
    val notiToAdvertiserType: Column<NotiToAdvertiserType> =
        enumerationByName("noti_to_advertiser_type", 50, NotiToAdvertiserType::class)
}
