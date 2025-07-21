package org.example.marketingnotiapiserver.dto

data class GetNotiToInfluencersByInfluencerIdResult(
    val notifications: List<NotiToInfluencer>
) {
    companion object {
        fun of(notifications: List<NotiToInfluencer>): GetNotiToInfluencersByInfluencerIdResult {
            return GetNotiToInfluencersByInfluencerIdResult(
                notifications = notifications
            )
        }
    }
}
