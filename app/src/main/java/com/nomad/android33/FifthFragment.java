package com.nomad.android33;

import static com.nomad.android33.MainFragment.MASSAGE;
import static com.nomad.android33.MainFragment.THEME;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FifthFragment extends Fragment {
    private Button button5;
    private EditText editTextName5, editTextSurname5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button5 = view.findViewById(R.id.btn5);
        editTextName5 = view.findViewById(R.id.ed_name5);
        editTextSurname5 = view.findViewById(R.id.ed_surname5);

        button5.setOnClickListener(view1 -> {
            MainActivity activity = (MainActivity) requireActivity();
            MainActivity.isMainFragment = false;
            Bundle bundle = new Bundle();
            Fragment fragment = new MainFragment();
            if (editTextName5.getText() != null) {
                bundle.putString(THEME, editTextName5.getText().toString());
            }
            if (editTextSurname5.getText() != null) {
                bundle.putString(MASSAGE, editTextSurname5.getText().toString());
            }
            fragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String theme = bundle.getString(THEME);
            editTextName5.setText(theme);
        }
        if (bundle != null) {
            String theme = bundle.getString(MASSAGE);
            editTextSurname5.setText(theme);
        }

    }
}