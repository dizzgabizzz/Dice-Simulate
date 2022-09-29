package com.inf2fm.dicesimulate2f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

class WinFragment extends Fragment {

    private TextView mTextViewWinfragmnet;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_win, container, false);

        mTextViewWinfragmnet = mView.findViewById(R.id.textView_win_fragment);
        long value = getArguments().getLong("message");
        mTextViewWinfragmnet.setText(""+value);
           return mView;

        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    public WinFragment() {
    }
}
