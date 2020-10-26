package com.scorp.loftcoin;

import android.app.Application;
import android.os.StrictMode;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.scorp.loftcoin.ui.main.MainActivity;
import com.scorp.loftcoin.util.DebugTree;

import timber.log.Timber;

public class LoftApp extends Application {

    public BaseComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG){
            StrictMode.enableDefaults();
            Timber.plant(new DebugTree());
        }
        component = DaggerAppComponent.builder()
                .application(this)
                .build();
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(
                instanceIdResult -> Timber.d("fcm: %s", instanceIdResult.getToken())
        );
    }

    public BaseComponent getComponent(){
        return component;
    }
}
