package com.xiaoxinghu.testwebview;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Des:
 * Created by huang on 2019/4/24 0024 17:58
 */
public class AppInfoUtil {
    private static List<AppInfo> mAppInfos;
    private static List<String> mAppNames = Arrays.asList("微信", "短信", "电话", "TIM");

    private static void getAppList(Context context) {
        mAppInfos = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> activities = pm.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo info : activities) {
            String packName = info.activityInfo.packageName;
            if (packName.equals(context.getPackageName())) {
                continue;
            }
            AppInfo mInfo = new AppInfo();
            mInfo.setIco(info.activityInfo.applicationInfo.loadIcon(pm));
            mInfo.setName(info.activityInfo.applicationInfo.loadLabel(pm).toString());
            mInfo.setPackageName(packName);
            // 为应用程序的启动Activity 准备Intent
            Intent launchIntent = new Intent();
            launchIntent.setComponent(new ComponentName(packName, info.activityInfo.name));
            mInfo.setIntent(launchIntent);
            Log.e("-----", info.activityInfo.applicationInfo.loadLabel(pm).toString());
            mAppInfos.add(mInfo);
        }
    }

    /***
     * 获取不同类型的App
     * @param context
     * @param type 0 常用app (微信，电话，短信，QQ)
     *             1 普通App
     */
    public static List<AppInfo> getCateApps(Context context, int type) {
        List<AppInfo> appInfos = new ArrayList<>();
        if (mAppInfos == null) {
            getAppList(context);
        }
        for (AppInfo appInfo : mAppInfos) {
            switch (type) {
                case 0:
                    if (mAppNames.contains(appInfo.getName())) {
                        appInfos.add(appInfo);
                    }
                    break;
                case 1:
                    if (!mAppNames.contains(appInfo.getName())) {
                        appInfos.add(appInfo);
                    }
                    break;
            }
        }
        return appInfos;
    }
}
