package android.fabio.aprendaingles.fragments;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.fabio.aprendaingles.R;
import android.widget.ImageButton;


public class VogaisFragment extends Fragment implements View.OnClickListener {
    private ImageButton btnA, btnE, btnI, btnO, btnU, btnSurprise;
    private MediaPlayer mediaPlayer;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public VogaisFragment() {
        // Required empty public constructor
    }

    public static VogaisFragment newInstance(String param1, String param2) {
        VogaisFragment fragment = new VogaisFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =   inflater.inflate(R.layout.fragment_vogais, container, false);

        btnA = view.findViewById(R.id.btnA);
        btnE = view.findViewById(R.id.btnE);
        btnI = view.findViewById(R.id.btnI);
        btnO = view.findViewById(R.id.btnO);
        btnU = view.findViewById(R.id.btnU);
        btnSurprise = view.findViewById(R.id.btnSurprise);

        btnA.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnI.setOnClickListener(this);
        btnO.setOnClickListener(this);
        btnU.setOnClickListener(this);
        btnSurprise.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.btnA) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.a);
            playSound();
        } else if (id == R.id.btnE) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.a);
            playSound();
        } else if (id == R.id.btnI) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.a);
            playSound();
        } else if (id == R.id.btnO) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.a);
            playSound();
        } else if (id == R.id.btnU) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.a);
            playSound();
        } else if (id == R.id.btnSurprise) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.radiopirata);
            playSound();
        }
    }

    private void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayerp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}