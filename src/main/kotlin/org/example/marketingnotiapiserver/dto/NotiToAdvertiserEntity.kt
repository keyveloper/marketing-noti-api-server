package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.example.marketingnotiapiserver.table.NotiToAdvertiserTable
import org.jetbrains.exposed.dao.id.EntityID

class NotiToAdvertiserEntity(id: EntityID<Long>): BaseDateEntity(id, NotiToAdvertiserTable) {
    companion object: BaseDateEntityAutoUpdate<NotiToAdvertiserEntity>(NotiToAdvertiserTable)

    var message: String by NotiToAdvertiserTable.message
    var advertiserId: String by NotiToAdvertiserTable.advertiserId
    var notiToAdvertiserType: NotiToAdvertiserType by NotiToAdvertiserTable.notiToAdvertiserType
}
