package com.zq.sm.view;

import android.app.Dialog;
import android.content.Context;

import com.zq.sm.R;

/**
 * Created by Administrator on 2018/1/3.
 */

public class LoadingView extends Dialog {

    public LoadingView(Context context) {
        super(context, R.style.dialog);
        setContentView(R.layout.loading);

        LoadingView.this.setCanceledOnTouchOutside(false);
    }
}