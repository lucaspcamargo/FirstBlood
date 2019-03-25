package br.eng.camargo.firstblood;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

public class BloodAdminReceiver extends DeviceAdminReceiver {



    public BloodAdminReceiver() {
        super();
    }

    @Override
    public void onLockTaskModeEntering(Context context, Intent intent, String pkg) {
        super.onLockTaskModeEntering(context, intent, pkg);
    }

    @Override
    public void onLockTaskModeExiting(Context context, Intent intent) {
        super.onLockTaskModeExiting(context, intent);
    }


}
