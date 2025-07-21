package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.NotiToInfluencerType
import java.util.UUID

data class UploadNotiToInfluencerApiRequest(
    val message: String,
    val influencerId: UUID,
    val notiToInfluencerType: NotiToInfluencerType
)
