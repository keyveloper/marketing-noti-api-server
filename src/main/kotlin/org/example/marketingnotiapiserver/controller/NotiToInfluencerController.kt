package org.example.marketingnotiapiserver.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketingnotiapiserver.dto.UploadNotiToInfluencerApiRequest
import org.example.marketingnotiapiserver.dto.UploadNotiToInfluencerResponseFromServer
import org.example.marketingnotiapiserver.dto.GetNotiToInfluencersByInfluencerIdResponseFromServer
import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.example.marketingnotiapiserver.service.NotiToInfluencerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/noti-to-influencer")
class NotiToInfluencerController(
    private val notiToInfluencerService: NotiToInfluencerService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping
    fun createNotiToInfluencer(
        @RequestBody request: UploadNotiToInfluencerApiRequest
    ): ResponseEntity<UploadNotiToInfluencerResponseFromServer> {
        logger.info { "POST /api/v1/noti-to-influencer - request: $request" }

        val result = notiToInfluencerService.createNotiToInfluencer(
            message = request.message,
            influencerId = request.influencerId,
            notiToInfluencerType = request.notiToInfluencerType
        )

        val response = UploadNotiToInfluencerResponseFromServer.of(
            httpStatus = HttpStatus.OK,
            msaServiceErrorCode = MSAServiceErrorCode.OK,
            errorMessage = null,
            logics = "createNotiToInfluencer",
            result = result
        )

        return ResponseEntity.ok(response)
    }

    @GetMapping("/influencer/{influencerId}")
    fun getNotiToInfluencersByInfluencerId(
        @PathVariable influencerId: UUID
    ): ResponseEntity<GetNotiToInfluencersByInfluencerIdResponseFromServer> {
        logger.info { "GET /api/v1/noti-to-influencer/influencer/$influencerId" }

        val result = notiToInfluencerService.getNotiToInfluencersByInfluencerId(influencerId)

        val response = GetNotiToInfluencersByInfluencerIdResponseFromServer.of(
            httpStatus = HttpStatus.OK,
            msaServiceErrorCode = MSAServiceErrorCode.OK,
            errorMessage = null,
            logics = "getNotiToInfluencersByInfluencerId",
            result = result
        )

        return ResponseEntity.ok(response)
    }
}
