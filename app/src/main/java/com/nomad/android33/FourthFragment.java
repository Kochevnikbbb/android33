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


public class FourthFragment extends Fragment {

    private Button button4;
    private EditText editTextName4, editTextSurname4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button4 = view.findViewById(R.id.btn4);
        editTextName4 = view.findViewById(R.id.ed_name4);
        editTextSurname4 = view.findViewById(R.id.ed_surname4);

        button4.setOnClickListener(view1 -> {
            MainActivity activity = (MainActivity) requireActivity();
            MainActivity.isMainFragment = false;
            Bundle bundle = new Bundle();
            Fragment fragment = new FifthFragment();
            if (editTextName4.getText() != null) {
                bundle.putString(THEME, editTextName4.getText().toString());
            }
            if (editTextSurname4.getText() != null) {
                bundle.putString(MASSAGE, editTextSurname4.getText().toString());
            }
            fragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String theme = bundle.getString(THEME);
            editTextName4.setText(theme);
        }
        if (bundle != null) {
            String theme = bundle.getString(MASSAGE);
            editTextSurname4.setText(theme);
        }

    }
}

