package org.example.marketingnotiapiserver.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketingnotiapiserver.dto.UploadNotiToInfluencerResult
import org.example.marketingnotiapiserver.dto.GetNotiToInfluencersByInfluencerIdResult
import org.example.marketingnotiapiserver.enums.NotiToInfluencerType
import org.example.marketingnotiapiserver.repository.NotiToInfluencerRepository
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.util.*

@Service
class NotiToInfluencerService(
    private val notiToInfluencerRepository: NotiToInfluencerRepository
) {
    private val logger = KotlinLogging.logger {}

    fun createNotiToInfluencer(
        message: String,
        influencerId: UUID,
        notiToInfluencerType: NotiToInfluencerType
    ): UploadNotiToInfluencerResult {
        logger.info { "Creating notification to influencer: influencerId=$influencerId, type=$notiToInfluencerType" }

        val notiMetadata = transaction {
            notiToInfluencerRepository.save(
                message = message,
                influencerId = influencerId,
                notiToInfluencerType = notiToInfluencerType
            )
        }

        return UploadNotiToInfluencerResult.of(notiMetadata)
    }

    fun getNotiToInfluencersByInfluencerId(
        influencerId: UUID
    ): GetNotiToInfluencersByInfluencerIdResult {
        logger.info { "Getting notifications to influencer by influencerId: influencerId=$influencerId" }

        val notifications = transaction {
            notiToInfluencerRepository.findByInfluencerId(influencerId)
        }

        return GetNotiToInfluencersByInfluencerIdResult.of(notifications)
    }
}
