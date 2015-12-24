package com.yazao.news.lib.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public class YZChangeColorTextView extends TextView {
	/**
	 * 控件的宽
	 */
	private int width = 0;
	/**
	 * 控件的高
	 */
	private int height = 0;

	/**
	 * 文字的颜色
	 */
	private int mTextColor = 0xFF45C01A;
	/**
	 * 文字的大小
	 */
	private int mTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12.0f, getResources().getDisplayMetrics());

	private Paint mTextPaint;
	private Rect mTextBounds;
	private float mAlpha = 0f;
	private String mText = "YaZao";


	public YZChangeColorTextView(Context context) {
		this(context, null);
	}

	public YZChangeColorTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public YZChangeColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public YZChangeColorTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	private void init() {
		mTextBounds = new Rect();
		mTextPaint = new Paint();
		mTextPaint.setColor(0xff555555);
		mTextPaint.setTextSize(mTextSize);
		mTextPaint.getTextBounds(mText, 0, mText.length(), mTextBounds);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(0xffffff);
		int alpha = (int) Math.ceil(255 * mAlpha);
		drawSourceText(canvas, alpha);
		drawChangeText(canvas, alpha);
	}

	private void drawSourceText(Canvas canvas, int alpha) {
		mTextPaint.setColor(0xff333333);
		mTextPaint.setAlpha(255 - alpha);
		float x = getMeasuredWidth()/2-mTextBounds.width()/2;
		float y = getMeasuredHeight()/2-mTextBounds.height()/2;
		canvas.drawText(mText, x, y, mTextPaint);
	}

	private void drawChangeText(Canvas canvas, int alpha) {
		mTextPaint.setColor(0xff333333);
		mTextPaint.setAlpha(alpha);
		float x = getMeasuredWidth()/2-mTextBounds.width()/2;
		float y = getMeasuredHeight()/2-mTextBounds.height()/2;
		canvas.drawText(mText, x, y, mTextPaint);
	}


}
