package com.better.rntingrrd.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.better.rntingrrd.R;
import com.better.rntingrrd.RntingApplication;
import com.better.rntingrrd.di.component.RntingComponent;

import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;

/**
 * Created by xiashuai on 2016/7/17.
 * Connection smay1227@163.com.
 */
public abstract class BaseActivity extends AppCompatActivity {

    SpotsDialog spotDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        setupActivityComponent();
        initUiAndListener();
    }

    protected RntingComponent getApplicationComponent() {
        return ((RntingApplication) getApplication()).getApplicationComponent();
    }

    protected void showSpotDialog(){
        if (spotDialog == null){
            spotDialog = new SpotsDialog(this, R.style.Custom);
        }
        spotDialog.setCancelable(false);
        spotDialog.show();
    }

    protected void dismissSpotDialog(){
        if(spotDialog != null){
            spotDialog.dismiss();
            spotDialog = null;
        }
    }

    protected void showToast(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    public abstract int getLayout();

    public abstract void setupActivityComponent();

    public abstract void initUiAndListener();

}
