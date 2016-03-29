package com.yazao.news.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 17:13
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class ImageListDataBean implements Parcelable {

	private String col;
	private String tag;
	private String tag3;
	private String sort;
	private int totalNum;
	private int startIndex;
	private int returnNumber;
	private List<ImageListBean> imgs;


	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getReturnNumber() {
		return returnNumber;
	}

	public void setReturnNumber(int returnNumber) {
		this.returnNumber = returnNumber;
	}

	public List<ImageListBean> getImgs() {
		return imgs;
	}

	public void setImgs(List<ImageListBean> imgs) {
		this.imgs = imgs;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.col);
		dest.writeString(this.tag);
		dest.writeString(this.tag3);
		dest.writeString(this.sort);
		dest.writeInt(this.totalNum);
		dest.writeInt(this.startIndex);
		dest.writeInt(this.returnNumber);
		dest.writeTypedList(imgs);
	}

	public ImageListDataBean() {
	}

	protected ImageListDataBean(Parcel in) {
		this.col = in.readString();
		this.tag = in.readString();
		this.tag3 = in.readString();
		this.sort = in.readString();
		this.totalNum = in.readInt();
		this.startIndex = in.readInt();
		this.returnNumber = in.readInt();
		this.imgs = in.createTypedArrayList(ImageListBean.CREATOR);
	}

	public static final Creator<ImageListDataBean> CREATOR = new Creator<ImageListDataBean>() {
		@Override
		public ImageListDataBean createFromParcel(Parcel source) {
			return new ImageListDataBean(source);
		}

		@Override
		public ImageListDataBean[] newArray(int size) {
			return new ImageListDataBean[size];
		}
	};
}
