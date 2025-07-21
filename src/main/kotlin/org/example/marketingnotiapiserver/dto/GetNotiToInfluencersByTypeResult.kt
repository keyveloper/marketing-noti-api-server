package org.example.marketingnotiapiserver.dto

data class GetNotiToInfluencersByTypeResult(
    val notifications: List<NotiToInfluencer>
) {
    companion object {
        fun of(notifications: List<NotiToInfluencer>): GetNotiToInfluencersByTypeResult {
            return GetNotiToInfluencersByTypeResult(
                notifications = notifications
            )
        }
    }
}
