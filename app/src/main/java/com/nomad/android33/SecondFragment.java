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


public class SecondFragment extends Fragment {
    private Button button2;
    private EditText editTextName2, editTextSurname2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button2 = view.findViewById(R.id.btn2);
        editTextName2 = view.findViewById(R.id.ed_name2);
        editTextSurname2 = view.findViewById(R.id.ed_surname2);

        button2.setOnClickListener(view1 -> {
            MainActivity activity = (MainActivity) requireActivity();
            MainActivity.isMainFragment = false;
            Bundle bundle = new Bundle();
            Fragment fragment = new ThirdFragment();
            if (editTextName2.getText()!=null){
                bundle.putString(THEME,editTextName2.getText().toString());
            }
            if (editTextSurname2.getText()!=null){
                bundle.putString(MASSAGE,editTextSurname2.getText().toString());
            }
            fragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String theme = bundle.getString(THEME);
            editTextName2.setText(theme);
        }
        if (bundle != null) {
            String theme = bundle.getString(MASSAGE);
            editTextSurname2.setText(theme);
        }

    }
}