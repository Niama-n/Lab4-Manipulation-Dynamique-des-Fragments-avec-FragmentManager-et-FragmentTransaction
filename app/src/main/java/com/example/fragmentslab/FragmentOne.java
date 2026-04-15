package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FragmentOne extends Fragment {

    private TextView welcomeText;
    private Button helloBtn;


    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        welcomeText = view.findViewById(R.id.textOne);
        helloBtn = view.findViewById(R.id.btnHello);

        helloBtn.setOnClickListener(v -> {
            welcomeText.setText("Bonjour de NIAMA NAFTAOUI \n Depuis Fragment 1!");
        });
    }
}
