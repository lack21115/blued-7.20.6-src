package com.tencent.ugc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.RemuxJoiner;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.datereport.UGCDataReport;
import java.io.File;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoJoiner.class */
public class TXVideoJoiner {
    private static final String TAG = "TXVideoJoiner";
    private RemuxJoiner mRemuxJoiner;
    private final TXVideoEditer mTXVideoEditer;
    private TXVideoJoinerListener mTXVideoJoinerListener;
    private TXVideoPreviewListener mTXVideoPreviewListener;
    private String mVideoOutputPath;
    private List<String> mVideoSourceList;
    private long mDuration = -1;
    private boolean mIsNeedEdit = false;
    private final TXVideoEditer.TXVideoPreviewListener mTXEditerVideoPreviewListener = new TXVideoEditer.TXVideoPreviewListener() { // from class: com.tencent.ugc.TXVideoJoiner.1
        @Override // com.tencent.ugc.TXVideoEditer.TXVideoPreviewListener
        public final void onPreviewFinished() {
            TXVideoPreviewListener tXVideoPreviewListener = TXVideoJoiner.this.mTXVideoPreviewListener;
            if (tXVideoPreviewListener != null) {
                tXVideoPreviewListener.onPreviewFinished();
            }
        }

        @Override // com.tencent.ugc.TXVideoEditer.TXVideoPreviewListener
        public final void onPreviewProgress(int i) {
            TXVideoPreviewListener tXVideoPreviewListener = TXVideoJoiner.this.mTXVideoPreviewListener;
            if (tXVideoPreviewListener != null) {
                tXVideoPreviewListener.onPreviewProgress(i);
            }
        }
    };
    private final TXVideoEditer.TXVideoGenerateListener mTXEditerVideoJoinerListener = new TXVideoEditer.TXVideoGenerateListener() { // from class: com.tencent.ugc.TXVideoJoiner.2
        @Override // com.tencent.ugc.TXVideoEditer.TXVideoGenerateListener
        public final void onGenerateComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult) {
            TXVideoJoiner.this.notifyJoinComplete(tXGenerateResult.retCode, tXGenerateResult.descMsg);
        }

