package com.eh.telerik.intelligentdatamanagement;

import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("DataTag")
public class DataTag extends DataItem {
	
	@ServerProperty("DisplayName")
	private String displayName;
	
	@ServerProperty("DefinedColor")
	private String definedColor;
	
	@ServerProperty("Description")
	private String description;
	
	public DataTag() {
		
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDefinedColor() {
		return definedColor;
	}

	public void setDefinedColor(String definedColor) {
		this.definedColor = definedColor;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
