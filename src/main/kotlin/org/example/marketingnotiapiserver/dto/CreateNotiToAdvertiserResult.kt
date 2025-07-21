package org.example.marketingnotiapiserver.dto

data class CreateNotiToAdvertiserResult(
    val notiToAdvertiserMetadata: NotiToAdvertiserMetadata
) {
    companion object {
        fun of(notiToAdvertiserMetadata: NotiToAdvertiserMetadata): CreateNotiToAdvertiserResult {
            return CreateNotiToAdvertiserResult(
                notiToAdvertiserMetadata = notiToAdvertiserMetadata
            )
        }
    }
}
