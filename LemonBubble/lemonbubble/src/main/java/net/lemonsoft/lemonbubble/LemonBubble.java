package net.lemonsoft.lemonbubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;

import net.lemonsoft.lemonbubble.enums.LemonBubbleLayoutStyle;
import net.lemonsoft.lemonbubble.enums.LemonBubbleLocationStyle;
import net.lemonsoft.lemonbubble.interfaces.LemonBubblePaintContext;

/**
 * 柠檬泡泡控件 - 这个类里面都是静态方法，为的是方便使用者的全局调用
 * Created by LiuRi on 2016/12/25.
 */

public class LemonBubble {

    /**
     * 获取展示一个对号的泡泡控件
     *
     * @return 带有对号的泡泡信息对象
     */
    public static LemonBubbleInfo getRightBubbleInfo() {
        LemonBubbleInfo info = new LemonBubbleInfo();
        info.setLayoutStyle(LemonBubbleLayoutStyle.ICON_TOP_TITLE_BOTTOM);
        info.setIconAnimation(new LemonBubblePaintContext() {
            @Override
            public void paint(Canvas canvas, float playProgress) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.argb(30, 0, 205, 0));
                paint.setStrokeWidth(8);
                canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getWidth() / 2 - 4, paint);
                paint.setColor(Color.argb(255, 0, 205, 0));
                Path path = new Path();
                path.addArc(new RectF(4, 4, canvas.getWidth() - 4, canvas.getHeight() - 4), 67, -225);
                path.lineTo((float) (canvas.getWidth() * 0.42),
                        (float) (canvas.getHeight() * 0.68));
                path.lineTo((float) (canvas.getWidth() * 0.75),
                        (float) (canvas.getHeight() * 0.35));
                Path disPath = new Path();
                PathMeasure measure = new PathMeasure();
                measure.setPath(path, false);
                measure.getSegment((float) Math.max(0, playProgress - 0.26) * measure.getLength(), playProgress * measure.getLength(), disPath, true);
                canvas.drawPath(disPath, paint);
            }
        });
        return info;
    }

    /**
     * 展示一个对号的泡泡控件
     */
    public static void showRight(Context context, String title) {
        LemonBubbleInfo bubbleInfo = getRightBubbleInfo();
        bubbleInfo.setTitle(title);
        LemonBubbleView.defaultBubbleView().showBubbleInfo(context, bubbleInfo);
    }

    /**
     * 获取展示一个叉号的错误提示的泡泡控件
     *
     * @return 带有叉号的错误信息的泡泡信息对象
     */
    public static LemonBubbleInfo getErrorBubbleInfo() {
        LemonBubbleInfo info = new LemonBubbleInfo();
        info.setLayoutStyle(LemonBubbleLayoutStyle.ICON_LEFT_TITLE_RIGHT);
        info.setLocationStyle(LemonBubbleLocationStyle.BOTTOM);
        info.setProportionOfDeviation(0.01f);
        info.setBubbleSize(180, 80);
        info.setIconAnimation(new LemonBubblePaintContext() {
            @Override
            public void paint(Canvas canvas, float playProgress) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.argb(30, 0, 205, 0));
                paint.setStrokeWidth(8);
                canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getWidth() / 2 - 4, paint);
                paint.setColor(Color.argb(255, 0, 205, 0));
                Path path = new Path();
                path.addArc(new RectF(4, 4, canvas.getWidth() - 4, canvas.getHeight() - 4), 67, -225);
                path.lineTo((float) (canvas.getWidth() * 0.42),
                        (float) (canvas.getHeight() * 0.68));
                path.lineTo((float) (canvas.getWidth() * 0.75),
                        (float) (canvas.getHeight() * 0.35));
                Path disPath = new Path();
                PathMeasure measure = new PathMeasure();
                measure.setPath(path, false);
                measure.getSegment((float) Math.max(0, playProgress - 0.26) * measure.getLength(), playProgress * measure.getLength(), disPath, true);
                canvas.drawPath(disPath, paint);
            }
        });
        return info;
    }

    /**
     * 展示一个叉号的带有错误提示的泡泡控件
     */
    public static void showError(Context context, String title) {
        LemonBubbleInfo bubbleInfo = getErrorBubbleInfo();
        bubbleInfo.setTitle(title);
        LemonBubbleView.defaultBubbleView().showBubbleInfo(context, bubbleInfo);
    }

}
