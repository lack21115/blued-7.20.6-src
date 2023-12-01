package com.soft.blued.ui.msg.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.soft.blued.R;
import com.soft.blued.ui.msg.controller.tools.MediaRecordHelper;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import skin.support.widget.SkinCompatTextView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/RecordButton.class */
public class RecordButton extends SkinCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    public int f32319a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32320c;
    private Long d;
    private boolean e;
    private Dialog f;
    private String g;
    private ImageView h;
    private ImageView i;
    private TextView j;
    private int k;
    private MediaRecordHelper l;
    private TextView m;
    private OnRecordListener n;
    private long o;
    private Bitmap p;
    private PowerManager.WakeLock q;
    private MediaRecordHelper.OnRecordingListener r;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/RecordButton$OnRecordListener.class */
    public interface OnRecordListener {
        BaseFragment a();

        void a(int i);

        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);
    }

    public RecordButton(Context context) {
        super(context);
        this.f32319a = -1;
        this.b = "RecordButton";
        this.f32320c = 1000;
        this.d = 0L;
        this.e = true;
        this.k = 0;
        a(context);
    }

    public RecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32319a = -1;
        this.b = "RecordButton";
        this.f32320c = 1000;
        this.d = 0L;
        this.e = true;
        this.k = 0;
        a(context);
    }

    private void a() {
        this.q.acquire();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        AppMethods.d(i);
    }

    private void a(Context context) {
        this.q = ((PowerManager) context.getSystemService("power")).newWakeLock(26, "RecordButton");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.q.isHeld()) {
            this.q.release();
        }
    }

    private void c() {
        MediaRecordHelper mediaRecordHelper = this.l;
        if (mediaRecordHelper != null) {
            try {
                mediaRecordHelper.a();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            if (this.r == null) {
                MediaRecordHelper mediaRecordHelper2 = this.l;
                MediaRecordHelper.OnRecordingListener onRecordingListener = new MediaRecordHelper.OnRecordingListener() { // from class: com.soft.blued.ui.msg.customview.RecordButton.1
                    @Override // com.soft.blued.ui.msg.controller.tools.MediaRecordHelper.OnRecordingListener
                    public void a() {
                        RecordButton.this.a((int) R.string.record_by_long_click);
                    }

                    @Override // com.soft.blued.ui.msg.controller.tools.MediaRecordHelper.OnRecordingListener
                    public void a(int i, int i2) {
                        if (RecordButton.this.n == null || RecordButton.this.n.a() == null || !RecordButton.this.n.a().isAdded()) {
                            return;
                        }
                        RecordButton.this.k = i;
                        if (RecordButton.this.j != null) {
                            TextView textView = RecordButton.this.j;
                            textView.setText(i + "''");
                        }
                        if (i2 <= 40) {
                            RecordButton.this.i.setImageBitmap(null);
                        } else if (i2 >= 120) {
                            RecordButton.this.i.setImageBitmap(RecordButton.this.p);
                        } else {
                            int height = ((120 - i2) * RecordButton.this.p.getHeight()) / 120;
                            RecordButton.this.i.setImageBitmap(Bitmap.createBitmap(RecordButton.this.p, 0, height, RecordButton.this.p.getWidth(), RecordButton.this.p.getHeight() - height));
                        }
                        if (RecordButton.this.f32319a == -1 || RecordButton.this.f32319a - i > 10) {
                            RecordButton.this.j.setTextColor(Color.GRAY);
                        } else {
                            RecordButton.this.j.setTextColor(-65536);
                        }
                        if (!RecordButton.this.l.c()) {
                            RecordButton.this.h();
                        }
                        if (RecordButton.this.f32319a == -1 || i < RecordButton.this.f32319a) {
                            return;
                        }
                        RecordButton.this.f();
                    }

                    @Override // com.soft.blued.ui.msg.controller.tools.MediaRecordHelper.OnRecordingListener
                    public void b() {
                        RecordButton.this.a((int) R.string.record_too_ofen);
                        RecordButton.this.f.dismiss();
                        ThreadManager.a().a(new ThreadExecutor("RecordStartRecord") { // from class: com.soft.blued.ui.msg.customview.RecordButton.1.1
                            @Override // com.blued.android.framework.pool.ThreadExecutor
                            public void execute() {
                                try {
                                    Thread.sleep(500L);
                                } catch (InterruptedException e3) {
                                    e3.printStackTrace();
                                }
                                if (RecordButton.this.f.isShowing()) {
                                    RecordButton.this.f.dismiss();
                                }
                            }
                        });
                    }
                };
                this.r = onRecordingListener;
                mediaRecordHelper2.a(onRecordingListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        MediaRecordHelper mediaRecordHelper = this.l;
        if (mediaRecordHelper != null) {
            mediaRecordHelper.a(this.k == 0);
        }
    }

    private void e() {
        if (this.f == null) {
            this.d = Long.valueOf(System.currentTimeMillis());
            Dialog dialog = new Dialog(getContext(), R.style.style_mic_record);
            this.f = dialog;
            dialog.setContentView(R.layout.dialog_mic_record);
            this.h = (ImageView) this.f.findViewById(R.id.iv_mic1);
            this.i = (ImageView) this.f.findViewById(R.id.iv_mic2);
            this.j = (TextView) this.f.findViewById(R.id.tv_recordTime);
            this.m = (TextView) this.f.findViewById(R.id.tv_remind);
            this.p = BitmapFactory.decodeResource(getResources(), R.drawable.mic_2);
            this.f.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.msg.customview.RecordButton.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    RecordButton.this.b();
                    RecordButton.this.d();
                }
            });
        } else {
            this.d = Long.valueOf(System.currentTimeMillis());
            this.k = 0;
            TextView textView = this.j;
            textView.setText(this.k + "''");
            this.h.setImageResource(R.drawable.mic_1);
        }
        c();
        this.f.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i;
        if (this.k == -1) {
            return;
        }
        d();
        this.f.dismiss();
        if (System.currentTimeMillis() - this.d.longValue() < 1000) {
            a(R.string.record_time_is_too_short);
            g();
            return;
        }
        if (this.e) {
            h();
        } else {
            OnRecordListener onRecordListener = this.n;
            if (onRecordListener != null && (i = this.k) != 0) {
                onRecordListener.a(i);
            } else if (this.k == 0) {
                g();
            }
        }
        this.k = -1;
    }

    private void g() {
        if (StringUtils.d(this.g)) {
            return;
        }
        File file = new File(this.g);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.l == null) {
            return;
        }
        this.f.dismiss();
        a(R.string.record_cancel_record);
        File file = new File(this.g);
        if (file.exists()) {
            file.delete();
        }
        this.k = -1;
    }

    public int getRecordTime() {
        return this.k;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (AudioChannelManager.j().n()) {
                a(2131893031);
            } else {
                if (motionEvent.getY() < 0.0f) {
                    Logger.b("RecordButton", "onTouchEvent-->向上移动");
                    if (this.f != null && this.f.isShowing()) {
                        this.m.setText(R.string.record_cancel_ok);
                        this.h.setImageResource(R.drawable.mic_3_cancel);
                        this.i.setVisibility(4);
                    }
                    this.e = true;
                } else {
                    Logger.b("RecordButton", "onTouchEvent-->向下移动.");
                    if (this.f != null && this.f.isShowing()) {
                        this.m.setText(R.string.record_cancel_remind);
                        this.h.setImageResource(R.drawable.mic_1);
                        if (this.i.getVisibility() == 4) {
                            this.i.setVisibility(0);
                        }
                    }
                    this.e = false;
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    Logger.b("RecordButton", "onTouchEvent-->按下");
                    if (System.currentTimeMillis() - this.o < 500) {
                        a(R.string.record_too_ofen);
                        this.d = -1L;
                        return true;
                    }
                    a();
                    if (this.n != null) {
                        this.n.a(motionEvent);
                    }
                    e();
                } else if (action == 1 || action == 3) {
                    Logger.b("RecordButton", "onTouchEvent-->抬起");
                    b();
                    this.o = System.currentTimeMillis();
                    if (this.d.longValue() == -1) {
                        return true;
                    }
                    f();
                    if (this.n != null) {
                        this.n.b(motionEvent);
                    }
                }
            }
        } catch (Exception e) {
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnRecordListener(OnRecordListener onRecordListener) {
        this.n = onRecordListener;
    }

    public void setRecordPath(String str) {
        this.g = str;
        File file = new File(str);
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        MediaRecordHelper mediaRecordHelper = this.l;
        if (mediaRecordHelper == null) {
            this.l = new MediaRecordHelper(str);
        } else {
            mediaRecordHelper.a(str);
        }
    }
}
