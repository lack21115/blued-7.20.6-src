package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.zego.zegoavkit2.ZegoMediaPlayer;
import java.io.File;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRecordDialogFragment.class */
public class LiveRecordDialogFragment extends BaseDialogFragment {
    public static String d = "";
    public Context a;
    public String b = "";
    public String c = "";
    public EventCallback e;
    private TextureView f;
    private TextView g;
    private ZegoMediaPlayer h;
    private boolean i;
    private boolean j;
    private boolean k;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRecordDialogFragment$EventCallback.class */
    public interface EventCallback {
        void a(String str, String str2);

        void a(String str, String str2, String str3);
    }

    private void e() {
        if (getArguments() != null) {
            this.b = getArguments().getString("videopath");
        }
        d = "";
    }

    public Bitmap a(String str) {
        try {
            if (new File(str).exists()) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                this.c = BitmapUtils.a(frameAtTime, false);
                return frameAtTime;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(Context context) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.a(context.getResources().getString(R.string.live_record_file_title)).b(context.getResources().getString(R.string.live_record_file_content)).a(context.getResources().getString(R.string.live_record_confirm), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_CLOSE_CANCEL_CLICK, LiveRoomManager.a().e());
                LiveRecordDialogFragment.this.d();
            }
        }).b(context.getResources().getString(R.string.live_record_cancel), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
            }
        }).a(false).b(true).h(context.getResources().getColor(R.color.syc_dark_BABABA)).a((DialogInterface.OnDismissListener) null).a(0);
        builder.a().show();
    }

    public void a(EventCallback eventCallback) {
        this.e = eventCallback;
    }

    public void d() {
        File file = new File(this.b);
        if (file.exists()) {
            file.delete();
        }
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        int i = AppInfo.m;
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_record_screen, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, i));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = i;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - i;
        dialog.onWindowAttributesChanged(attributes);
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i("xpm", "videopath:" + this.b);
        Log.i("xpm", "savePath:" + d);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_record_screen, viewGroup);
        this.f = (TextureView) inflate.findViewById(R.id.texture_view);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_pic);
        imageView.setImageBitmap(a(this.b));
        final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_start);
        ZegoMediaPlayer zegoMediaPlayer = new ZegoMediaPlayer();
        this.h = zegoMediaPlayer;
        zegoMediaPlayer.init(0, 1);
        this.h.setProcessInterval(1000L);
        this.h.setViewMode(2);
        this.h.setView(this.f);
        inflate.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_CLOSE_CLICK, LiveRoomManager.a().e());
                if (LiveRecordDialogFragment.this.i) {
                    LiveRecordDialogFragment.this.d();
                    return;
                }
                LiveRecordDialogFragment liveRecordDialogFragment = LiveRecordDialogFragment.this;
                liveRecordDialogFragment.a(liveRecordDialogFragment.getContext());
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_LOOK_CLICK, LiveRoomManager.a().e());
                imageView.setVisibility(8);
                LiveRecordDialogFragment.this.j = true;
                imageView2.setVisibility(8);
                if (LiveRecordDialogFragment.this.k || TextUtils.isEmpty(LiveRecordDialogFragment.this.b)) {
                    LiveRecordDialogFragment.this.h.resume();
                    return;
                }
                LiveRecordDialogFragment.this.k = true;
                LiveRecordDialogFragment.this.h.setVolume(0);
                Log.i("xpm", "videopath:" + LiveRecordDialogFragment.this.b);
                LiveRecordDialogFragment.this.h.start(LiveRecordDialogFragment.this.b, true);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.bt_save);
        this.g = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_SAVE_CLICK, LiveRoomManager.a().e());
                if (LiveRecordDialogFragment.this.i) {
                    return;
                }
                LiveRecordDialogFragment.this.i = true;
                LiveRecordDialogFragment.this.g.setText(R.string.live_record_saved);
                StringBuilder sb = new StringBuilder();
                sb.append(Md5.a(LiveRecordDialogFragment.this.b.toLowerCase().trim() + Math.random()));
                sb.append(".mp4");
                String sb2 = sb.toString();
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                LiveRecordDialogFragment.d = externalStoragePublicDirectory.getAbsolutePath() + File.separator + "blued" + File.separator + sb2;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("videopath:");
                sb3.append(LiveRecordDialogFragment.this.b);
                Log.i("xpm", sb3.toString());
                Log.i("xpm", "savePath:" + LiveRecordDialogFragment.d);
                if (LiveRecordDialogFragment.this.e != null) {
                    LiveRecordDialogFragment.this.e.a(LiveRecordDialogFragment.this.b, LiveRecordDialogFragment.d, sb2);
                }
            }
        });
        inflate.findViewById(R.id.bt_share).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_SHARE_CLICK, LiveRoomManager.a().e());
                if (LiveRecordDialogFragment.this.e != null) {
                    LiveRecordDialogFragment.this.e.a(LiveRecordDialogFragment.this.b, LiveRecordDialogFragment.this.c);
                }
                LiveRecordDialogFragment.this.dismiss();
            }
        });
        inflate.findViewById(R.id.empty_view).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (LiveRecordDialogFragment.this.i) {
                    LiveRecordDialogFragment.this.d();
                    return;
                }
                LiveRecordDialogFragment liveRecordDialogFragment = LiveRecordDialogFragment.this;
                liveRecordDialogFragment.a(liveRecordDialogFragment.getContext());
            }
        });
        EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_SHOW, LiveRoomManager.a().e());
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.j) {
            this.h.stop();
        }
        ZegoMediaPlayer zegoMediaPlayer = this.h;
        if (zegoMediaPlayer != null) {
            zegoMediaPlayer.uninit();
            this.h = null;
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
