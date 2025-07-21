package org.example.marketingnotiapiserver.dto

data class GetNotiToAdvertisersByTypeResult(
    val notifications: List<NotiToAdvertiser>
) {
    companion object {
        fun of(notifications: List<NotiToAdvertiser>): GetNotiToAdvertisersByTypeResult {
            return GetNotiToAdvertisersByTypeResult(
                notifications = notifications
            )
        }
    }
}
