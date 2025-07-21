package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToInfluencerType

data class CreateNotiToInfluencerApiRequest(
    val message: String,
    val influencerId: String,
    val notiToInfluencerType: NotiToInfluencerType
)