        @Override // com.tencent.ugc.TXVideoEditer.TXVideoGenerateListener
        public final void onGenerateProgress(float f) {
            TXVideoJoiner.this.notifyJoinProgress(f);
        }
    };
    private final RemuxJoiner.RemuxJoinerListener mRemuxJoinerListener = new AnonymousClass3();
    private final com.tencent.liteav.base.util.j mSequenceTaskRunner = new com.tencent.liteav.base.util.j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.ugc.TXVideoJoiner$3  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoJoiner$3.class */
    public final class AnonymousClass3 implements RemuxJoiner.RemuxJoinerListener {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass3 anonymousClass3, int i, String str) {
            TXVideoJoiner.this.notifyJoinComplete(i, str);
            if (TXVideoJoiner.this.mRemuxJoiner != null) {
                TXVideoJoiner.this.mRemuxJoiner.stop();
                TXVideoJoiner.this.mRemuxJoiner.uninitialize();
                TXVideoJoiner.this.mRemuxJoiner = null;
            }
        }

        @Override // com.tencent.ugc.RemuxJoiner.RemuxJoinerListener
        public final void onRemuxJoinerComplete(int i, String str) {
            TXVideoJoiner.this.mSequenceTaskRunner.a(ch.a(this, i, str));
        }

        @Override // com.tencent.ugc.RemuxJoiner.RemuxJoinerListener
        public final void onRemuxJoinerProgress(float f) {
            TXVideoJoiner.this.mSequenceTaskRunner.a(cg.a(this, f));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoJoiner$TXVideoJoinerListener.class */
    public interface TXVideoJoinerListener {
        void onJoinComplete(TXVideoEditConstants.TXJoinerResult tXJoinerResult);

        void onJoinProgress(float f);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoJoiner$TXVideoPreviewListener.class */
    public interface TXVideoPreviewListener {
        void onPreviewFinished();

        void onPreviewProgress(int i);
    }

    public TXVideoJoiner(Context context) {
        this.mTXVideoEditer = new TXVideoEditer(context.getApplicationContext(), this.mSequenceTaskRunner);
        UGCDataReport.reportDAU(1005);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$cancel$7(TXVideoJoiner tXVideoJoiner) {
        RemuxJoiner remuxJoiner = tXVideoJoiner.mRemuxJoiner;
        if (remuxJoiner == null) {
            tXVideoJoiner.mTXVideoEditer.cancel();
            return;
        }
        remuxJoiner.stop();
        tXVideoJoiner.mRemuxJoiner.uninitialize();
        tXVideoJoiner.mRemuxJoiner = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$joinVideo$6(TXVideoJoiner tXVideoJoiner, String str, int i) {
        if (tXVideoJoiner.startQuickJoinVideo(str)) {
            LiteavLog.i(TAG, "quickJoinVideo success");
            return;
        }
        RemuxJoiner remuxJoiner = tXVideoJoiner.mRemuxJoiner;
        if (remuxJoiner != null) {
            remuxJoiner.stop();
            tXVideoJoiner.mRemuxJoiner.uninitialize();
            tXVideoJoiner.mRemuxJoiner = null;
        }
        tXVideoJoiner.mTXVideoEditer.setIsFullIFrame(tXVideoJoiner.mIsNeedEdit);
        tXVideoJoiner.mTXVideoEditer.setIsSplitScreen(false);
        tXVideoJoiner.mTXVideoEditer.generateVideo(i, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSplitScreenList$8(TXVideoJoiner tXVideoJoiner, List list, int i, int i2) {
        tXVideoJoiner.mTXVideoEditer.setIsSplitScreen(true);
        tXVideoJoiner.mTXVideoEditer.setSplitScreenList(list, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setTXVideoPreviewListener$2(TXVideoJoiner tXVideoJoiner, TXVideoPreviewListener tXVideoPreviewListener) {
        tXVideoJoiner.mTXVideoPreviewListener = tXVideoPreviewListener;
        tXVideoJoiner.mTXVideoEditer.setTXVideoPreviewListener(tXVideoJoiner.mTXEditerVideoPreviewListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoJoinerListener$4(TXVideoJoiner tXVideoJoiner, TXVideoJoinerListener tXVideoJoinerListener) {
        tXVideoJoiner.mTXVideoJoinerListener = tXVideoJoinerListener;
        tXVideoJoiner.mTXVideoEditer.setVideoGenerateListener(tXVideoJoiner.mTXEditerVideoJoinerListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoPathList$0(TXVideoJoiner tXVideoJoiner, List list) {
        tXVideoJoiner.mVideoSourceList = list;
        tXVideoJoiner.mTXVideoEditer.setMediaSourcePaths(list);
        tXVideoJoiner.mDuration = tXVideoJoiner.mTXVideoEditer.getDuration();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$splitJoinVideo$10(TXVideoJoiner tXVideoJoiner, int i, String str) {
        tXVideoJoiner.mTXVideoEditer.setIsFullIFrame(tXVideoJoiner.mIsNeedEdit);
        TXVideoEditer tXVideoEditer = tXVideoJoiner.mTXVideoEditer;
        tXVideoEditer.setIsSplitScreen(tXVideoEditer.isHasAudio());
        tXVideoJoiner.mTXVideoEditer.generateVideo(i, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$startPlay$3(TXVideoJoiner tXVideoJoiner) {
        if (tXVideoJoiner.mDuration == -1) {
            tXVideoJoiner.mDuration = tXVideoJoiner.mTXVideoEditer.getDuration();
        }
        tXVideoJoiner.mTXVideoEditer.startPlayFromTime(0L, tXVideoJoiner.mDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJoinComplete(int i, String str) {
        TXVideoEditConstants.TXJoinerResult tXJoinerResult = new TXVideoEditConstants.TXJoinerResult();
        tXJoinerResult.descMsg = str;
        tXJoinerResult.retCode = i;
        LiteavLog.i(TAG, "TXGenerateResult descMsg = " + str + " retCode = " + i);
        TXVideoJoinerListener tXVideoJoinerListener = this.mTXVideoJoinerListener;
        if (tXVideoJoinerListener != null) {
            tXVideoJoinerListener.onJoinComplete(tXJoinerResult);
        }
        if (i == 0 && !TextUtils.isEmpty(this.mVideoOutputPath) && new File(this.mVideoOutputPath).exists()) {
            UGCDataReport.reportDAU(1032, (int) new File(this.mVideoOutputPath).length(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJoinProgress(float f) {
        TXVideoJoinerListener tXVideoJoinerListener = this.mTXVideoJoinerListener;
        if (tXVideoJoinerListener != null) {
            tXVideoJoinerListener.onJoinProgress(f);
        }
    }

    private boolean startQuickJoinVideo(String str) {
        List<String> list = this.mVideoSourceList;
        if (list == null || !RemuxJoiner.isConcatableWithoutReencode(list)) {
            return false;
        }
        LiteavLog.i(TAG, "RemuxerJoinerChecker check is ok");
        if (this.mRemuxJoiner == null) {
            RemuxJoiner remuxJoiner = new RemuxJoiner();
            this.mRemuxJoiner = remuxJoiner;
            remuxJoiner.initialize();
        }
        this.mRemuxJoiner.stop();
        if (this.mRemuxJoiner.setSourcePaths(this.mVideoSourceList) || this.mRemuxJoiner.setTargetPath(str)) {
            return false;
        }
        this.mVideoOutputPath = str;
        this.mRemuxJoiner.setVideoJoinerListener(this.mRemuxJoinerListener);
        return this.mRemuxJoiner.start();
    }

    public void cancel() {
        LiteavLog.i(TAG, com.anythink.expressad.d.a.b.dO);
        this.mSequenceTaskRunner.a(bt.a(this));
    }

    public void initWithPreview(TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        LiteavLog.i(TAG, "initWithPreview videoView = " + tXPreviewParam.videoView);
        this.mSequenceTaskRunner.a(by.a(this, tXPreviewParam));
    }

    public void joinVideo(int i, String str) {
        LiteavLog.i(TAG, "joinVideo videoCompressed " + i + " videoOutputPath = " + str);
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mVideoOutputPath = str;
            this.mSequenceTaskRunner.a(bs.a(this, str, i));
            return;
        }
        LiteavLog.e(TAG, "joinVideo is not support on smart version");
        notifyJoinComplete(-5, "licence verify failed");
    }

    public void pausePlay() {
        LiteavLog.i(TAG, "pausePlay");
        com.tencent.liteav.base.util.j jVar = this.mSequenceTaskRunner;
        TXVideoEditer tXVideoEditer = this.mTXVideoEditer;
        tXVideoEditer.getClass();
        jVar.a(cb.a(tXVideoEditer));
    }

    public void resumePlay() {
        LiteavLog.i(TAG, "resumePlay");
        com.tencent.liteav.base.util.j jVar = this.mSequenceTaskRunner;
        TXVideoEditer tXVideoEditer = this.mTXVideoEditer;
        tXVideoEditer.getClass();
        jVar.a(cc.a(tXVideoEditer));
    }

    public void setNeedEdit(boolean z) {
        LiteavLog.i(TAG, "setNeedEdit = ".concat(String.valueOf(z)));
        this.mSequenceTaskRunner.a(bx.a(this, z));
    }

    public void setProfile(int i) {
        LiteavLog.i(TAG, "setProfile profile ".concat(String.valueOf(i)));
        this.mSequenceTaskRunner.a(cf.a(this, i));
    }

    public void setRecordPath(String str) {
        LiteavLog.i(TAG, "setRecordPath recordPath = ".concat(String.valueOf(str)));
    }

    public void setSplitScreenList(List<TXVideoEditConstants.TXAbsoluteRect> list, int i, int i2) {
        LiteavLog.i(TAG, "setSplitScreenList canvasWidth = " + i + " canvasHeight = " + i2);
        this.mSequenceTaskRunner.a(bu.a(this, list, i, i2));
    }

    public void setTXVideoPreviewListener(TXVideoPreviewListener tXVideoPreviewListener) {
        LiteavLog.i(TAG, "setTXVideoPreviewListener");
        this.mSequenceTaskRunner.a(bz.a(this, tXVideoPreviewListener));
    }

    public void setVideoJoinerListener(TXVideoJoinerListener tXVideoJoinerListener) {
        LiteavLog.i(TAG, "setVideoJoinerListener");
        this.mSequenceTaskRunner.a(ce.a(this, tXVideoJoinerListener));
    }

    public int setVideoPathList(List<String> list) {
        for (String str : list) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            int isMediaSourceValid = TXVideoEditer.isMediaSourceValid(str);
            if (isMediaSourceValid != 0) {
                LiteavLog.i(TAG, "setVideoPathList " + str + " is illegal." + isMediaSourceValid);
                return isMediaSourceValid;
            }
        }
        this.mSequenceTaskRunner.a(br.a(this, list));
        return 0;
    }

    public void setVideoVolumes(List<Float> list) {
        LiteavLog.i(TAG, "setVideoVolumes");
        float[] fArr = new float[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.mSequenceTaskRunner.a(bv.a(this, fArr));
                return;
            } else {
                fArr[i2] = list.get(i2).floatValue();
                i = i2 + 1;
            }
        }
    }

    public void splitJoinVideo(int i, String str) {
        LiteavLog.i(TAG, "splitJoinVideo video Compressed = " + i + " videoOutputPath = " + str);
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "splitJoinVideo is not support on smart version");
            notifyJoinComplete(-5, "licence verify failed");
            return;
        }
        LiteavLog.i(TAG, "splitJoinVideo videoCompressed = " + i + " videoOutputPath = " + str);
        this.mVideoOutputPath = str;
        this.mSequenceTaskRunner.a(bw.a(this, i, str));
        UGCDataReport.reportDAU(1031);
    }

    public void startPlay() {
        LiteavLog.i(TAG, "startPlay");
        this.mSequenceTaskRunner.a(ca.a(this));
    }

    public void stopPlay() {
        LiteavLog.i(TAG, "stopPlay");
        com.tencent.liteav.base.util.j jVar = this.mSequenceTaskRunner;
        TXVideoEditer tXVideoEditer = this.mTXVideoEditer;
        tXVideoEditer.getClass();
        jVar.a(cd.a(tXVideoEditer));
    }
}
