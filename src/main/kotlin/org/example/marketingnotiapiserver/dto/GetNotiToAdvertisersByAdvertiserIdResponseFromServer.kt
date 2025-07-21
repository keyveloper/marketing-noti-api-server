package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

data class GetNotiToAdvertisersByAdvertiserIdResponseFromServer(
    override val httpStatus: HttpStatus,
    override val msaServiceErrorCode: MSAServiceErrorCode,
    override val errorMessage: String?,
    override val logics: String?,
    val result: GetNotiToAdvertisersByAdvertiserIdResult?
): MSABusinessErrorResponse(httpStatus, msaServiceErrorCode, errorMessage, logics) {
    companion object {
        fun of(
            httpStatus: HttpStatus,
            msaServiceErrorCode: MSAServiceErrorCode,
            errorMessage: String?,
            logics: String?,
            result: GetNotiToAdvertisersByAdvertiserIdResult?
        ): GetNotiToAdvertisersByAdvertiserIdResponseFromServer {
            return GetNotiToAdvertisersByAdvertiserIdResponseFromServer(
                httpStatus = httpStatus,
                msaServiceErrorCode = msaServiceErrorCode,
                errorMessage = errorMessage,
                logics = logics,
                result = result
            )
        }
    }
}
