package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

data class GetNotiToInfluencersByTypeResponseFromServer(
    override val httpStatus: HttpStatus,
    override val msaServiceErrorCode: MSAServiceErrorCode,
    override val errorMessage: String?,
    override val logics: String?,
    val result: GetNotiToInfluencersByTypeResult?
): MSABusinessErrorResponse(httpStatus, msaServiceErrorCode, errorMessage, logics) {
    companion object {
        fun of(
            httpStatus: HttpStatus,
            msaServiceErrorCode: MSAServiceErrorCode,
            errorMessage: String?,
            logics: String?,
            result: GetNotiToInfluencersByTypeResult?
        ): GetNotiToInfluencersByTypeResponseFromServer {
            return GetNotiToInfluencersByTypeResponseFromServer(
                httpStatus = httpStatus,
                msaServiceErrorCode = msaServiceErrorCode,
                errorMessage = errorMessage,
                logics = logics,
                result = result
            )
        }
    }
}
