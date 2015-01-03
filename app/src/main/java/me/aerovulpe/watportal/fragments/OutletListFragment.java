package me.aerovulpe.watportal.fragments;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import me.aerovulpe.watportal.R;
import me.aerovulpe.watportal.adapters.OutletAdapter;
import me.aerovulpe.watportal.data.tables.buildings.BuildingsEntry;
import me.aerovulpe.watportal.data.tables.food.LocationsEntry;

import static me.aerovulpe.watportal.Constants.ARG_SECTION_NUMBER;

/**
 * Created by Aaron on 02/01/2015.
 */
public class OutletListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String LOG_TAG = OutletListFragment.class.getSimpleName();

    private static final int OUTLETS_LOADER = 0;
    ListView mListView;
    OutletAdapter mOutletAdapter;

    private static final String[] OUTLETS_COLUMNS = {
            LocationsEntry.TABLE_NAME + "." + LocationsEntry._ID,
            LocationsEntry.COLUMN_OUTLET_NAME,
            LocationsEntry.COLUMN_BUILDING,
            LocationsEntry.COLUMN_LOGO,
            LocationsEntry.COLUMN_IS_OPEN_NOW
    };

    public static final int COL_OUTLET_NAME = 1;
    public static final int COL_BUILDING = 2;
    public static final int COL_LOGO = 3;
    public static final int COL_IS_OPEN_NOW = 4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOutletAdapter = new OutletAdapter(getActivity(), null, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_outlet_list, container, false);
        mListView = (ListView) rootView.findViewById(R.id.listview_outlets);

        ContentResolver contentResolver = getActivity().getContentResolver();
        Cursor cursor = contentResolver.query(BuildingsEntry.CONTENT_URI,
                null, null, null, null, null);

//        mListView.setAdapter(new SimpleCursorAdapter(getActivity(),
//                android.R.layout.two_line_list_item,
//                cursor,
//                new String[]{BuildingsEntry.COLUMN_BUILDING_NAME, BuildingsEntry.COLUMN_BUILDING_CODE},
//                new int[]{android.R.id.text1, android.R.id.text2},
//                0));
        mListView.setAdapter(mOutletAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(OUTLETS_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(OUTLETS_LOADER, null, this);
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static OutletListFragment newInstance(int sectionNumber) {
        OutletListFragment fragment = new OutletListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), LocationsEntry.CONTENT_URI, OUTLETS_COLUMNS,
                null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mOutletAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mOutletAdapter.swapCursor(null);
    }
}
