package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.table.BaseDateLongIdTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID

abstract class BaseDateEntity(id: EntityID<Long>, table: BaseDateLongIdTable): LongEntity(id) {
    val createdAt by table.createdAt
    var lastModifiedAt by table.lastModifiedAt
}