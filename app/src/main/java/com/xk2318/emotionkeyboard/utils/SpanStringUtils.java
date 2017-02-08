package com.xk2318.emotionkeyboard.utils;

/**
 * Created by xiaokai on 2017/02/07.
 * 字符串匹配表情
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpanStringUtils {

    /*
    * emotionNum 表情编号
    * */
    public static SpannableString getEmotionContent(final Context context, final TextView tv, String source) {
    	int emotionNum = 0;
        SpannableString spannableString = new SpannableString(source);
        String regexEmotion = "\\[[s]:\\d+\\]";//正则表达式规则 --> [d:数字]
        Pattern patternEmotion = Pattern.compile(regexEmotion);
        Matcher matcherEmotion = patternEmotion.matcher(spannableString);
        while (matcherEmotion.find()) {
            // 获取匹配到的具体字符
            String key = matcherEmotion.group();
            emotionNum = Integer.valueOf(key.substring(3, key.indexOf("]")));//获取到表情的编号
            // 匹配字符串的开始位置
            int start = matcherEmotion.start();
            try {
                // 压缩表情图片
                int size = (int) tv.getTextSize()*13/10;
                InputStream in = context.getAssets().open("ems/" + String.valueOf(emotionNum) + ".png");
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
                ImageSpan span = new ImageSpan(context, scaleBitmap);
                spannableString.setSpan(span, start, start + key.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return spannableString;
    }
}
