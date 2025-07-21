package org.example.marketingnotiapiserver.dto

data class UploadNotiToAdvertiserResult(
    val notiToAdvertiser: NotiToAdvertiser
) {
    companion object {
        fun of(notiToAdvertiser: NotiToAdvertiser): UploadNotiToAdvertiserResult {
            return UploadNotiToAdvertiserResult(
                notiToAdvertiser = notiToAdvertiser
            )
        }
    }
}
