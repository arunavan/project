package com.cognizant.internal.workout.service.exception;

import java.util.List;

import com.cognizant.internal.workout.service.bo.MessageBO;

/**
 * Business Exception
 * @author 731283
 *
 */
public class BusinessException extends Exception{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1150903477351838546L;
	private String            itsMessageKey          = null;
    private transient List<String>      itsErrorDetails        = null;
    private transient List<MessageBO>   itsMessages            = null;
    private boolean           itsOnlyExternalMessage = false;

    public BusinessException(final String inMessageKey) {
        super(inMessageKey);
        this.itsMessageKey = inMessageKey;
    }

    public BusinessException(final String inMessageKey, final List<String> inErrorDetails) {
        super(inMessageKey);
        this.itsErrorDetails = inErrorDetails;
        this.itsMessageKey = inMessageKey;
    }

    public BusinessException(final String inMessageKey, final List<String> inErrorDetails, final List<MessageBO> inMessages, final boolean inOnlyExternalMessage) {
        super(inMessageKey);
        this.itsErrorDetails = inErrorDetails;
        this.itsMessageKey = inMessageKey;
        this.itsMessages = inMessages;
        this.itsOnlyExternalMessage = inOnlyExternalMessage;
    }

    public BusinessException(final String inMessage, final Exception inException) {
        super(inMessage, inException);
    }

    public BusinessException(final Exception inException) {
        super(inException);
    }

    public BusinessException(final Exception inException, final String inMessageKey) {
        super(inException);
        this.itsMessageKey = inMessageKey;
    }

    public BusinessException(final Throwable inCause) {
        super(null, inCause);
    }

    public String getMessageKey() {
        return itsMessageKey;
    }

    public void setMessageKey(final String inMessageKey) {
        itsMessageKey = inMessageKey;
    }

    public List<String> getErrorDetails() {
        return itsErrorDetails;
    }

    public void setErrorDetails(final List<String> inErrorDetails) {
        itsErrorDetails = inErrorDetails;
    }

    public List<MessageBO> getMessages() {
        return itsMessages;
    }

    public void setMessages(final List<MessageBO> inMessages) {
        itsMessages = inMessages;
    }

    public boolean isOnlyExternalMessage() {
        return itsOnlyExternalMessage;
    }

    public void setOnlyExternalMessage(final boolean inOnlyExternalMessage) {
        itsOnlyExternalMessage = inOnlyExternalMessage;
    }
}
