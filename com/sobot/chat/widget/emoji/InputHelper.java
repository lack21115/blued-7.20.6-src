package com.sobot.chat.widget.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import com.sobot.chat.utils.ResourceUtils;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/emoji/InputHelper.class */
public class InputHelper {
    public static void backspace(EditText editText) {
        if (editText == null) {
            return;
        }
        KeyEvent keyEvent = new KeyEvent(0, 67);
        KeyEvent keyEvent2 = new KeyEvent(1, 67);
        editText.onKeyDown(67, keyEvent);
        editText.onKeyUp(67, keyEvent2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [android.text.Spannable] */
    public static Spannable displayEmoji(Context context, CharSequence charSequence) {
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence.toString());
        Resources resources = context.getResources();
        int dimension = (int) resources.getDimension(ResourceUtils.getIdByName(context, "dimen", "sobot_text_font_large"));
        Matcher matcher = Pattern.compile("\\[[^\\]^\\[]+\\]").matcher(spannableString);
        while (matcher.find()) {
            matcher.group();
            try {
                int emojiResId = getEmojiResId(context, matcher.group());
                if (emojiResId > 0) {
                    Drawable drawable = resources.getDrawable(emojiResId);
                    drawable.setBounds(0, 0, dimension, dimension + 0);
                    spannableString.setSpan(new ImageSpan(drawable, 0), matcher.start(), matcher.end(), 17);
                }
            } catch (Exception e) {
            }
        }
        return spannableString;
    }

    public static int getEmojiResId(Context context, String str) {
        Integer num;
        Map<String, Integer> mapAll = DisplayRules.getMapAll(context);
        if (mapAll.size() <= 0 || (num = mapAll.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public static void input2OSC(EditText editText, EmojiconNew emojiconNew) {
        if (editText == null || emojiconNew == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        if (selectionStart < 0) {
            editText.append(emojiconNew.getEmojiCode());
            return;
        }
        String emojiCode = emojiconNew.getEmojiCode();
        editText.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), emojiCode, 0, emojiCode.length());
    }
}
