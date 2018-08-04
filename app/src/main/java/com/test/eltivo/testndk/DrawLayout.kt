package com.test.eltivo.testndk

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * Created by eltivo on 18-6-13.
 */
class DrawLayout: FrameLayout {
    constructor(ctx: Context): super(ctx)
    constructor(ctx: Context, abs: AttributeSet): super(ctx, abs)

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action) {
            MotionEvent.ACTION_DOWN -> Log.e("eltivo", "ACTION_DOWN:" + event?.action)
            MotionEvent.ACTION_UP   -> Log.e("eltivo", "ACTION_UP:" + event?.action)
            MotionEvent.ACTION_MOVE -> Log.e("eltivo", "ACTION_MOVE:" + event?.action)
            else                    -> Log.e("eltivo", "other action:" + event?.action)
        }
        return true;
    }
}