package org.example.marketingnotiapiserver.dto

data class UploadNotiToInfluencerResult(
    val notiToInfluencer: NotiToInfluencer
) {
    companion object {
        fun of(notiToInfluencer: NotiToInfluencer): UploadNotiToInfluencerResult {
            return UploadNotiToInfluencerResult(
                notiToInfluencer = notiToInfluencer
            )
        }
    }
}
