package com.cognizant.internal.workout.service.util;

import org.apache.commons.lang3.StringUtils;

import com.cognizant.internal.workout.service.constant.ServiceConstant;

/**
 * Service Response Utility
 */
public final class ServiceResponseUtility {

    /**
     * Get Message Type
     *
     * @param inMessageId the message id
     * @return the message type
     */
    public static String getMessageType(final String inMessageId) {
        if (StringUtils.isBlank(inMessageId)) {
            return null;
        }
        final char theLastCharecter = inMessageId.charAt(inMessageId.length() - 1);
        switch (theLastCharecter) {
            case 'I':
                return ServiceConstant.TYPE_INFO;
            case 'W': 
                return ServiceConstant.TYPE_WARNING;
            case 'E':
                return ServiceConstant.TYPE_ERROR;
            default:
                return null;
        }
    }

    /**
     * To avoid instantiation
     */
    private ServiceResponseUtility() {
        // avoid instantiation
    }

}
