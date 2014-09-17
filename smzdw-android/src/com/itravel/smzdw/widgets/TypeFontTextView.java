package com.itravel.smzdw.widgets;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypeFontTextView extends TextView {

	public TypeFontTextView(Context context) {
		this(context, null);
	}

	public TypeFontTextView(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.textViewStyle);
	}

	public TypeFontTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		Typeface font = Typeface.createFromAsset(context.getAssets(),
				"fontawesome-webfont.ttf");
		this.setTypeface(font);
	}

}
