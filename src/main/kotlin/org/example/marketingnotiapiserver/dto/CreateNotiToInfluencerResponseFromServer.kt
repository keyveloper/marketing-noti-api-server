package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

data class CreateNotiToInfluencerResponseFromServer(
    override val httpStatus: HttpStatus,
    override val msaServiceErrorCode: MSAServiceErrorCode,
    override val errorMessage: String?,
    override val logics: String?,
    val result: CreateNotiToInfluencerResult?
): MSABusinessErrorResponse(httpStatus, msaServiceErrorCode, errorMessage, logics) {
    companion object {
        fun of(
            httpStatus: HttpStatus,
            msaServiceErrorCode: MSAServiceErrorCode,
            errorMessage: String?,
            logics: String?,
            result: CreateNotiToInfluencerResult?
        ): CreateNotiToInfluencerResponseFromServer {
            return CreateNotiToInfluencerResponseFromServer(
                httpStatus = httpStatus,
                msaServiceErrorCode = msaServiceErrorCode,
                errorMessage = errorMessage,
                logics = logics,
                result = result
            )
        }
    }
}
