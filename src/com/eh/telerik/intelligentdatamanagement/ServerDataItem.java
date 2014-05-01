package com.eh.telerik.intelligentdatamanagement;

import java.util.ArrayList;
import java.util.UUID;

import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("DataItem")
public class ServerDataItem extends DataItem {

	@ServerProperty("Title")
	private String title;

	@ServerProperty("Description")
	private String description;
	
	@ServerProperty("Uri")
	private String uri;
	
	// Filled when not expanding
	@ServerProperty("Tags")
	private ArrayList<UUID> tags;
	
	// Filled when expanding
	@ServerProperty(value = "ItemTags", genericClassName = "com.eh.telerik.intelligentdatamanagement.DataTag")
	public ArrayList<DataTag> ItemTags;
	
	public ServerDataItem() {

	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;	
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public ArrayList<UUID> getTags() {
		return tags;
	}

	public void setTags(ArrayList<UUID> tags) {
		this.tags = tags;
	}

	public ArrayList<DataTag> getItemTags() {
		return ItemTags;
	}

	public void setItemTags(ArrayList<DataTag> itemTags) {
		this.ItemTags = itemTags;
	}
}
