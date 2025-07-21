package org.example.marketingnotiapiserver.dto

data class GetNotiToInfluencersByInfluencerIdResult(
    val notifications: List<NotiToInfluencerMetadata>
) {
    companion object {
        fun of(notifications: List<NotiToInfluencerMetadata>): GetNotiToInfluencersByInfluencerIdResult {
            return GetNotiToInfluencersByInfluencerIdResult(
                notifications = notifications
            )
        }
    }
}
