package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


public class FragmentTwo extends Fragment {

    
    private TextView valueDisplay;
    private SeekBar levelSeekBar;
    private int seekValue = 0;
    private static final String KEY_SEEK_STATE = "current_progress";

    
    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        
        valueDisplay = view.findViewById(R.id.tvValue);
        levelSeekBar = view.findViewById(R.id.seekBar);

        
        if (savedInstanceState != null) {
            seekValue = savedInstanceState.getInt(KEY_SEEK_STATE, 0);
            levelSeekBar.setProgress(seekValue);
            valueDisplay.setText("Value: " + seekValue);
        }

        // Listener to track SeekBar movements
        levelSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override 
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update local variable and UI text
                seekValue = progress;
                valueDisplay.setText("Value: " + progress);
            }
            
            @Override public void onStartTrackingTouch(SeekBar seekBar) {
                
            }
            
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                
            }
        });
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_SEEK_STATE, seekValue);
    }
}
