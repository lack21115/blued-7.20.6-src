package com.tencent.ugc.videoprocessor.watermark;

import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.n;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPaster;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPasterJsonConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/watermark/AnimatedPasterFilterChain.class */
public class AnimatedPasterFilterChain extends PasterBase {
    private static final String TAG = "AnimatedPasterFilterChain";
    private List<TXVideoEditConstants.TXAnimatedPaster> mAnimatedPasterList;
    private CopyOnWriteArrayList<AnimatedPaster> mNormalizedList = new CopyOnWriteArrayList<>();

    private TXVideoEditConstants.TXAnimatedPaster construct(TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster, TXVideoEditConstants.TXRect tXRect) {
        TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster2 = new TXVideoEditConstants.TXAnimatedPaster();
        tXAnimatedPaster2.frame = tXRect;
        tXAnimatedPaster2.animatedPasterPathFolder = tXAnimatedPaster.animatedPasterPathFolder;
        tXAnimatedPaster2.startTime = tXAnimatedPaster.startTime;
        tXAnimatedPaster2.endTime = tXAnimatedPaster.endTime;
        tXAnimatedPaster2.rotation = tXAnimatedPaster.rotation;
        return tXAnimatedPaster2;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String parseJsonFromFile(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r11 = r0
            r0 = 0
            r10 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6b
            r1 = r0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6b
            r3 = r2
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6b
            r5 = r4
            r6 = r9
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6b
            r9 = r0
        L1c:
            r0 = r9
            r10 = r0
            r0 = r9
            java.lang.String r0 = r0.readLine()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L83
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L56
            r0 = r9
            r10 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L83
            r1 = r0
            r1.<init>()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L83
            r13 = r0
            r0 = r9
            r10 = r0
            r0 = r13
            r1 = r11
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L83
            r0 = r9
            r10 = r0
            r0 = r13
            r1 = r12
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L83
            r0 = r9
            r10 = r0
            r0 = r13
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L83
            r12 = r0
            r0 = r12
            r11 = r0
            goto L1c
        L56:
            r0 = r9
            r10 = r0
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L83
        L5c:
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L8e
            r0 = r11
            return r0
        L62:
            r12 = move-exception
            goto L6f
        L67:
            r9 = move-exception
            goto L84
        L6b:
            r12 = move-exception
            r0 = 0
            r9 = r0
        L6f:
            r0 = r9
            r10 = r0
            java.lang.String r0 = "AnimatedPasterFilterChain"
            java.lang.String r1 = "read file failed."
            r2 = r12
            com.tencent.liteav.base.util.LiteavLog.e(r0, r1, r2)     // Catch: java.lang.Throwable -> L83
            r0 = r9
            if (r0 == 0) goto L81
            goto L5c
        L81:
            r0 = r11
            return r0
        L83:
            r9 = move-exception
        L84:
            r0 = r10
            if (r0 == 0) goto L8c
            r0 = r10
            r0.close()     // Catch: java.io.IOException -> L91
        L8c:
            r0 = r9
            throw r0
        L8e:
            r9 = move-exception
            r0 = r11
            return r0
        L91:
            r10 = move-exception
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videoprocessor.watermark.AnimatedPasterFilterChain.parseJsonFromFile(java.lang.String):java.lang.String");
    }

    private AnimatedPasterJsonConfig parsePaster(String str) {
        String parseJsonFromFile = parseJsonFromFile(str + AnimatedPasterJsonConfig.FILE_NAME);
        if (TextUtils.isEmpty(parseJsonFromFile)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(parseJsonFromFile);
            AnimatedPasterJsonConfig animatedPasterJsonConfig = new AnimatedPasterJsonConfig();
            try {
                animatedPasterJsonConfig.mName = jSONObject.getString("name");
                animatedPasterJsonConfig.mCount = jSONObject.getInt("count");
                animatedPasterJsonConfig.mPeriod = jSONObject.getInt("period");
                animatedPasterJsonConfig.mWidth = jSONObject.getInt("width");
                animatedPasterJsonConfig.mHeight = jSONObject.getInt("height");
                animatedPasterJsonConfig.mKeyframe = jSONObject.getInt(AnimatedPasterJsonConfig.CONFIG_KEYFRAME);
                JSONArray jSONArray = jSONObject.getJSONArray(AnimatedPasterJsonConfig.CONFIG_KEYFRAME_ARRAY);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= animatedPasterJsonConfig.mCount) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    AnimatedPasterJsonConfig.PasterPicture pasterPicture = new AnimatedPasterJsonConfig.PasterPicture();
                    pasterPicture.mPictureName = jSONObject2.getString("picture");
                    animatedPasterJsonConfig.mFrameArray.add(pasterPicture);
                    i = i2 + 1;
                }
            } catch (JSONException e) {
                LiteavLog.e(TAG, "failed to get value from json.", e);
            }
            return animatedPasterJsonConfig;
        } catch (JSONException e2) {
            LiteavLog.e(TAG, "parse invalid json string", e2);
            return null;
        }
    }

    @Override // com.tencent.ugc.videoprocessor.watermark.PasterBase
    public void clear() {
        super.clear();
        this.mNormalizedList.clear();
        List<TXVideoEditConstants.TXAnimatedPaster> list = this.mAnimatedPasterList;
        if (list != null) {
            list.clear();
        }
        this.mAnimatedPasterList = null;
    }

    public List<AnimatedPaster> getAnimatedPasterList() {
        return this.mNormalizedList;
    }

    @Override // com.tencent.ugc.videoprocessor.watermark.PasterBase
    public void normalized(int i, int i2, int i3) {
        List<TXVideoEditConstants.TXAnimatedPaster> list = this.mAnimatedPasterList;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<TXVideoEditConstants.TXAnimatedPaster> it = this.mAnimatedPasterList.iterator();
        while (it.hasNext()) {
            TXVideoEditConstants.TXAnimatedPaster next = it.next();
            if (next != null) {
                TXVideoEditConstants.TXAnimatedPaster construct = construct(next, calculateRect(i, i2, i3, next.frame));
                AnimatedPasterJsonConfig parsePaster = parsePaster(construct.animatedPasterPathFolder);
                if (parsePaster != null && parsePaster.mCount > 0) {
                    long j = construct.startTime;
                    long j2 = construct.endTime - j;
                    int i4 = parsePaster.mPeriod / parsePaster.mCount;
                    int i5 = (int) (j2 / parsePaster.mPeriod);
                    int i6 = i5;
                    if (j2 % parsePaster.mPeriod > 0) {
                        i6 = i5 + 1;
                    }
                    int i7 = 0;
                    Iterator<TXVideoEditConstants.TXAnimatedPaster> it2 = it;
                    while (true) {
                        it = it2;
                        if (i7 < i6) {
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 < parsePaster.mCount) {
                                    long j3 = i4 + j;
                                    if (j3 <= construct.endTime) {
                                        AnimatedPasterJsonConfig.PasterPicture pasterPicture = parsePaster.mFrameArray.get(i9);
                                        AnimatedPaster animatedPaster = new AnimatedPaster();
                                        animatedPaster.mPasterPath = construct.animatedPasterPathFolder + pasterPicture.mPictureName + ".png";
                                        animatedPaster.mFrame = construct.frame;
                                        animatedPaster.mStartTime = j;
                                        animatedPaster.mEndTime = j3;
                                        animatedPaster.mRotation = construct.rotation;
                                        this.mNormalizedList.add(animatedPaster);
                                        j = animatedPaster.mEndTime;
                                        i8 = i9 + 1;
                                    }
                                }
                            }
                            i7++;
                        }
                    }
                }
            }
        }
    }

    public void setAnimatedPasterList(List<TXVideoEditConstants.TXAnimatedPaster> list, n nVar) {
        this.mRenderSize = nVar;
        this.mAnimatedPasterList = list;
        this.mNormalizedList.clear();
    }
}
