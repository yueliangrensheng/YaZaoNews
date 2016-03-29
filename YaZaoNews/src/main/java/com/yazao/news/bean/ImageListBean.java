package com.yazao.news.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 17:15
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class ImageListBean implements Parcelable{
	private String id;
	private String desc;
	private List<String> tags;
	private String fromPageTitle;
	private String column;
	private String date;
	private String downloadUrl;
	private String imageUrl;
	private int imageWidth;
	private int imageHeight;
	private String thumbnailUrl;
	private int thumbnailWidth;
	private int thumbnailHeight;
	private String thumbnailLargeUrl;
	private int thumbnailLargeWidth;
	private int thumbnailLargeHeight;
	private String thumbnailLargeTnUrl;
	private int thumbnailLargeTnWidth;
	private int thumbnailLargeTnHeight;
	private String siteName;
	private String siteLogo;
	private String siteUrl;
	private String fromUrl;
	private String objUrl;
	private String shareUrl;
	private String albumId;
	private int isAlbum;
	private String albumName;
	private int albumNum;
	private String title;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getFromPageTitle() {
		return fromPageTitle;
	}

	public void setFromPageTitle(String fromPageTitle) {
		this.fromPageTitle = fromPageTitle;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public int getThumbnailWidth() {
		return thumbnailWidth;
	}

	public void setThumbnailWidth(int thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	public int getThumbnailHeight() {
		return thumbnailHeight;
	}

	public void setThumbnailHeight(int thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}

	public String getThumbnailLargeUrl() {
		return thumbnailLargeUrl;
	}

	public void setThumbnailLargeUrl(String thumbnailLargeUrl) {
		this.thumbnailLargeUrl = thumbnailLargeUrl;
	}

	public int getThumbnailLargeWidth() {
		return thumbnailLargeWidth;
	}

	public void setThumbnailLargeWidth(int thumbnailLargeWidth) {
		this.thumbnailLargeWidth = thumbnailLargeWidth;
	}

	public int getThumbnailLargeHeight() {
		return thumbnailLargeHeight;
	}

	public void setThumbnailLargeHeight(int thumbnailLargeHeight) {
		this.thumbnailLargeHeight = thumbnailLargeHeight;
	}

	public String getThumbnailLargeTnUrl() {
		return thumbnailLargeTnUrl;
	}

	public void setThumbnailLargeTnUrl(String thumbnailLargeTnUrl) {
		this.thumbnailLargeTnUrl = thumbnailLargeTnUrl;
	}

	public int getThumbnailLargeTnWidth() {
		return thumbnailLargeTnWidth;
	}

	public void setThumbnailLargeTnWidth(int thumbnailLargeTnWidth) {
		this.thumbnailLargeTnWidth = thumbnailLargeTnWidth;
	}

	public int getThumbnailLargeTnHeight() {
		return thumbnailLargeTnHeight;
	}

	public void setThumbnailLargeTnHeight(int thumbnailLargeTnHeight) {
		this.thumbnailLargeTnHeight = thumbnailLargeTnHeight;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteLogo() {
		return siteLogo;
	}

	public void setSiteLogo(String siteLogo) {
		this.siteLogo = siteLogo;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getFromUrl() {
		return fromUrl;
	}

	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}

	public String getObjUrl() {
		return objUrl;
	}

	public void setObjUrl(String objUrl) {
		this.objUrl = objUrl;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public int getIsAlbum() {
		return isAlbum;
	}

	public void setIsAlbum(int isAlbum) {
		this.isAlbum = isAlbum;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getAlbumNum() {
		return albumNum;
	}

	public void setAlbumNum(int albumNum) {
		this.albumNum = albumNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.desc);
		dest.writeStringList(this.tags);
		dest.writeString(this.fromPageTitle);
		dest.writeString(this.column);
		dest.writeString(this.date);
		dest.writeString(this.downloadUrl);
		dest.writeString(this.imageUrl);
		dest.writeInt(this.imageWidth);
		dest.writeInt(this.imageHeight);
		dest.writeString(this.thumbnailUrl);
		dest.writeInt(this.thumbnailWidth);
		dest.writeInt(this.thumbnailHeight);
		dest.writeString(this.thumbnailLargeUrl);
		dest.writeInt(this.thumbnailLargeWidth);
		dest.writeInt(this.thumbnailLargeHeight);
		dest.writeString(this.thumbnailLargeTnUrl);
		dest.writeInt(this.thumbnailLargeTnWidth);
		dest.writeInt(this.thumbnailLargeTnHeight);
		dest.writeString(this.siteName);
		dest.writeString(this.siteLogo);
		dest.writeString(this.siteUrl);
		dest.writeString(this.fromUrl);
		dest.writeString(this.objUrl);
		dest.writeString(this.shareUrl);
		dest.writeString(this.albumId);
		dest.writeInt(this.isAlbum);
		dest.writeString(this.albumName);
		dest.writeInt(this.albumNum);
		dest.writeString(this.title);
	}

	public ImageListBean() {
	}

	protected ImageListBean(Parcel in) {
		this.id = in.readString();
		this.desc = in.readString();
		this.tags = in.createStringArrayList();
		this.fromPageTitle = in.readString();
		this.column = in.readString();
		this.date = in.readString();
		this.downloadUrl = in.readString();
		this.imageUrl = in.readString();
		this.imageWidth = in.readInt();
		this.imageHeight = in.readInt();
		this.thumbnailUrl = in.readString();
		this.thumbnailWidth = in.readInt();
		this.thumbnailHeight = in.readInt();
		this.thumbnailLargeUrl = in.readString();
		this.thumbnailLargeWidth = in.readInt();
		this.thumbnailLargeHeight = in.readInt();
		this.thumbnailLargeTnUrl = in.readString();
		this.thumbnailLargeTnWidth = in.readInt();
		this.thumbnailLargeTnHeight = in.readInt();
		this.siteName = in.readString();
		this.siteLogo = in.readString();
		this.siteUrl = in.readString();
		this.fromUrl = in.readString();
		this.objUrl = in.readString();
		this.shareUrl = in.readString();
		this.albumId = in.readString();
		this.isAlbum = in.readInt();
		this.albumName = in.readString();
		this.albumNum = in.readInt();
		this.title = in.readString();
	}

	public static final Creator<ImageListBean> CREATOR = new Creator<ImageListBean>() {
		@Override
		public ImageListBean createFromParcel(Parcel source) {
			return new ImageListBean(source);
		}

		@Override
		public ImageListBean[] newArray(int size) {
			return new ImageListBean[size];
		}
	};
}
