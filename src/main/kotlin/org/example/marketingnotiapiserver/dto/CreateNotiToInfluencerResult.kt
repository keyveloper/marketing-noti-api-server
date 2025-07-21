package org.example.marketingnotiapiserver.dto

data class CreateNotiToInfluencerResult(
    val notiToInfluencerMetadata: NotiToInfluencerMetadata
) {
    companion object {
        fun of(notiToInfluencerMetadata: NotiToInfluencerMetadata): CreateNotiToInfluencerResult {
            return CreateNotiToInfluencerResult(
                notiToInfluencerMetadata = notiToInfluencerMetadata
            )
        }
    }
}
