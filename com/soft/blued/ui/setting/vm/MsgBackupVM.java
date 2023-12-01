package com.soft.blued.ui.setting.vm;

import android.util.Log;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.db.BluedBaseDataHelper;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.txcloud.TxCloud;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.R;
import com.soft.blued.ui.setting.model.MsgBackInfo;
import com.soft.blued.ui.setting.state.MsgBackupAction;
import com.soft.blued.ui.setting.state.MsgBackupState;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM.class */
public final class MsgBackupVM extends MVIBaseViewModel<MsgBackupState, MsgBackupAction> {
    private MsgBackInfo d;

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f33654a = new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c());
    private final String b = "msg_backup_info";

    /* renamed from: c  reason: collision with root package name */
    private final String f33655c = AppInfo.d().getCacheDir().getAbsolutePath();
    private String e = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.setting.vm.MsgBackupVM.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void a() {
        MsgBackupManager.getInstance().reserveMsgDb(BluedBaseDataHelper.a().b(), null, new MsgBackupManager.ReserveListener() { // from class: com.soft.blued.ui.setting.vm.MsgBackupVM$backup$1
            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onError(String message) {
                Intrinsics.e(message, "message");
                MsgBackupVM.this.showToast(message);
                BluedStructureExtKt.a(MsgBackupVM.this, new MviEvent.LoadFinished(false, false, 3, null));
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onReserveSucceed(String path) {
                Intrinsics.e(path, "path");
                File file = new File(path);
                MsgBackupVM.this.e = path;
                String absolutePath = new File(AppInfo.d().getExternalFilesDir("blued"), file.getName()).getAbsolutePath();
                Log.d("getExternalFilesDir:", absolutePath);
                MsgBackupVM.this.a(file, absolutePath);
                if (!BluedApiProxy.f10622a) {
                    if (file.length() / 1048576 >= 150) {
                        BluedStructureExtKt.a(MsgBackupVM.this, MsgBackupAction.MsgBackupEvent.FileLimitDialog.f33638a);
                        return;
                    } else {
                        MsgBackupVM.this.a(path);
                        return;
                    }
                }
                MsgBackupVM msgBackupVM = MsgBackupVM.this;
                msgBackupVM.showToast(AppInfo.d().getString(R.string.msg_backup_complete) + ':' + ((Object) absolutePath));
                BluedStructureExtKt.a(MsgBackupVM.this, new MviEvent.LoadFinished(false, false, 3, null));
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onRestoreSucceed() {
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onStart() {
                BluedStructureExtKt.a(MsgBackupVM.this, MviEvent.LoadStarted.f10685a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MsgBackupVM$uploadDB$1(this, str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(File file, String str) {
        if (file == null || !file.exists() || str == null) {
            return false;
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel.transferTo(0L, channel.size(), channel2);
            try {
                channel.close();
                channel2.close();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return true;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return false;
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private final void b() {
        if (BluedApiProxy.f10622a) {
            c();
        } else if (this.d != null) {
            BluedStructureExtKt.a(this, MviEvent.LoadStarted.f10685a);
            BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MsgBackupVM$downAndRestore$1(this, null), 3, null);
        } else {
            String string = AppInfo.d().getString(R.string.msg_restore_no_file);
            Intrinsics.c(string, "getAppContext().getStrin…ring.msg_restore_no_file)");
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        MsgBackupManager.getInstance().restoreMsgDb(str, new MsgBackupManager.ReserveListener() { // from class: com.soft.blued.ui.setting.vm.MsgBackupVM$restoreDB$1
            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onError(String message) {
                Intrinsics.e(message, "message");
                MsgBackupVM.this.showToast(message);
                EventTrackSettings.a(SettingsProtos.Event.MINE_RECOVERY_RECORD_FAIL);
                BluedStructureExtKt.a(MsgBackupVM.this, new MviEvent.LoadFinished(false, false, 3, null));
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onReserveSucceed(String path) {
                Intrinsics.e(path, "path");
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onRestoreSucceed() {
                EventTrackSettings.a(SettingsProtos.Event.MINE_RECOVERY_RECORD_SUCCESS);
                MsgBackupVM msgBackupVM = MsgBackupVM.this;
                String string = AppInfo.d().getString(R.string.msg_backup_complete);
                Intrinsics.c(string, "getAppContext().getStrin…ring.msg_backup_complete)");
                msgBackupVM.showToast(string);
                BluedStructureExtKt.a(MsgBackupVM.this, new MviEvent.LoadFinished(false, false, 3, null));
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onStart() {
            }
        });
    }

    private final void c() {
        BluedStructureExtKt.a(this, MviEvent.LoadStarted.f10685a);
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MsgBackupVM$RestoreFromLocal$1(this, null), 3, null);
    }

    private final void d() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MsgBackupVM$getBackupInfo$1(this, null), 3, null);
    }

    private final void delete() {
        BluedStructureExtKt.a(this, MviEvent.LoadStarted.f10685a);
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MsgBackupVM$delete$1(this, null), 3, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(MsgBackupAction action) {
        Intrinsics.e(action, "action");
        if (Intrinsics.a(action, MsgBackupAction.GetBackupInfo.f33637a)) {
            d();
        } else if (Intrinsics.a(action, MsgBackupAction.Backup.f33634a)) {
            a();
        } else if (Intrinsics.a(action, MsgBackupAction.Delete.f33635a)) {
            delete();
        } else if (Intrinsics.a(action, MsgBackupAction.DownloadAndRestore.f33636a)) {
            b();
        } else if (Intrinsics.a(action, MsgBackupAction.UploadFile.f33639a)) {
            a(this.e);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        TxCloud.f10836a.c();
    }
}
