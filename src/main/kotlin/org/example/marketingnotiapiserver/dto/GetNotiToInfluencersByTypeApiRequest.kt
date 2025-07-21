package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToInfluencerType

data class GetNotiToInfluencersByTypeApiRequest(
    val notiToInfluencerType: NotiToInfluencerType
)
