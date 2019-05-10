package com.lecboxyazilim.lecbox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class izmir_to_manisa extends Fragment {
    public static izmir_to_manisa newInstance() {
        return new izmir_to_manisa();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_izmir_to_manisa,container,false);
        return rootView;
    }
}
