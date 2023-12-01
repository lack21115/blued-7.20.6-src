package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hl.class */
public enum hl {
    UploadSwitch(1),
    UploadFrequency(2),
    ScreenSizeCollectionSwitch(3),
    MacCollectionSwitch(4),
    IMSICollectionSwitch(5),
    AndroidVnCollectionSwitch(6),
    AndroidVcCollectionSwitch(7),
    AndroidIdCollectionSwitch(8),
    DeviceInfoCollectionFrequency(9),
    AppInstallListCollectionSwitch(10),
    AppInstallListCollectionFrequency(11),
    AppActiveListCollectionSwitch(12),
    AppActiveListCollectionFrequency(13),
    BluetoothCollectionSwitch(14),
    BluetoothCollectionFrequency(15),
    LocationCollectionSwitch(16),
    LocationCollectionFrequency(17),
    AccountCollectionSwitch(18),
    AccountCollectionFrequency(19),
    WifiCollectionSwitch(20),
    WifiCollectionFrequency(21),
    CellularCollectionSwitch(22),
    CellularCollectionFrequency(23),
    TopAppCollectionSwitch(24),
    TopAppCollectionFrequency(25),
    DataCollectionSwitch(26),
    OcVersionCheckFrequency(27),
    SyncInfoFrequency(28),
    UploadNotificationInfoFrequency(29),
    UploadNotificationInfoMaxNum(30),
    CollectionNotificationInfoBaseSwitch(31),
    CollectionNotificationInfoAppSwitch(32),
    CollectionNotificationInfoRemovedSwitch(33),
    ForegroundServiceSwitch(34),
    SyncMIIDFrequency(35),
    Upload4GSwitch(36),
    Upload4GFrequency(37),
    Upload3GSwitch(38),
    Upload3GFrequency(39),
    ShieldTypeConfig(40),
    UploadWIFIGeoLocFrequency(41),
    UploadNOWIFIGeoLocFrequency(42),
    BroadcastActionCollectionSwitch(43),
    BroadcastActionCollectionFrequency(44),
    UploadGeoLocSwitch(45),
    ServiceBootMode(46),
    AppPermissionCollectionSwitch(47),
    AppPermissionCollectionFrequency(48),
    WifiDevicesMacCollectionSwitch(49),
    WifiDevicesMacCollectionFrequency(50),
    WifiDevicesMacWifiUnchangedCollectionFrequency(51),
    AggregationSdkMonitorSwitch(52),
    AggregationSdkMonitorFrequency(53),
    AggregationSdkMonitorDepth(54),
    UploadGeoAppLocSwitch(55),
    ThirdPushControlSwitch(56),
    ThirdPushComponentKeyWords(57),
    ThirdPushWhiteList(58),
    XmsfScanWhitelist(59),
    IccidCollectionSwitch(60),
    LimitThridPushStrategyMode(61),
    GlobalPushChannelException(62),
    TinyDataUploadSwitch(63),
    TinyDataUploadFrequency(64),
    GlobalRegionIOSwitch(65),
    GlobalRegionIOWait(66),
    AggregatePushSwitch(67),
    ActivityTSSwitch(68),
    OperatorSwitch(69),
    DeviceIdSwitch(70),
    DeviceBaseInfoCollectionFrequency(71),
    UsageStatsCollectionFrequency(72),
    UsageStatsCollectionWhiteList(73),
    ForceHandleCrashSwitch(74),
    Crash4GUploadSwitch(75),
    Crash4GUploadFrequency(76),
    CrashWIFIUploadFrequency(77),
    EventUploadSwitch(78),
    PerfUploadSwitch(79),
    EventUploadFrequency(80),
    PerfUploadFrequency(81),
    BatteryCollectionSwitch(82),
    BatteryCollectionFrequency(83),
    AwakeInfoUploadWaySwitch(84),
    AwakeAppPingSwitch(85),
    AwakeAppPingFrequency(86),
    StorageCollectionSwitch(87),
    StorageCollectionFrequency(88),
    PopupDialogWhiteList(94),
    PopupDialogContent(95),
    PopupDialogSwitch(96),
    FallDownTimeRange(97),
    AppIsInstalledCollectionSwitch(98),
    AppIsInstalledCollectionFrequency(99),
    AppIsInstalledList(100),
    TopNotificationUpdateFrequency(101),
    TopNotificationUpdatePeriod(102),
    TopNotificationUpdateSwitch(103),
    EventUploadNewSwitch(104),
    ScreenOnOrChargingTinyDataUploadSwitch(105),
    NotificationAutoGroupSwitch(106),
    LatestNotificationNotIntoGroupSwitch(107),
    DCJobMutualSwitch(108),
    NotificationBelongToAppSwitch(109),
    DCJobUploadRepeatedInterval(110),
    LauncherAppListCollectionSwitch(111),
    LauncherAppListCollectionFrequency(112),
    ScenePushForegroundDuration(113),
    ScenePushForegroundDurationLong(114),
    ExceptionMonitorSwitch(115),
    IntelligentHeartbeatSwitchBoolean(116),
    IntelligentHeartbeatDataCollectSwitchBoolean(117),
    IntelligentHeartbeatNATCountInt(118),
    IntelligentHeartbeatUseInMobileNetworkBoolean(119),
    StatDataUploadFrequency(120),
    StatDataUploadNum(121),
    StatDataProcessFrequency(122),
    StatDataSwitch(123),
    StatDataUploadWay(124),
    StatDataDeleteFrequency(125),
    SdkExceptionMonitorSwitch(126),
    ShortHeartbeatEffectivePeriodMsLong(130),
    CollectionDataPluginVersion(1001),
    CollectionPluginDownloadUrl(1002),
    CollectionPluginMd5(1003),
    CollectionPluginForceStop(1004);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f520a;

    hl(int i) {
        this.f520a = i;
    }

    public final int a() {
        return this.f520a;
    }
}
