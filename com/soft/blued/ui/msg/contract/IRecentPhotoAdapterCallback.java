package com.soft.blued.ui.msg.contract;

import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/contract/IRecentPhotoAdapterCallback.class */
public interface IRecentPhotoAdapterCallback {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/contract/IRecentPhotoAdapterCallback$IGetPhotoListCallback.class */
    public interface IGetPhotoListCallback {
        void a(List<MsgRecentPhotoInfo> list);
    }

    List<MsgRecentPhotoInfo> A();

    void B();

    void C();

    void a(IGetPhotoListCallback iGetPhotoListCallback);

    void a(MsgRecentPhotoInfo msgRecentPhotoInfo);

    void b(IGetPhotoListCallback iGetPhotoListCallback);

    void b(MsgRecentPhotoInfo msgRecentPhotoInfo);
}
