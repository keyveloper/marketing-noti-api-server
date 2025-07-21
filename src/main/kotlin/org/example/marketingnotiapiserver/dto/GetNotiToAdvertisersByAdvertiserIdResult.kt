package org.example.marketingnotiapiserver.dto

data class GetNotiToAdvertisersByAdvertiserIdResult(
    val notifications: List<NotiToAdvertiser>
) {
    companion object {
        fun of(notifications: List<NotiToAdvertiser>): GetNotiToAdvertisersByAdvertiserIdResult {
            return GetNotiToAdvertisersByAdvertiserIdResult(
                notifications = notifications
            )
        }
    }
}
