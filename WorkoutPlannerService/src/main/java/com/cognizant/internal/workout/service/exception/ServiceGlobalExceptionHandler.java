package com.cognizant.internal.workout.service.exception;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.MessageBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.config.ServicePropertyConfig;
import com.cognizant.internal.workout.service.constant.ServiceConstant;
import com.cognizant.internal.workout.service.util.ServiceResponseUtility;

/**
 * Global Exception Handler
 * It takes care of all exceptions of the applications.
 */
@ControllerAdvice
public class ServiceGlobalExceptionHandler {

    private static final Logger   LOGGER = LoggerFactory.getLogger(ServiceGlobalExceptionHandler.class);

    /*private ServicePropertyConfig itsPropertyConfiguration;
    @Inject
    public ServiceGlobalExceptionHandler(ServicePropertyConfig inPropertyConfiguration){
    	itsPropertyConfiguration= inPropertyConfiguration;
    }*/

    @Autowired
    ServicePropertyConfig itsPropertyConfiguration;
    /**
     * It does BusinessException exception handling
     *
     * @param inRequest the http servlet request
     * @param inException the actual exception occurred
     * @return ResponseWrapperBO the error message build based on exception
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapperBO<BaseBO> handleBusinessException(final HttpServletRequest inRequest, final BusinessException inException) {
        LOGGER.error("Below business exception occured while processing request: " + inRequest.getRequestURL());
        LOGGER.error("Business Exception : ", inException);
        if (StringUtils.isNotEmpty(inException.getMessage())) {
            return getErrorResponse(inException.getMessage());
        }
        return getErrorResponse(ServiceConstant.PROP_ERROR_GLOBAL_EXCEPTION);
    }

    /**
     * It does common exception handling
     *
     * @param inRequest the http servlet request
     * @param inException the actual exception occurred
     * @return ResponseWrapperBO the error message build based on exception
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapperBO<BaseBO> handleException(final HttpServletRequest inRequest, final Exception inException) {
        LOGGER.error("Below exception occured while processing request: " + inRequest.getRequestURL());
        LOGGER.error("Exception : ", inException);
        return getErrorResponse(ServiceConstant.PROP_ERROR_GLOBAL_EXCEPTION);
    }

    /**
     * Prepare Error Response
     *
     * @param inMessageKey the keys of the message property
     * @param inValues the values that need to be replace in message
     * @return ResponseWrapperBO the error message build based on exception
     */
    /*private ResponseWrapperBO<BaseBO> getErrorBusinessResponse(final String inMessageKey, final String[] inValues) {
        final ResponseWrapperBO<BaseBO> theResponse = new ResponseWrapperBO<>();
        theResponse.setStatus(ServiceConstant.STATUS_FAILURE);
        final MessageBO theMessageBO = new MessageBO();
        final String theMessageId = itsPropertyConfiguration.getProperty(inMessageKey);
        theMessageBO.setMessageID(theMessageId);
        theMessageBO.setMessageType(ServiceResponseUtility.getMessageType(theMessageId));
        if (inValues != null) {
            theMessageBO.setMessageDetail(itsPropertyConfiguration.getCompoundProperty(inMessageKey + ServiceConstant.PROP_DETAILS_SUFFIX, inValues));
        }else {
            theMessageBO.setMessageDetail(itsPropertyConfiguration.getProperty(inMessageKey + ServiceConstant.PROP_DETAILS_SUFFIX));
        }
        theResponse.setMessages(Arrays.asList(theMessageBO));
        return theResponse;
    }*/

    /**
     * Prepare Error Response
     *
     * @param inMessageKeys the keys of the message property
     * @return ResponseWrapperBO the error message build based on exception
     */
    private ResponseWrapperBO<BaseBO> getErrorResponse(final String inMessageKey) {
        final ResponseWrapperBO<BaseBO> theResponse = new ResponseWrapperBO<>();
        theResponse.setStatus(ServiceConstant.STATUS_FAILURE);
        final MessageBO theMessageBO = new MessageBO();
        final String theMessageId = itsPropertyConfiguration.getProperty(inMessageKey);
        theMessageBO.setMessageID(theMessageId);
        theMessageBO.setMessageType(ServiceResponseUtility.getMessageType(theMessageId));
        theMessageBO.setMessageDetail(itsPropertyConfiguration.getProperty(inMessageKey + ServiceConstant.PROP_DETAILS_SUFFIX));
        theResponse.setMessages(Arrays.asList(theMessageBO));
        return theResponse;
    }

}
