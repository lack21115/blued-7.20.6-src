package com.blued.android.module.yy_china.lrc;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.lrc.model.LineInfo;
import com.blued.android.module.yy_china.lrc.model.LyricInfo;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/LrcFileReader.class */
public class LrcFileReader {
    private OnProgressChangedListener a;
    private int b = Color.parseColor("#07FA81");
    private int c = Color.parseColor("#FFFFFF");
    private LyricInfo d = null;
    private boolean f = false;
    private int g = 0;
    private String h = "\\[(\\d{1,2}):(\\d{1,2}).(\\d{1,3})\\]";
    private Pattern i = Pattern.compile("\\[(\\d{1,2}):(\\d{1,2}).(\\d{1,3})\\]");
    private ExecutorService e = Executors.newFixedThreadPool(5);

    /* renamed from: com.blued.android.module.yy_china.lrc.LrcFileReader$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/LrcFileReader$1.class */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ InputStream a;
        final /* synthetic */ LrcFileReader b;

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.a);
        }
    }

    /* renamed from: com.blued.android.module.yy_china.lrc.LrcFileReader$3  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/LrcFileReader$3.class */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ long b;
        final /* synthetic */ DataHolder c;
        final /* synthetic */ LrcFileReader d;

        @Override // java.lang.Runnable
        public void run() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int size = this.a.size();
            int i = 0;
            for (int i2 = 0; i2 < size && ((LineInfo) this.a.get(i2)).getStart() < this.b; i2++) {
                i = i2;
            }
            if (i != this.d.g || this.d.f) {
                this.d.g = i;
                int size2 = this.a.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        break;
                    }
                    LrcFileReader lrcFileReader = this.d;
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i4 == i ? lrcFileReader.b : lrcFileReader.c);
                    SpannableString spannableString = new SpannableString(((LineInfo) this.a.get(i4)).getContent() + "\n");
                    spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    i3 = i4 + 1;
                }
                this.c.a = spannableStringBuilder;
                this.c.d = i;
                this.c.c = this.d.f;
                this.c.b = this.a;
                if (this.d.f) {
                    this.d.f = false;
                }
                this.d.a(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/LrcFileReader$DataHolder.class */
    public class DataHolder {
        public SpannableStringBuilder a;
        public List<LineInfo> b;
        public boolean c;
        public int d;
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/LrcFileReader$OnProgressChangedListener.class */
    public interface OnProgressChangedListener {
        void a(SpannableStringBuilder spannableStringBuilder, int i, boolean z);

        void a(String str, boolean z);

        void a(List<LineInfo> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataHolder dataHolder) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.lrc.LrcFileReader.4
            @Override // java.lang.Runnable
            public void run() {
                if (dataHolder == null || LrcFileReader.this.a == null) {
                    return;
                }
                LrcFileReader.this.a.a(dataHolder.a, dataHolder.d, dataHolder.c);
                if (dataHolder.b != null) {
                    LrcFileReader.this.a.a(dataHolder.b.get(dataHolder.d).getContent(), dataHolder.c);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InputStream inputStream) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
            this.d = new LyricInfo();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                a(readLine);
            }
            bufferedReader.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.lrc.LrcFileReader.2
            @Override // java.lang.Runnable
            public void run() {
                if (LrcFileReader.this.a != null) {
                    LrcFileReader.this.a.a(LrcFileReader.this.d.getLines());
                }
            }
        });
    }

    private void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Log.e("song_words", str);
        LineInfo lineInfo = new LineInfo();
        int lastIndexOf = str.lastIndexOf("]");
        if (str.startsWith("[offset:")) {
            this.d.setOffset(Long.parseLong(str.substring(8, lastIndexOf).trim()));
        } else if (str.startsWith("^[ti:")) {
            this.d.setTitle(str.substring(4, lastIndexOf).trim());
        } else if (str.startsWith("[ar:")) {
            this.d.setArtist(str.substring(4, lastIndexOf).trim());
        } else if (str.startsWith("[al:")) {
            this.d.setAlbum(str.substring(4, lastIndexOf).trim());
        } else if (str.startsWith("[by:")) {
        } else {
            Matcher matcher = this.i.matcher(str);
            while (matcher.find()) {
                lineInfo.setStart((StringUtils.a(matcher.group(1), 0) * 60 * 1000) + (StringUtils.a(matcher.group(2), 0) * 1000) + StringUtils.a(matcher.group(3), 0));
                lineInfo.setContent(str.substring(matcher.end()));
                this.d.getLines().add(lineInfo);
            }
        }
    }
}
