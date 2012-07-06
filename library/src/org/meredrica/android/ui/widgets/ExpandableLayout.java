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
import android.view.InflateException;
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
	private boolean openState = true;
	private OnOpenStateChangedListener onOpenStateChangedListener;
	private View headerOpenView;
	private View footerOpenView;
	private View headerClosedView;
	private View footerClosedView;

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
		int headerOpenId = attributes.getResourceId(R.styleable.ExpandableLayout_header_open, -1);
		int footerOpenId = attributes.getResourceId(R.styleable.ExpandableLayout_footer_open, -1);
		int headerClosedId = attributes.getResourceId(R.styleable.ExpandableLayout_header_closed, -1);
		int footerClosedId = attributes.getResourceId(R.styleable.ExpandableLayout_footer_closed, -1);
		openState = attributes.getBoolean(R.styleable.ExpandableLayout_default_open, true);
		attributes.recycle();
		headerOpenView = headerOpenId != -1 ? inflate(getContext(), headerOpenId, null) : null;
		if (headerOpenView == null) {
			throw new InflateException("missing required attribute header_open");
		}
		setHeader(header); // we need this to set the header the first time.
		footerOpenView = footerOpenId != -1 ? inflate(getContext(), footerOpenId, null) : null;
		if (headerOpenId == headerClosedId) {
			// save some RAM
			headerClosedView = headerOpenView;
		} else {
			headerClosedView = headerClosedId != -1 ? inflate(getContext(), headerClosedId, null) : null;
		}
		if (footerClosedId == footerOpenId) {
			// save some RAM
			footerClosedView = footerOpenView;
		} else {
			footerClosedView = footerClosedId != -1 ? inflate(getContext(), footerClosedId, null) : null;
		}
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
		setOpenState(openState);

	}

	/**
	 * Sets the open State and displays or hides all views. Headers and footers are never hidden.
	 * 
	 * @param open
	 *          The state to set. If true, all children will be set to visible.
	 */
	private void setOpenState(final boolean open) {
		openState = open;
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
		setHeader(open ? headerOpenView : headerClosedView);
		setFooter(open ? footerOpenView : footerClosedView);
	}

	public boolean isOpen() {
		return openState;
	}

	/**
	 * Returns the currently used Header or null if there is none.
	 * 
	 * @return The header
	 */
	public View getHeader() {
		return header;
	}

	public View getHeaderOpenView() {
		return headerOpenView;
	}

	public void setHeaderOpenView(final View headerOpenView) {
		this.headerOpenView = headerOpenView;
	}

	public View getHeaderClosedView() {
		return headerClosedView;
	}

	public void setHeaderClosedView(final View headerClosedView) {
		this.headerClosedView = headerClosedView;
	}

	/**
	 * Sets a View as header. The view will automatically be set to clickable and an {@link OnClickListener} will be set.
	 * If you pass null, the old header is kept instead.
	 * 
	 * @param header
	 *          The header to set.
	 */
	protected void setHeader(final View header) {
		if (header == null) {
			// not having a header defeats the whole purpose of this widget, so we do not allow it.
			return;
		}
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

	public View getFooterOpenView() {
		return footerOpenView;
	}

	public void setFooterOpenView(final View footerOpenView) {
		this.footerOpenView = footerOpenView;
	}

	public View getFooterClosedView() {
		return footerClosedView;
	}

	public void setFooterClosedView(final View footerClosedView) {
		this.footerClosedView = footerClosedView;
	}

	/**
	 * Sets a View as footer. If you pass null, the footer is removed instead.
	 * 
	 * @param footer
	 *          The footer to set or null to remove the footer.
	 */
	protected void setFooter(final View footer) {
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
