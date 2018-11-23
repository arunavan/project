package com.cognizant.internal.workout.service.bo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseBO {	
	
    private int itsRunId;
   
	public int getRunId() {
        return itsRunId;
    }

    public void setRunId(final int inRunId) {
        itsRunId = inRunId;
    }

}
