package android.fabio.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.fabio.aprendaingles.R;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{
    private ImageButton btnCao, btnGato, btnLeao, btnMacaco, btnOvelha, btnVaca;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private MediaPlayer mediaPlayer;

    private String mParam1;
    private String mParam2;

    public BichosFragment() {
        // Required empty public constructor
    }

    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);

        btnCao    = view.findViewById(R.id.btnCao);
        btnGato   = view.findViewById(R.id.btnGato);
        btnLeao   = view.findViewById(R.id.btnLeao);
        btnMacaco = view.findViewById(R.id.btnMacaco);
        btnOvelha = view.findViewById(R.id.btnOvelha);
        btnVaca   = view.findViewById(R.id.btnVaca);

        btnCao.setOnClickListener(this);
        btnGato.setOnClickListener(this);
        btnOvelha.setOnClickListener(this);
        btnMacaco.setOnClickListener(this);
        btnVaca.setOnClickListener(this);
        btnLeao.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnCao) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.dog);
            playSound();
        } else if (id == R.id.btnGato) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.cat);
            playSound();
        } else if (id == R.id.btnLeao) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.lion);
            playSound();
        } else if (id == R.id.btnOvelha) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.sheep);
            playSound();
        } else if (id == R.id.btnMacaco) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.monkey);
            playSound();
        } else if (id == R.id.btnVaca) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.cow);
            playSound();
        }
    }

    public void playSound(){
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}