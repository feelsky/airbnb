package com.me.app.airbnb.model;

import java.util.Date;

public class Room {

	private Long id;
	private Long roomId;
	private String roomName;
	private Integer comments;
	private Integer pv;
	private String roomType;
	private Float latitude;
	private Float longitude;
	private Integer bookNow;
	private Integer accommodates;
	private Integer bedroom;
	private Integer bathroom;
	private Integer smoke;
	private Integer parking;
	private Integer lift;
	private Integer isNew;
	private Integer nights;
	private String unsubscribe;
	private Integer emptyRoomPrice;
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getComments() {
		return comments;
	}
	public void setComments(Integer comments) {
		this.comments = comments;
	}
	public Integer getPv() {
		return pv;
	}
	public void setPv(Integer pv) {
		this.pv = pv;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Integer getBookNow() {
		return bookNow;
	}
	public void setBookNow(Integer bookNow) {
		this.bookNow = bookNow;
	}
	public Integer getAccommodates() {
		return accommodates;
	}
	public void setAccommodates(Integer accommodates) {
		this.accommodates = accommodates;
	}
	public Integer getBedroom() {
		return bedroom;
	}
	public void setBedroom(Integer bedroom) {
		this.bedroom = bedroom;
	}
	public Integer getBathroom() {
		return bathroom;
	}
	public void setBathroom(Integer bathroom) {
		this.bathroom = bathroom;
	}
	public Integer getSmoke() {
		return smoke;
	}
	public void setSmoke(Integer smoke) {
		this.smoke = smoke;
	}
	public Integer getParking() {
		return parking;
	}
	public void setParking(Integer parking) {
		this.parking = parking;
	}
	public Integer getLift() {
		return lift;
	}
	public void setLift(Integer lift) {
		this.lift = lift;
	}
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public Integer getNights() {
		return nights;
	}
	public void setNights(Integer nights) {
		this.nights = nights;
	}
	public String getUnsubscribe() {
		return unsubscribe;
	}
	public void setUnsubscribe(String unsubscribe) {
		this.unsubscribe = unsubscribe;
	}
	public Integer getEmptyRoomPrice() {
		return emptyRoomPrice;
	}
	public void setEmptyRoomPrice(Integer emptyRoomPrice) {
		this.emptyRoomPrice = emptyRoomPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
