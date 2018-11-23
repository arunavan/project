package com.cognizant.internal.workout.service.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorysBO extends BaseBO {
	private List<CategoryBO> itsCategoryBos;

	public List<CategoryBO> getCategoryBos() {
		return itsCategoryBos;
	}

	public void setCategoryBos(List<CategoryBO> inCategoryBos) {
		this.itsCategoryBos = inCategoryBos;
	}
	
}
