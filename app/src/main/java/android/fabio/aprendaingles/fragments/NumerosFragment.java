package android.fabio.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.fabio.aprendaingles.R;
import android.widget.ImageButton;

public class NumerosFragment extends Fragment implements View.OnClickListener {
    private ImageButton btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix;
    private MediaPlayer mediaPlayer;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
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
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);
        btnOne = view.findViewById(R.id.btnA);
        btnTwo = view.findViewById(R.id.btnE);
        btnThree = view.findViewById(R.id.btnI);
        btnFour = view.findViewById(R.id.btnO);
        btnFive = view.findViewById(R.id.btnU);
        btnSix = view.findViewById(R.id.btnPlus);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnA) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.one);
            playSound();
        } else if (id == R.id.btnE) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.two);
            playSound();
        }else if (id == R.id.btnI) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.three);
            playSound();
        }else if (id == R.id.btnO) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.four);
            playSound();
        }else if (id == R.id.btnU) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.five);
            playSound();
        }else if (id == R.id.btnPlus) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.six);
            playSound();
        }
    }

    public void playSound() {
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
