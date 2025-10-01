package com.example.agalcha_emotilog;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ThirdFragment
 * This screen shows a summary of all emotions: how many times each has been logged.

 * Why this design:
 *   Instead of showing a graph or chart, a simple list of counts was used to keep things basic.
 *   Uses LogStorage to gather totals and display them with a ListView.

 * Notes / Issues:
 *   The summary clears when the app restarts since there’s no database yet.
 */

public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.listSummary);

        HashMap<String, Integer> summary = LogStorage.getSummary();
        ArrayList<String> items = new ArrayList<>();

        for (String emotion : summary.keySet()) {
            items.add(emotion + ": " + summary.get(emotion));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                items
        );
        listView.setAdapter(adapter);
    }
}
