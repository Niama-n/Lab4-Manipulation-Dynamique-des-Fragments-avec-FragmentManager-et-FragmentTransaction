package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    
    private Button firstFragmentButton, secondFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstFragmentButton = findViewById(R.id.btnFragment1);
        secondFragmentButton = findViewById(R.id.btnFragment2);


        if (savedInstanceState == null) {
            displayFragment(new FragmentOne(), false);
        }


        firstFragmentButton.setOnClickListener(v -> displayFragment(new FragmentOne(), true));
        

        secondFragmentButton.setOnClickListener(v -> displayFragment(new FragmentTwo(), true));
    }

    /**
     * Generic method to replace fragments in the container.
     * @param fragmentToDisplay The new fragment to display.
     * @param shouldAddToStack Whether to add this transaction to the back stack.
     */
    private void displayFragment(Fragment fragmentToDisplay, boolean shouldAddToStack) {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, fragmentToDisplay);

        if (shouldAddToStack) {
            fragTransaction.addToBackStack(null);
        }


        fragTransaction.commit();
    }
}
