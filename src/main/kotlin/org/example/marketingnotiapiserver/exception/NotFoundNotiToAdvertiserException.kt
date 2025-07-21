package org.example.marketingnotiapiserver.exception

import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

class NotFoundNotiToAdvertiserException(
    notiId: Long,
    override val logics: String = "NotFoundNotiToAdvertiserException"
): MSAServerException(
    httpStatus = HttpStatus.NOT_FOUND,
    msaServiceErrorCode = MSAServiceErrorCode.NOT_FOUND_NOTI_TO_ADVERTISER,
    logics = logics,
    message = "Notification to advertiser with id $notiId not found"
)
