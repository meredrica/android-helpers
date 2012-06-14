/**
 * Copyright (c) 2012, Florian Westreicher aka meredrica. All rights reserved.
 * Copyrights licensed under the Modified BSD License. See LICENSE.txt file for terms.
 */
package org.meredrica.android.examples;

import org.meredrica.android.ui.widgets.ExpandableLayout;
import org.meredrica.android.ui.widgets.ExpandableLayout.OnOpenStateChangedListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ExamplesStartActivity extends Activity implements OnOpenStateChangedListener {
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		((ExpandableLayout) findViewById(R.id.expandable_layout)).setOnOpenStateChangedListener(this);
	}

	@Override
	public void onOpenStateChanged(final ExpandableLayout view, final boolean open) {
		Toast.makeText(this, R.string.expandable_onclick_toast, Toast.LENGTH_SHORT).show();
	}
}