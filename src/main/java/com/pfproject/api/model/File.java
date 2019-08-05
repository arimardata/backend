package com.pfproject.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fs.files")
public class File extends BaseEntity {

	private static final long serialVersionUID = 7954325925563724764L;
	private ObjectId id;
	private String chunckSize;
	private String filename;
	private String length;
	private String uploadDate;

	public String getId() {
		return this.id.toString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getChunckSize() {
		return this.chunckSize;
	}

	public void setChunckSize(String chunckSize) {
		this.chunckSize = chunckSize;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

}
