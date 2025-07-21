package org.example.marketingnotiapiserver.dto

import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

data class CreateNotiToAdvertiserResponseFromServer(
    override val httpStatus: HttpStatus,
    override val msaServiceErrorCode: MSAServiceErrorCode,
    override val errorMessage: String?,
    override val logics: String?,
    val result: CreateNotiToAdvertiserResult?
): MSABusinessErrorResponse(httpStatus, msaServiceErrorCode, errorMessage, logics) {
    companion object {
        fun of(
            httpStatus: HttpStatus,
            msaServiceErrorCode: MSAServiceErrorCode,
            errorMessage: String?,
            logics: String?,
            result: CreateNotiToAdvertiserResult?
        ): CreateNotiToAdvertiserResponseFromServer {
            return CreateNotiToAdvertiserResponseFromServer(
                httpStatus = httpStatus,
                msaServiceErrorCode = msaServiceErrorCode,
                errorMessage = errorMessage,
                logics = logics,
                result = result
            )
        }
    }
}
