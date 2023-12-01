package com.blued.community.ui.subject.fragment;

import android.view.View;
import androidx.fragment.app.FragmentContainerView;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.community.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/FeedSubjectSelectDlgFragment.class */
public final class FeedSubjectSelectDlgFragment extends LiveBaseDialogFragment {
    private View j;
    private FragmentContainerView k;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectSelectDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_feed_subject_select_dlg;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        View findViewById = this.b.findViewById(R.id.feed_subject_select_close);
        this.j = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectSelectDlgFragment$jfi3C7F4-QNYbO71j6TTZqDpKCw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedSubjectSelectDlgFragment.a(FeedSubjectSelectDlgFragment.this, view);
                }
            });
        }
        this.k = (FragmentContainerView) this.b.findViewById(R.id.feed_subject_select_fm_container);
    }
}
