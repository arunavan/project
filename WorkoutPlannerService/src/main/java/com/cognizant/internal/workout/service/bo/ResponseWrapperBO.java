package com.cognizant.internal.workout.service.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapperBO<T extends BaseBO> {

    private T                 itsResponse;
    private String            itsStatus;
    private List<MessageBO> itsMessages;

    public T getResponse() {
        return itsResponse;
    }

    public void setResponse(final T inResponse) {
        itsResponse = inResponse;
    }

    public String getStatus() {
        return itsStatus;
    }

    public void setStatus(final String inStatus) {
        itsStatus = inStatus;
    }

    public List<MessageBO> getMessages() {
        return itsMessages;
    }

    public void setMessages(final List<MessageBO> inMessages) {
        itsMessages = inMessages;
    }

}
