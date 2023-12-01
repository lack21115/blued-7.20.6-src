package com.blued.android.framework.push;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/push/NotificationModel.class */
public class NotificationModel {
    private Bitmap bitmap;
    private Bitmap bitmapDef;
    private CharSequence contentText;
    private String contentTitle;
    private int iconResId;
    private Intent intent;
    private Uri soundFileUri;
    public NotificationCompat.Style style;
    private String tickerText;
    private int id = 0;
    private boolean remindEnable = true;
    private boolean shakeEnable = true;
    private boolean voiceEnable = true;
    private boolean innerVoiceEnable = true;
    public int intent_flag = 0;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public Bitmap getBitmapDef() {
        return this.bitmapDef;
    }

    public CharSequence getContentText() {
        return this.contentText;
    }

    public String getContentTitle() {
        return this.contentTitle;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public int getId() {
        return this.id;
    }

    public boolean getInnerVoiceEnable() {
        return this.innerVoiceEnable;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public boolean getRemindEnable() {
        return this.remindEnable;
    }

    public boolean getShakeEnable() {
        return this.shakeEnable;
    }

    public Uri getSoundFileUri() {
        return this.soundFileUri;
    }

    public NotificationCompat.Style getStyle() {
        return this.style;
    }

    public String getTickerText() {
        return this.tickerText;
    }

    public boolean getVoiceEnable() {
        return this.voiceEnable;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setBitmapDef(Bitmap bitmap) {
        this.bitmapDef = bitmap;
    }

    public void setContentText(CharSequence charSequence) {
        this.contentText = charSequence;
    }

    public void setContentTitle(String str) {
        this.contentTitle = str;
    }

    public void setIconResId(int i) {
        this.iconResId = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setInnerVoiceEnable(boolean z) {
        this.innerVoiceEnable = z;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void setRemindEnable(boolean z) {
        this.remindEnable = z;
    }

    public void setShakeEnable(boolean z) {
        this.shakeEnable = z;
    }

    public void setSoundFileUri(Uri uri) {
        this.soundFileUri = uri;
    }

    public void setStyle(NotificationCompat.Style style) {
        this.style = style;
    }

    public void setTickerText(String str) {
        this.tickerText = str;
    }

    public void setVoiceEnable(boolean z) {
        this.voiceEnable = z;
    }
}
