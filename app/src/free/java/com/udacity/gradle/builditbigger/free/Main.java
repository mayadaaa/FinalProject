package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.jokes_viewer.JokeViewerActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.AsyncClass;
import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.R;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Main extends Fragment {

    public Main() {
    }


    public String loadedJoke = null;
    public boolean testFlag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_free, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);

        // Set onClickListener for the button
        Button button = (Button) root.findViewById(R.id.joke_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getJoke();
            }
        });




        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    public void getJoke(){
        new AsyncClass().execute((Runnable) this);
    }

    public void launchDisplayJokeActivity(){
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, JokeViewerActivity.class);
            intent.putExtra(context.getString(R.string.jokeEnvelope), loadedJoke);
            //Toast.makeText(context, loadedJoke, Toast.LENGTH_LONG).show();
            context.startActivity(intent);
        }
    }

}