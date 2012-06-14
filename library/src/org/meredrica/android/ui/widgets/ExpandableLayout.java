/**
 * Copyright (c) 2012, Florian Westreicher aka meredrica. All rights reserved.
 * Copyrights licensed under the Modified BSD License. See LICENSE.txt file for terms.
 */
package org.meredrica.android.ui.widgets;

import org.meredrica.android.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * A Layout that can be expanded (opened) and closed by pressing the header or calling toggle().
 * 
 * @author Florian Westreicher aka meredrica
 * @since Jun 14, 2012
 */
public class ExpandableLayout extends LinearLayout implements View.OnClickListener {

	private static final String TAG = ExpandableLayout.class.getSimpleName();
	private View header;
	private View footer;
	private int headerId = -1;
	private int footerId = -1;
	private boolean open = true;
	private OnOpenStateChangedListener onOpenStateChangedListener;

	public ExpandableLayout(final Context context) {
		super(context);
		Log.d(TAG, "created");
		setOrientation(VERTICAL);
	}

	public ExpandableLayout(final Context context, final AttributeSet attrs) {
		super(context, attrs);
		Log.d(TAG, "created  with attributes");
		setOrientation(VERTICAL);
		TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ExpandableLayout);
		headerId = attributes.getResourceId(R.styleable.ExpandableLayout_header, -1);
		footerId = attributes.getResourceId(R.styleable.ExpandableLayout_footer, -1);
		open = attributes.getBoolean(R.styleable.ExpandableLayout_open, true);
		attributes.recycle();
	}

	@Override
	public void onClick(final View v) {
		Log.d(TAG, "onClick");
		if (v == header) {
			toggle();
		}
	}

	/**
	 * Either displays all children or hides them all. Headers and footers are never hidden.
	 */
	public void toggle() {
		setOpenState(!isOpen());
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		Log.d(TAG, "onfinishinflate");
		createAndAddViews();
	}

	private void createAndAddViews() {
		if (headerId != -1) {
			setHeader(inflate(getContext(), headerId, null));
		}
		if (footerId != -1) {
			setFooter(inflate(getContext(), footerId, null));
		}
		setOpenState(open);
	}

	/**
	 * Sets the open State and displays or hides all views. Headers and footers are never hidden.
	 * 
	 * @param open
	 *          The state to set. If true, all children will be set to visible.
	 */
	private void setOpenState(final boolean open) {
		this.open = open;
		int all = getChildCount();
		all -= hasFooter() ? 1 : 0; // we do not want to hide the footer if we have one.
		int start = hasHeader() ? 1 : 0; // if we do not have a header, we start at 0
		int visibility = open ? VISIBLE : GONE;
		for (int i = start; i < all; i++) {
			getChildAt(i).setVisibility(visibility);
		}
		if (onOpenStateChangedListener != null) {
			onOpenStateChangedListener.onOpenStateChanged(this, open);
		}
	}

	public boolean isOpen() {
		return open;
	}

	public View getHeader() {
		return header;
	}

	/**
	 * Sets a View as header. The view will automatically be set to clickable. If you pass null, the header is removed
	 * instead.
	 * 
	 * @param header
	 *          The header to set or null to remove the header.
	 */
	public void setHeader(final View header) {
		if (hasHeader()) {
			removeView(getHeader());
		}
		this.header = header;
		if (hasHeader()) {
			addView(getHeader(), 0);
			getHeader().setClickable(true);
			getHeader().setOnClickListener(this);
		}
	}

	public boolean hasHeader() {
		return header != null;
	}

	public View getFooter() {
		return footer;
	}

	public void setFooter(final View footer) {
		if (hasFooter()) {
			removeView(getFooter());
		}
		this.footer = footer;
		if (hasFooter()) {
			addView(getFooter());
		}
	}

	public boolean hasFooter() {
		return footer != null;
	}

	/**
	 * Sets the Listener, replacing all old ones.
	 * 
	 * @param onOpenStateChangedListener
	 *          The Listener to set.
	 */
	public void setOnOpenStateChangedListener(final OnOpenStateChangedListener onOpenStateChangedListener) {
		this.onOpenStateChangedListener = onOpenStateChangedListener;
	}

	public OnOpenStateChangedListener getOnOpenStateChangedListener() {
		return onOpenStateChangedListener;
	}

	public interface OnOpenStateChangedListener {
		/**
		 * Will be called after the opened state was changed and all views are either Visible or Gone.
		 * 
		 * @param view
		 *          The view that changed.
		 * @param open
		 *          True if the new state is open, false otherwise.
		 */
		public void onOpenStateChanged(ExpandableLayout view, boolean open);
	}
}
