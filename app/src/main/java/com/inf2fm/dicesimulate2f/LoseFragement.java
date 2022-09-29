package com.inf2fm.dicesimulate2f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

class LoseFragment extends Fragment {


    private TextView mTextViewLoseFragment;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_win, container, false);

        mTextViewLoseFragment = mView.findViewById(R.id.textView_win_fragment);
        long value = getArguments().getLong("message");
        mTextViewLoseFragment.setText(""+value);
        return mView;


        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    public LoseFragment() {
    }
}
