package org.example.marketingnotiapiserver.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketingnotiapiserver.dto.CreateNotiToAdvertiserApiRequest
import org.example.marketingnotiapiserver.dto.CreateNotiToAdvertiserResponseFromServer
import org.example.marketingnotiapiserver.dto.GetNotiToAdvertisersByAdvertiserIdResponseFromServer
import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.example.marketingnotiapiserver.service.NotiToAdvertiserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/noti-to-advertiser")
class NotiToAdvertiserController(
    private val notiToAdvertiserService: NotiToAdvertiserService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping
    fun createNotiToAdvertiser(
        @RequestBody request: CreateNotiToAdvertiserApiRequest
    ): ResponseEntity<CreateNotiToAdvertiserResponseFromServer> {
        logger.info { "POST /api/v1/noti-to-advertiser - request: $request" }

        val result = notiToAdvertiserService.createNotiToAdvertiser(
            message = request.message,
            advertiserId = request.advertiserId,
            notiToAdvertiserType = request.notiToAdvertiserType
        )

        val response = CreateNotiToAdvertiserResponseFromServer.of(
            httpStatus = HttpStatus.OK,
            msaServiceErrorCode = MSAServiceErrorCode.OK,
            errorMessage = null,
            logics = "createNotiToAdvertiser",
            result = result
        )

        return ResponseEntity.ok(response)
    }

    @GetMapping("/advertiser/{advertiserId}")
    fun getNotiToAdvertisersByAdvertiserId(
        @PathVariable advertiserId: String
    ): ResponseEntity<GetNotiToAdvertisersByAdvertiserIdResponseFromServer> {
        logger.info { "GET /api/v1/noti-to-advertiser/advertiser/$advertiserId" }

        val result = notiToAdvertiserService.getNotiToAdvertisersByAdvertiserId(advertiserId)

        val response = GetNotiToAdvertisersByAdvertiserIdResponseFromServer.of(
            httpStatus = HttpStatus.OK,
            msaServiceErrorCode = MSAServiceErrorCode.OK,
            errorMessage = null,
            logics = "getNotiToAdvertisersByAdvertiserId",
            result = result
        )

        return ResponseEntity.ok(response)
    }
}
