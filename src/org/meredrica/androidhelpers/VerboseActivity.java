/**
 * Copyright (c) 2012, Florian Westreicher aka meredrica All rights reserved.
 * Copyrights licensed under the Modified BSD License. See LICENSE.txt file for terms.
 */
package org.meredrica.androidhelpers;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;

/**
 * An activity that prints out all on* methods that are called, along with the params that were passed.
 * 
 * @author Florian Westreicher aka meredrica
 */
public class VerboseActivity extends Activity {

	protected String TAG = getClass().getSimpleName();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		Log.v(TAG, "onCreate " + savedInstanceState);
		super.onCreate(savedInstanceState);
	};

	@Override
	protected void onSaveInstanceState(final Bundle outState) {
		Log.v(TAG, "onSaveInstanceState " + outState);
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(final Bundle savedInstanceState) {
		Log.v(TAG, "onRestoreInstanceState " + savedInstanceState);
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onStart() {
		Log.v(TAG, "onStart");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.v(TAG, "onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.v(TAG, "onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.v(TAG, "onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.v(TAG, "onStop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.v(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
		Log.v(TAG, "onActivityResult " + requestCode + " " + resultCode + " " + data + "");
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onNewIntent(final Intent intent) {
		Log.v(TAG, "onNewIntent");
		super.onNewIntent(intent);
	}

	@Override
	public void onAttachedToWindow() {
		Log.v(TAG, "onAttachedToWindow");
		super.onAttachedToWindow();
	}

	@Override
	protected void onApplyThemeResource(final Theme theme, final int resid, final boolean first) {
		Log.v(TAG, "onApplyThemeResource " + theme + " " + resid + " " + first);
		super.onApplyThemeResource(theme, resid, first);
	}

	@Override
	public void onBackPressed() {
		Log.v(TAG, "onBackPressed");
		super.onBackPressed();
	}

	@Override
	protected void onChildTitleChanged(final Activity childActivity, final CharSequence title) {
		Log.v(TAG, "onChildTitleChanged " + childActivity + " " + title);
		super.onChildTitleChanged(childActivity, title);
	}

	@Override
	public void onConfigurationChanged(final Configuration newConfig) {
		Log.v(TAG, "onConfigurationChanged " + newConfig);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onContentChanged() {
		Log.v(TAG, "onContentChanged");
		super.onContentChanged();
	}

	@Override
	public void onDetachedFromWindow() {
		Log.v(TAG, "onDetachedFromWindow");
		super.onDetachedFromWindow();
	}

	@Override
	public void onWindowFocusChanged(final boolean hasFocus) {
		Log.v(TAG, "onWindowFocusChanged " + hasFocus);
		super.onWindowFocusChanged(hasFocus);
	}

	@Override
	public boolean onContextItemSelected(final MenuItem item) {
		Log.v(TAG, "onContextItemSelected " + item);
		return super.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(final Menu menu) {
		Log.v(TAG, "onContextMenuClosed " + menu);
		super.onContextMenuClosed(menu);
	}

	@Override
	public void onCreateContextMenu(final ContextMenu menu, final View v, final ContextMenuInfo menuInfo) {
		Log.v(TAG, "onCreateContextMenu " + menu + " " + v + " " + menuInfo);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public CharSequence onCreateDescription() {
		Log.v(TAG, "onCreateDescription");
		return super.onCreateDescription();
	}

	@Override
	protected Dialog onCreateDialog(final int id) {
		Log.v(TAG, "onCreateDialog " + id);
		return super.onCreateDialog(id);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		Log.v(TAG, "onCreateOptionsMenu " + menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onCreatePanelMenu(final int featureId, final Menu menu) {
		Log.v(TAG, "onCreatePanelMenu " + featureId + " " + menu);
		return super.onCreatePanelMenu(featureId, menu);
	}

	@Override
	public View onCreatePanelView(final int featureId) {
		Log.v(TAG, "onCreatePanelView " + featureId);
		return super.onCreatePanelView(featureId);
	}

	@Override
	public boolean onCreateThumbnail(final Bitmap outBitmap, final Canvas canvas) {
		Log.v(TAG, "onCreateThumbnail " + outBitmap + canvas);
		return super.onCreateThumbnail(outBitmap, canvas);
	}

	@Override
	public View onCreateView(final String name, final Context context, final AttributeSet attrs) {
		Log.v(TAG, "onCreateView " + name + " " + context + " " + attrs);
		return super.onCreateView(name, context, attrs);
	}

	@Override
	public boolean onKeyDown(final int keyCode, final KeyEvent event) {
		Log.v(TAG, "onKeyDown " + keyCode + " " + event);
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyLongPress(final int keyCode, final KeyEvent event) {
		Log.v(TAG, "onKeyLongPress " + keyCode + " " + event);
		return super.onKeyLongPress(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(final int keyCode, final int repeatCount, final KeyEvent event) {
		Log.v(TAG, "onKeyMultiple " + keyCode + " " + repeatCount + " " + event);
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyUp(final int keyCode, final KeyEvent event) {
		Log.v(TAG, "onKeyUp " + keyCode + " " + event);
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		Log.v(TAG, "onLowMemory");
		super.onLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(final int featureId, final MenuItem item) {
		Log.v(TAG, "onMenuItemSelected " + featureId + " " + item);
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onMenuOpened(final int featureId, final Menu menu) {
		Log.v(TAG, "onMenuOpened " + featureId + " " + menu);
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		Log.v(TAG, "onOptionsItemSelected " + item);
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(final Menu menu) {
		Log.v(TAG, "onOptionsMenuClosed " + menu);
		super.onOptionsMenuClosed(menu);
	}

	@Override
	public void onPanelClosed(final int featureId, final Menu menu) {
		Log.v(TAG, "onPanelClosed " + featureId + " " + menu);
		super.onPanelClosed(featureId, menu);
	}

	@Override
	protected void onPostCreate(final Bundle savedInstanceState) {
		Log.v(TAG, "onPostCreate " + savedInstanceState);
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onPostResume() {
		Log.v(TAG, "onPostResume");
		super.onPostResume();
	}

	@Override
	protected void onPrepareDialog(final int id, final Dialog dialog) {
		Log.v(TAG, "onPrepareDialog " + id + " " + dialog);
		super.onPrepareDialog(id, dialog);
	}

	@Override
	public boolean onPrepareOptionsMenu(final Menu menu) {
		Log.v(TAG, "onPrepareOptionsMenu " + menu);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onPreparePanel(final int featureId, final View view, final Menu menu) {
		Log.v(TAG, "onPreparePanel " + featureId + " " + view + " " + menu);
		return super.onPreparePanel(featureId, view, menu);
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		Log.v(TAG, "onRetainNonConfigurationInstance");
		return super.onRetainNonConfigurationInstance();
	}

	@Override
	public boolean onSearchRequested() {
		Log.v(TAG, "onSearchRequested");
		return super.onSearchRequested();
	}

	@Override
	protected void onTitleChanged(final CharSequence title, final int color) {
		Log.v(TAG, "onTitleChanged " + title + " " + color);
		super.onTitleChanged(title, color);
	}

	@Override
	public boolean onTouchEvent(final MotionEvent event) {
		Log.v(TAG, "onTouchEvent " + event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onTrackballEvent(final MotionEvent event) {
		Log.v(TAG, "onTrackballEvent" + event);
		return super.onTrackballEvent(event);
	}

	@Override
	public void onUserInteraction() {
		Log.v(TAG, "onUserInteraction");
		super.onUserInteraction();
	}

	@Override
	protected void onUserLeaveHint() {
		Log.v(TAG, "onUserLeaveHint");
		super.onUserLeaveHint();
	}

	@Override
	public void onWindowAttributesChanged(final LayoutParams params) {
		Log.v(TAG, "onWindowAttributesChanged " + params);
		super.onWindowAttributesChanged(params);
	}

	@Override
	public void onActionModeFinished(final ActionMode mode) {
		Log.v(TAG, "onActionModeFinished " + mode);
		super.onActionModeFinished(mode);
	}

	@Override
	public void onActionModeStarted(final ActionMode mode) {
		Log.v(TAG, "onActionModeStarted " + mode);
		super.onActionModeStarted(mode);
	}

	@Override
	public void onAttachFragment(final Fragment fragment) {
		Log.v(TAG, "onAttachFragment " + fragment);
		super.onAttachFragment(fragment);
	}

	@Override
	protected Dialog onCreateDialog(final int id, final Bundle args) {
		Log.v(TAG, "onCreateDialog " + id + " " + args);
		return super.onCreateDialog(id, args);
	}

	@Override
	public View onCreateView(final View parent, final String name, final Context context, final AttributeSet attrs) {
		Log.v(TAG, "onCreateView " + parent + " " + name + " " + context + " " + attrs);
		return super.onCreateView(parent, name, context, attrs);
	}

	@Override
	public boolean onGenericMotionEvent(final MotionEvent event) {
		Log.v(TAG, "onGenericMotionEvent " + event);
		return super.onGenericMotionEvent(event);
	}

	@Override
	public boolean onKeyShortcut(final int keyCode, final KeyEvent event) {
		Log.v(TAG, "onKeyShortcut " + keyCode + " " + event);
		return super.onKeyShortcut(keyCode, event);
	}

	@Override
	protected void onPrepareDialog(final int id, final Dialog dialog, final Bundle args) {
		Log.v(TAG, "onPrepareDialog " + id + " " + dialog + " " + args);
		super.onPrepareDialog(id, dialog, args);
	}

	@Override
	public void onTrimMemory(final int level) {
		Log.v(TAG, "onTrimMemory " + level);
		super.onTrimMemory(level);
	}

	@Override
	public ActionMode onWindowStartingActionMode(final Callback callback) {
		Log.v(TAG, "onWindowStartingActionMode " + callback);
		return super.onWindowStartingActionMode(callback);
	}

}
