package com.soft.blued.ui.setting.state;

import com.blued.android.module.common.base.mvi.UiAction;
import com.blued.android.module.common.base.mvi.UiEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction.class */
public abstract class MsgBackupAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction$Backup.class */
    public static final class Backup extends MsgBackupAction {

        /* renamed from: a  reason: collision with root package name */
        public static final Backup f19943a = new Backup();

        private Backup() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction$Delete.class */
    public static final class Delete extends MsgBackupAction {

        /* renamed from: a  reason: collision with root package name */
        public static final Delete f19944a = new Delete();

        private Delete() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction$DownloadAndRestore.class */
    public static final class DownloadAndRestore extends MsgBackupAction {

        /* renamed from: a  reason: collision with root package name */
        public static final DownloadAndRestore f19945a = new DownloadAndRestore();

        private DownloadAndRestore() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction$GetBackupInfo.class */
    public static final class GetBackupInfo extends MsgBackupAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetBackupInfo f19946a = new GetBackupInfo();

        private GetBackupInfo() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction$MsgBackupEvent.class */
    public static abstract class MsgBackupEvent implements UiEvent {

        @Metadata
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction$MsgBackupEvent$FileLimitDialog.class */
        public static final class FileLimitDialog extends MsgBackupEvent {

            /* renamed from: a  reason: collision with root package name */
            public static final FileLimitDialog f19947a = new FileLimitDialog();

            private FileLimitDialog() {
                super(null);
            }
        }

        private MsgBackupEvent() {
        }

        public /* synthetic */ MsgBackupEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupAction$UploadFile.class */
    public static final class UploadFile extends MsgBackupAction {

        /* renamed from: a  reason: collision with root package name */
        public static final UploadFile f19948a = new UploadFile();

        private UploadFile() {
            super(null);
        }
    }

    private MsgBackupAction() {
    }

    public /* synthetic */ MsgBackupAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
