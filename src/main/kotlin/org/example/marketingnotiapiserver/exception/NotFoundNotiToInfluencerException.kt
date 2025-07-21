package org.example.marketingnotiapiserver.exception

import org.example.marketingnotiapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

class NotFoundNotiToInfluencerException(
    notiId: Long,
    override val logics: String = "NotFoundNotiToInfluencerException"
): MSAServerException(
    httpStatus = HttpStatus.NOT_FOUND,
    msaServiceErrorCode = MSAServiceErrorCode.NOT_FOUND_NOTI_TO_INFLUENCER,
    logics = logics,
    message = "Notification to influencer with id $notiId not found"
)
