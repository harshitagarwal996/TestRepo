package com.example.harshit.hoppzatest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RatingBarFragment.OnRatingBarFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RatingBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RatingBarFragment extends DialogFragment implements RatingBar.OnRatingBarChangeListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RatingBar ratingBar;
    Button rating4Button;
    Button rating3Button;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnRatingBarFragmentInteractionListener mListener;

    public RatingBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RatingBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RatingBarFragment newInstance() {
        RatingBarFragment fragment = new RatingBarFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_rating_bar, container, false);
        ratingBar= (RatingBar) inflate.findViewById(R.id.ratingBar1);
        ratingBar.setOnRatingBarChangeListener(this);
        rating3Button=(Button)inflate.findViewById(R.id.rating_3_button);
        rating3Button.setOnClickListener(this);
        rating4Button=(Button)inflate.findViewById(R.id.rating4_button);
        rating4Button.setOnClickListener(this);
        return inflate;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(View ratingBar, float rating, boolean fromUser) {
        if (mListener != null) {
            mListener.OnRatingBarFragmentInteraction(ratingBar,rating,fromUser);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRatingBarFragmentInteractionListener) {
            mListener = (OnRatingBarFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRatingBarFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        onButtonPressed(ratingBar,rating,fromUser);
    }

    @Override
    public void onClick(View v) {
        onButtonPressed(v,0,true);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnRatingBarFragmentInteractionListener {
        // TODO: Update argument type and name
        void OnRatingBarFragmentInteraction(View view, float rating, boolean fromUser);
    }
}
