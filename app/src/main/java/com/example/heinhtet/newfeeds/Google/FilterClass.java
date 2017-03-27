package com.example.heinhtet.newfeeds.Google;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/16/17.
 */
public class FilterClass extends Filter {
    GoogleRecyclerAdapter adapter;

    List<Google> original;
    List<Google> filteredList;

    public FilterClass(GoogleRecyclerAdapter con, List<Google> find) {
       this.original = find;
        this.adapter = con;
        filteredList = new ArrayList<>();
    }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredList.clear();
            final FilterResults results = new FilterResults();

            if (constraint.length() == 0) {
                filteredList.addAll(original);

            }
            else {
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for (final Google contact : original) {
                    if (contact.getmTitle().contains(filterPattern)) {
                        filteredList.add(contact);
                    }
//                    else if (contact.getmDescription().contains(filterPattern))
//                    {
//                        filteredList.add(contact);
//
//                    }
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.googleList.clear();
        adapter.googleList.addAll((List<Google>)filterResults.values);
        adapter.notifyDataSetChanged();


    }
}
