package org.springframework.samples.mvc.notices;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NoticeResponse {

    @Expose
    @SerializedName("Notices")
    private List<Notice> notices;

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
    
    
}
