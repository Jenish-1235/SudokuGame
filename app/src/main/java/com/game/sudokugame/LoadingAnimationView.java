package com.game.sudokugame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LoadingAnimationView extends View {

    private Paint paint;
    private float angle;
    private ValueAnimator animator;

    public LoadingAnimationView(Context context) {
        super(context);
        init();
    }

    public LoadingAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.rgb(17,138,178));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(40f);

        animator = ValueAnimator.ofFloat(0f, 361f);
        animator.setDuration(1500);
        animator.setRepeatCount(0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                angle = (float) animation.getAnimatedValue();
                invalidate();
            }


        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent signUpIntent = new Intent(getContext(), signUpScreen.class);
                getContext().startActivity(signUpIntent);
            }
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 2 - (int) paint.getStrokeWidth() / 2;

        canvas.drawArc(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius,
                0f,
                angle,
                false,
                paint
        );
    }
}