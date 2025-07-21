package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import java.util.*

data class CreateNotiToAdvertiserApiRequest(
    val message: String,
    val advertiserId: UUID,
    val notiToAdvertiserType: NotiToAdvertiserType
)
