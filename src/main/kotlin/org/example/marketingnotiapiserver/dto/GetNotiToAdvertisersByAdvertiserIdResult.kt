package org.example.marketingnotiapiserver.dto

data class GetNotiToAdvertisersByAdvertiserIdResult(
    val notifications: List<NotiToAdvertiserMetadata>
) {
    companion object {
        fun of(notifications: List<NotiToAdvertiserMetadata>): GetNotiToAdvertisersByAdvertiserIdResult {
            return GetNotiToAdvertisersByAdvertiserIdResult(
                notifications = notifications
            )
        }
    }
}
