package me.aerovulpe.watportal.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.aerovulpe.watportal.R;
import me.aerovulpe.watportal.Utility;
import me.aerovulpe.watportal.fragments.OutletListFragment;

/**
 * Created by Aaron on 02/01/2015.
 */
public class OutletAdapter extends CursorAdapter {


    public OutletAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view = LayoutInflater.from(context).inflate(R.layout.outlet_list_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final ViewHolder holder = (ViewHolder) view.getTag();

        String name = cursor.getString(OutletListFragment.COL_OUTLET_NAME);
        String building = Utility.getBuildingNameFromCode(context,
                cursor.getString(OutletListFragment.COL_BUILDING));
        String logoSrc = cursor.getString(OutletListFragment.COL_LOGO);
        int isOpen = cursor.getInt(OutletListFragment.COL_IS_OPEN_NOW);

        holder.nameView.setText(name);
        holder.buildingView.setText(building);
        Picasso.with(context).load(logoSrc)
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.iconView);
        holder.isOpenView.setText((isOpen == 1)? "is open" : "is closed");

    }

    public static class ViewHolder {
        public final ImageView iconView;
        public final TextView nameView;
        public final TextView buildingView;
        public final TextView isOpenView;

        public ViewHolder(View view) {
            iconView = (ImageView) view.findViewById(R.id.thumbnail_image);
            nameView = (TextView) view.findViewById(R.id.name_text);
            buildingView = (TextView) view.findViewById(R.id.building_text);
            isOpenView = (TextView) view.findViewById(R.id.is_open_text);
        }
    }
}
