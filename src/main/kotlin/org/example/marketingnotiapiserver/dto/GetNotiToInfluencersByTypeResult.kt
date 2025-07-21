package org.example.marketingnotiapiserver.dto

data class GetNotiToInfluencersByTypeResult(
    val notifications: List<NotiToInfluencerMetadata>
) {
    companion object {
        fun of(notifications: List<NotiToInfluencerMetadata>): GetNotiToInfluencersByTypeResult {
            return GetNotiToInfluencersByTypeResult(
                notifications = notifications
            )
        }
    }
}
