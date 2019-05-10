package com.lecboxyazilim.lecbox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class manisa_to_izmir extends Fragment {
    public static manisa_to_izmir newInstnc() {
        return new manisa_to_izmir();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootV = inflater.inflate(R.layout.fragment_manisa_to_izmir,container,false);
        return rootV;
    }
}
