package org.example.marketingnotiapiserver.table

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.jetbrains.exposed.sql.Column

object NotiToAdvertiserTable : BaseDateLongIdTable("noti_to_advertiser") {
    val message: Column<String> = varchar("message", 500)
    val advertiserId: Column<String> = varchar("advertiser_id", 255)
    val notiToAdvertiserType: Column<NotiToAdvertiserType> = enumerationByName("noti_to_advertiser_type", 50, NotiToAdvertiserType::class)
}
