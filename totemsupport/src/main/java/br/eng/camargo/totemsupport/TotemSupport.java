package br.eng.camargo.totemsupport;

import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;

public class TotemSupport extends DeviceAdminReceiver {


    enum Status
    {
        S_UNITIALIZED,
        S_INIT_ERROR_NOT_DEVICE_ADMIN,
        S_INIT_ERROR_NOT_DEVICE_OWNER,
        S_INIT_DONE,
        S_LOCK_DONE
    }

    public TotemSupport(Activity activity, String deviceOwnerPackage, String[] extraLockTaskPackages)
    {
        super();

        mActivity = activity;
        mOwner = deviceOwnerPackage;
        mExtraPackages = extraLockTaskPackages;

        mStatus = Status.S_UNITIALIZED;

    }

    public Status getStatus()
    {
       return mStatus;
    }


    @Override
    public void onLockTaskModeEntering(Context context, Intent intent, String pkg) {
        super.onLockTaskModeEntering(context, intent, pkg);
        mStatus = Status.S_LOCK_DONE;
    }

    @Override
    public void onLockTaskModeExiting(Context context, Intent intent) {
        super.onLockTaskModeExiting(context, intent);
        mStatus = Status.S_INIT_DONE;
    }

    // parameters
    private String mOwner;
    private String[] mExtraPackages;
    private Activity mActivity;

    // state
    private Status mStatus;
    private DevicePolicyManager mDPM;
}
