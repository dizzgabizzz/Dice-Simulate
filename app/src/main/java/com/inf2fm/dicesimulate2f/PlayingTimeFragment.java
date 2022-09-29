package com.inf2fm.dicesimulate2f;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

class PlayingTimeFragment extends Fragment {

    private Chronometer mChorometer;


     @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View mView = inflater.inflate(R.layout.fragment_playing_time, container, false);
         mChorometer = mView.findViewById(R.id.chronometer_time);
         long value = getArguments().getLong("message");
         long deltaTime = SystemClock.elapsedRealtime()-value;
         if(deltaTime>=1000 && value>0){
             mChorometer.setBase(value);
             mChorometer.start();
         }

        return mView;
         //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public PlayingTimeFragment() {
    }
}
