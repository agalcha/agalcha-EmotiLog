package com.example.agalcha_emotilog;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * SecondFragment
 * This screen shows the list of emotions the user has logged, with timestamps.

 * Why this design:
 *   A simple ListView with an ArrayAdapter is good for this assignment.
 *   It keeps the code small and easy to understand.

 * Notes / Issues:
 *   Right now, there’s no option to delete or edit logs.
 */

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.listLogs);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                LogStorage.getLogs()
        );

        listView.setAdapter(adapter);
    }
}
