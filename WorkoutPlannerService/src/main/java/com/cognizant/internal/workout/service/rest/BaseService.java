package com.cognizant.internal.workout.service.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.MessageBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.constant.ApplicationConstants;


public abstract class BaseService {
    
	/*@Inject
    protected Environment itsProperties;*/
	@Autowired
    protected Environment itsProperties;
    
    
	/**
     * Get Failure Message
     *
     * @param inMessageKeys the key mapped to the for exception occurred
     * @return BusinessException it may throw exception if there is any kind of error occurs in operating the data
     */
    protected ResponseWrapperBO<BaseBO> getFailureMessage(final String... inMessageKeys) {
        final ResponseWrapperBO<BaseBO> theFailureResponse = new ResponseWrapperBO<BaseBO>();
        theFailureResponse.setStatus(ApplicationConstants.STATUS_FAILURE);
        theFailureResponse.setMessages(getMessageBOs(inMessageKeys));
        return theFailureResponse;
    }
    
    /**
     * Get Success Messages
     *
     * @param inMessageKeys the key mapped to the for exception occurred
     * @return BusinessException it may throw exception if there is any kind of error occurs in operating the data
     */
    protected ResponseWrapperBO<BaseBO> getSuccessMessage(final String inMessageKey) {
        final ResponseWrapperBO<BaseBO> theSuccessResponse = new ResponseWrapperBO<>();
        theSuccessResponse.setStatus(ApplicationConstants.STATUS_SUCCESS);
        final MessageBO theServiceMessageBO = new MessageBO();
        if (itsProperties != null) {
            theServiceMessageBO.setMessageID(itsProperties.getProperty(inMessageKey));
            theServiceMessageBO.setMessageType(itsProperties.getProperty(inMessageKey + ApplicationConstants.PROP_TYPE_SUFFIX));
            theServiceMessageBO.setMessageDetail(itsProperties.getProperty(inMessageKey + ApplicationConstants.PROP_DETAILS_SUFFIX));
        }
        theSuccessResponse.setMessages(Arrays.asList(theServiceMessageBO));
        return theSuccessResponse;
    }
    
    /**
     * Get Success Status
     * 
     * @return BusinessException it may throw exception if there is any kind of error occurs in operating the data
     */
    protected ResponseWrapperBO<BaseBO> getSuccessStatus() {
        final ResponseWrapperBO<BaseBO> theSuccessResponse = new ResponseWrapperBO<>();
        theSuccessResponse.setStatus(ApplicationConstants.STATUS_SUCCESS);
        return theSuccessResponse;
    }
    
    /**
     * Get Success Status
     * 
     * @param inBaseBO is set as the Response
     * @return BusinessException it may throw exception if there is any kind of error occurs in operating the data
     */
    protected ResponseWrapperBO<BaseBO> getSuccessStatus(final BaseBO inBaseBO) {
        final ResponseWrapperBO<BaseBO> theSuccessResponse = new ResponseWrapperBO<>();
        theSuccessResponse.setStatus(ApplicationConstants.STATUS_SUCCESS);
        theSuccessResponse.setResponse(inBaseBO);
        return theSuccessResponse;
    }
    
    /**
     * Get failure Status
     * 
     * @return  BusinessException it may throw exception if there is any kind of error occurs in operating the data
     */
    protected ResponseWrapperBO<BaseBO> getFailureStatus() {
        final ResponseWrapperBO<BaseBO> theResponse = new ResponseWrapperBO<>();
        theResponse.setStatus(ApplicationConstants.STATUS_FAILURE);
        return theResponse;
    }


    /**
     * Prepare Message List
     * 
     * @param inMessageKeys Message Keys
     * @return BusinessException it may throw exception if there is any kind of error occurs in operating the data
     */
    private List<MessageBO> getMessageBOs(final String... inMessageKeys) {
        final List<MessageBO> theMessageBOs = new ArrayList<>();
        MessageBO theServiceMessageBO;
        if ( (inMessageKeys != null) && (inMessageKeys.length > 0) && itsProperties != null) {
            for (final String theMessageKey : inMessageKeys) {
                theServiceMessageBO = new MessageBO();

                theServiceMessageBO.setMessageID(itsProperties.getProperty(theMessageKey));
                theServiceMessageBO.setMessageType(itsProperties.getProperty(theMessageKey + ApplicationConstants.PROP_TYPE_SUFFIX));
                theServiceMessageBO.setMessageDetail(getMessageFromResourceBundle(theMessageKey));
                theMessageBOs.add(theServiceMessageBO);

            }
        }
        return theMessageBOs;
    }

    /**
     * Prepares the Message from Resource Bundle
     * 
     * @param inMessage the key mapped to the for exception occurred
     * @param inMessageParm Message Param
     * @return BusinessException it may throw exception if there is any kind of error occurs in operating the data
     */
    private String getMessageFromResourceBundle(final String inMessage, final String... inMessageParm) {
        //final Locale theLocale = LocaleContextHolder.getLocale();
        return itsProperties.getProperty(inMessage + ApplicationConstants.PROP_DETAILS_SUFFIX);
    }
}