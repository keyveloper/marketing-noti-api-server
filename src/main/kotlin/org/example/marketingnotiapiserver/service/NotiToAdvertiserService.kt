package org.example.marketingnotiapiserver.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketingnotiapiserver.dto.CreateNotiToAdvertiserResult
import org.example.marketingnotiapiserver.dto.GetNotiToAdvertisersByAdvertiserIdResult
import org.example.marketingnotiapiserver.enums.NotiToAdvertiserType
import org.example.marketingnotiapiserver.repository.NotiToAdvertiserRepository
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class NotiToAdvertiserService(
    private val notiToAdvertiserRepository: NotiToAdvertiserRepository
) {
    private val logger = KotlinLogging.logger {}

    fun createNotiToAdvertiser(
        message: String,
        advertiserId: String,
        notiToAdvertiserType: NotiToAdvertiserType
    ): CreateNotiToAdvertiserResult {
        logger.info { "Creating notification to advertiser: advertiserId=$advertiserId, type=$notiToAdvertiserType" }

        val notiMetadata = transaction {
            notiToAdvertiserRepository.save(
                message = message,
                advertiserId = advertiserId,
                notiToAdvertiserType = notiToAdvertiserType
            )
        }

        return CreateNotiToAdvertiserResult.of(notiMetadata)
    }

    fun getNotiToAdvertisersByAdvertiserId(
        advertiserId: String
    ): GetNotiToAdvertisersByAdvertiserIdResult {
        logger.info { "Getting notifications to advertiser by advertiserId: advertiserId=$advertiserId" }

        val notifications = transaction {
            notiToAdvertiserRepository.findByAdvertiserId(advertiserId)
        }

        return GetNotiToAdvertisersByAdvertiserIdResult.of(notifications)
    }
}
