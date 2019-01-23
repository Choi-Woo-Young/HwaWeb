package org.springframework.samples.mvc.notices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notice {

    @Expose
    @SerializedName("noticeId")
    private int noticeId;

    @Expose
    @SerializedName("usrId")
    private int usrId;

    @Expose
    @SerializedName("noticeTitle")
    private String noticeTitle;

    @Expose
    @SerializedName("noticeCont")
    private String noticeCont;

    @Expose
    @SerializedName("pushTargetCd")
    private String pushTargetCd;

    @Expose
    @SerializedName("pushTargetCdNm")
    private String pushTargetCdNm;

    @Expose
    @SerializedName("newYN")
    private String newYN;

    @Expose
    @SerializedName("usrNm")
    private String usrNm;

    @Expose
    @SerializedName("deptNm")
    private String deptNm;

    @Expose
    @SerializedName("deptId")
    private String deptId;

    @Expose
    @SerializedName("position")
    private String position;

    @Expose
    @SerializedName("created")
    private String created;

    @Expose
    @SerializedName("modified")
    private String modified;

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public int getUsrId() {
		return usrId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeCont() {
		return noticeCont;
	}

	public void setNoticeCont(String noticeCont) {
		this.noticeCont = noticeCont;
	}

	public String getPushTargetCd() {
		return pushTargetCd;
	}

	public void setPushTargetCd(String pushTargetCd) {
		this.pushTargetCd = pushTargetCd;
	}

	public String getPushTargetCdNm() {
		return pushTargetCdNm;
	}

	public void setPushTargetCdNm(String pushTargetCdNm) {
		this.pushTargetCdNm = pushTargetCdNm;
	}

	public String getNewYN() {
		return newYN;
	}

	public void setNewYN(String newYN) {
		this.newYN = newYN;
	}

	public String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", usrId=" + usrId + ", noticeTitle=" + noticeTitle + ", noticeCont="
				+ noticeCont + ", pushTargetCd=" + pushTargetCd + ", pushTargetCdNm=" + pushTargetCdNm + ", newYN="
				+ newYN + ", usrNm=" + usrNm + ", deptNm=" + deptNm + ", deptId=" + deptId + ", position=" + position
				+ ", created=" + created + ", modified=" + modified + "]";
	}
    
    

}
