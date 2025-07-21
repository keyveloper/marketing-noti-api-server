package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType

data class GetNotiToAdvertisersByTypeApiRequest(
    val notiToAdvertiserType: NotiToAdvertiserType
)
