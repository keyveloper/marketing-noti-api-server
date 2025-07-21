package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType

data class CreateNotiToAdvertiserApiRequest(
    val message: String,
    val advertiserId: String,
    val notiToAdvertiserType: NotiToAdvertiserType
)
