package com.example.agalcha_emotilog;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * FirstFragment
 * This is the main screen where users log their emotions.
 * There are 9 emoji buttons, and each press is saved with a timestamp.
 * There are also buttons to jump to the Logs screen or the Summary screen.

 * Why this design:
 *   Buttons are faster and easier than typing emotions manually.
 *   A helper method (setupButton) keeps the code shorter instead of repeating the same code 9 times.

 * Notes / Issues:
 *   Logs are only stored while the app is running. If the app is closed, the data is lost.
 */

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupButton(view, R.id.btnHappy, "Happy");
        setupButton(view, R.id.btnSad, "Sad");
        setupButton(view, R.id.btnAngry, "Angry");
        setupButton(view, R.id.btnExcited, "Excited");
        setupButton(view, R.id.btnCalm, "Calm");
        setupButton(view, R.id.btnStressed, "Stressed");
        setupButton(view, R.id.btnTired, "Tired");
        setupButton(view, R.id.btnGrateful, "Grateful");
        setupButton(view, R.id.btnCelebration, "Celebration");

        //navigate to logs
        view.findViewById(R.id.btnViewLogs).setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment));

        //navigate to summary
        view.findViewById(R.id.btnSummary).setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment));
    }

    private void setupButton(View view, int id, String emotion) {
        view.findViewById(id).setOnClickListener(v -> {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date());
            LogStorage.addLog(emotion, time);
        });
    }
}
