package org.example.marketingnotiapiserver.dto

data class GetNotiToAdvertisersByTypeResult(
    val notifications: List<NotiToAdvertiserMetadata>
) {
    companion object {
        fun of(notifications: List<NotiToAdvertiserMetadata>): GetNotiToAdvertisersByTypeResult {
            return GetNotiToAdvertisersByTypeResult(
                notifications = notifications
            )
        }
    }
}
