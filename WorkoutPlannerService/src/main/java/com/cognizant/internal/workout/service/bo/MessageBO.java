package com.cognizant.internal.workout.service.bo;


public class MessageBO {

    private String              itsMessageID;
    private String              itsMessageType;
    private String              itsMessageDetail;

//    private static final Logger Logger = LoggerFactory.getLogger(RestClient.class);

    public MessageBO() {
//        Logger.info("In MessageBean");
    }

    public MessageBO(final String inMessageID, final String inMessageType, final String inMessageDetail) {
        itsMessageID = inMessageID;
        itsMessageType = inMessageType;
        itsMessageDetail = inMessageDetail;
    }

    public String getMessageID() {
        return itsMessageID;
    }

    public void setMessageID(final String inMessageID) {
        itsMessageID = inMessageID;
    }

    public String getMessageType() {
        return itsMessageType;
    }

    public void setMessageType(final String inMessageType) {
        itsMessageType = inMessageType;
    }

    public String getMessageDetail() {
        return itsMessageDetail;
    }

    public void setMessageDetail(final String inMessageDetail) {
        itsMessageDetail = inMessageDetail;
    }

}
