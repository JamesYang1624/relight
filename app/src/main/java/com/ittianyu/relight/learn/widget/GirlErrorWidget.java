package com.ittianyu.relight.learn.widget;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.ittianyu.relight.R;
import com.ittianyu.relight.widget.Widget;
import com.ittianyu.relight.widget.native_.ImageWidget;
import com.ittianyu.relight.widget.native_.LinearWidget;
import com.ittianyu.relight.widget.native_.TextWidget;
import com.ittianyu.relight.widget.stateless.StatelessWidget;

/**
 * 出错页面
 * <p>
 * Created by liyujiang on 2018/11/21 17:25
 */
public class GirlErrorWidget extends StatelessWidget<LinearLayout, LinearWidget> {
    protected Lifecycle lifecycle;
    protected CharSequence text;
    protected View.OnClickListener onClickListener;

    public GirlErrorWidget(Context context, Lifecycle lifecycle, CharSequence text, View.OnClickListener onClickListener) {
        super(context);
        this.lifecycle = lifecycle;
        this.text = text;
        this.onClickListener = onClickListener;
    }

    @Override
    protected LinearWidget build(Context context) {
        return new LinearWidget(context, lifecycle,
                renderIcon(),
                renderText()
        );
    }

    private Widget renderIcon() {
        return new ImageWidget(context, lifecycle) {
            @Override
            protected void initProps() {
                drawable = drawable(R.mipmap.ic_lcee_error);
                onClickListener = GirlErrorWidget.this.onClickListener;
            }
        };
    }

    private Widget renderText() {
        return new TextWidget(context, lifecycle) {
            @Override
            protected void initProps() {
                marginTop = dp(10);
                text = GirlErrorWidget.this.text;
                onClickListener = GirlErrorWidget.this.onClickListener;
            }
        };
    }

    @Override
    public void initWidget(LinearWidget widget) {
        widget.matchParent();
        widget.orientation(LinearWidget.vertical);
        widget.gravity(Gravity.CENTER);
        widget.onClickListener(onClickListener);
    }

}
