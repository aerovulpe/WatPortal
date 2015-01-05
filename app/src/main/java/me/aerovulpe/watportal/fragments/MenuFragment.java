package me.aerovulpe.watportal.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.aerovulpe.watportal.R;
import me.aerovulpe.watportal.Utility;
import me.aerovulpe.watportal.data.tables.food.LocationsEntry;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String LOG_TAG = MenuFragment.class.getSimpleName();

    private static final String OUTLET_NAME_PARAM = "outlet_name";
    private static final int MENU_FRAGMENT_LOADER = 1;

    private String mOutletName;
    private float mPosLat;
    private float mPosLong;

    private OnFragmentInteractionListener mListener;

    private TextView mOutletNameView;
    private TextView mBuildingView;
    private TextView mDateView;
    private TextView mDescriptionView;
    private TextView mNoticeView;
    private TextView mOpeningHoursView;
    private TextView mClosingHoursView;
    private TextView mIsOpenView;
    private Button mShowOnMapView;
    private Button mLunchMenuView;
    private Button mDinnerMenuView;
    private ImageView mOutletLogoView;

    public static MenuFragment newInstance(String param1) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(OUTLET_NAME_PARAM, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mOutletName = getArguments().getString(OUTLET_NAME_PARAM);
            getLoaderManager().initLoader(MENU_FRAGMENT_LOADER, null, this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        mOutletNameView = (TextView) rootView.findViewById(R.id.text_outlet_name);
        mBuildingView = (TextView) rootView.findViewById(R.id.text_building);
        mDateView = (TextView) rootView.findViewById(R.id.text_date);
        mDescriptionView = (TextView) rootView.findViewById(R.id.text_description);
        mNoticeView = (TextView) rootView.findViewById(R.id.text_notice);
        mOpeningHoursView = (TextView) rootView.findViewById(R.id.text_opening_hours);
        mClosingHoursView = (TextView) rootView.findViewById(R.id.text_closing_hours);
        mIsOpenView = (TextView) rootView.findViewById(R.id.text_is_open);
        mShowOnMapView = (Button) rootView.findViewById(R.id.button_show_on_map);
        mLunchMenuView = (Button) rootView.findViewById(R.id.button_lunch_menu);
        mDinnerMenuView = (Button) rootView.findViewById(R.id.button_dinner_menu);
        mOutletLogoView = (ImageView) rootView.findViewById(R.id.image_outlet_logo);

        mShowOnMapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationInMap();
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(MENU_FRAGMENT_LOADER, null, this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (mOutletName == null) return null;
        return new CursorLoader(getActivity(), LocationsEntry.CONTENT_WITH_HOURS_URI, null,
                LocationsEntry.COLUMN_OUTLET_NAME + " = " + "'" + mOutletName + "'" + " AND " +
                        LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK + " = 'monday'", null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        switch (loader.getId()) {
            case MENU_FRAGMENT_LOADER:
                // The asynchronous load is complete and the data
                // is now available for use.
                if (!data.moveToFirst()) return;
                populateViews(data);
                mPosLat = data.getFloat(data.getColumnIndex(LocationsEntry.COLUMN_LATITUDE));
                mPosLong = data.getFloat(data.getColumnIndex(LocationsEntry.COLUMN_LONGITUDE));
                break;
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void populateViews(Cursor data) {

        String name = data.getString(data.getColumnIndex(LocationsEntry.COLUMN_OUTLET_NAME));
        int limit = name.indexOf(" - ");
        name = name.substring(0, (limit > 0 ? limit : name.length()));

        mOutletNameView.setText(name);
        mBuildingView.setText((Utility.getBuildingNameFromCode(getActivity(),
                data.getString(data.getColumnIndex(LocationsEntry.COLUMN_BUILDING)))));
        mDateView.setText("Monday, January 05");
        mIsOpenView.setText((data.getInt(data.getColumnIndex(LocationsEntry.COLUMN_IS_OPEN_NOW)) == 1) ? "Is open" : "Is closed");
        Picasso.with(getActivity()).load(data.getString(data.getColumnIndex(LocationsEntry.COLUMN_LOGO)))
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(mOutletLogoView);
        Utility.setViewText(mDescriptionView, data.getString(data.getColumnIndex(LocationsEntry.COLUMN_DESCRIPTION)));
        Utility.setViewText(mNoticeView, data.getString(data.getColumnIndex(LocationsEntry.COLUMN_NOTICE)));
        Utility.setViewText(mOpeningHoursView, Utility.getFormattedTime(data.getString(data.getColumnIndex
                (LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR))));
        Utility.setViewText(mClosingHoursView, Utility.getFormattedTime(data.getString(data.getColumnIndex
                (LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR))));
    }

    private void openLocationInMap() {

        // Using the URI scheme for showing a location found on a map.  This super-handy
        // intent can is detailed in the "Common Intents" page of Android's developer site:
        // http://developer.android.com/guide/components/intents-common.html#Maps
        if (mPosLat != 0 && mPosLong != 0) {
            Uri geoLocation = Uri.parse("geo:" + mPosLat + "," + mPosLong);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geoLocation);
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.d(LOG_TAG, "Couldn't call " + geoLocation.toString() + ", no receiving apps installed!");
            }
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
