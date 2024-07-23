package com.galapea.techblog.fitnesstracking.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SnippetView {

	String id;

	String title;

	Date createdAt;

	String timeAgo;

	String contentSizeHumanReadable;

}
