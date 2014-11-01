/**
 * 
 */
package com.example.careerfair;

import java.util.ArrayList;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * @author andrewzComp
 *
 */
public class PreferencesViewFragment extends Fragment {

	private static final String ARG_SECTION_NUMBER = "PreferencesView";

	static ArrayList<String> MajorAbbrevs;
	static ArrayList<String> WorkAuths;
	static ArrayList<String> Positions;


	/**
	 * 
	 */
	public PreferencesViewFragment() {
		// TODO Auto-generated constructor stub
	}

	public static PreferencesViewFragment newInstance(int sectionNumber, ArrayList<String> Abbrevs, ArrayList<String> Auths, ArrayList<String> Pos) {
		MajorAbbrevs = Abbrevs;
		WorkAuths = Auths;
		Positions = Pos;
		PreferencesViewFragment fragment = new PreferencesViewFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ScrollView sv = new ScrollView(getActivity());
		LinearLayout ll = new LinearLayout(getActivity());
		ll.setOrientation(LinearLayout.VERTICAL);
		sv.addView(ll);


		TextView tv = new TextView(getActivity());
		tv.setText("Set your preferences below");
		ll.addView(tv);

		//		EditText et = new EditText(getActivity());
		//		et.setText("weeeeeeeeeee~!");
		//		ll.addView(et);

		//		Button b = new Button(getActivity());
		//		b.setText("I don't do anything, but I was added dynamically. :)");
		//		ll.addView(b);

		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();

		TextView WorkAuthText = new TextView(getActivity());
		WorkAuthText.setText("Work Authorizations");
		ll.addView(WorkAuthText);

		for(int i = 0; i < WorkAuths.size(); i++) {

			CheckBox cb = new CheckBox(getActivity());

			// If it was previously checked, set it to that state in the SharedPreferences
			Boolean checked = sharedPref.contains(WorkAuths.get(i));
			if (checked) {
				// Get the value
				cb.setChecked(sharedPref.getBoolean(WorkAuths.get(i), false));
			} 


			cb.setText(WorkAuths.get(i));
			CheckBoxListener cbListen = new CheckBoxListener("workAuths", WorkAuths.get(i),sharedPref,editor);
			cb.setOnCheckedChangeListener(cbListen);


			ll.addView(cb);

		}

		TextView PositionText = new TextView(getActivity());
		PositionText.setText("Positions");
		ll.addView(PositionText);

		for(int i = 0; i < Positions.size(); i++) {

			CheckBox cb = new CheckBox(getActivity());

			// If it was previously checked, set it to that state in the SharedPreferences
			Boolean checked = sharedPref.contains(Positions.get(i));
			if (checked) {
				// Get the value
				cb.setChecked(sharedPref.getBoolean(Positions.get(i), false));
			} 

			cb.setText(Positions.get(i));
			CheckBoxListener cbListen = new CheckBoxListener("positions", Positions.get(i),sharedPref,editor);
			cb.setOnCheckedChangeListener(cbListen);

			ll.addView(cb);

		}

		TextView majorText = new TextView(getActivity());
		majorText.setText("Majors");
		ll.addView(majorText);

		for(int i = 0; i < MajorAbbrevs.size(); i++) {

			CheckBox cb = new CheckBox(getActivity());
			
			// If it was previously checked, set it to that state in the SharedPreferences
			Boolean checked = sharedPref.contains(MajorAbbrevs.get(i));
			if (checked) {
				// Get the value
				cb.setChecked(sharedPref.getBoolean(MajorAbbrevs.get(i), false));
			} 

			cb.setText(MajorAbbrevs.get(i));
			CheckBoxListener cbListen = new CheckBoxListener("majors", MajorAbbrevs.get(i),sharedPref,editor);
			cb.setOnCheckedChangeListener(cbListen);

			ll.addView(cb);

		}

		return sv;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
	
	@Override
	public void onDestroyView() {
		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		
		MainActivity main = (MainActivity)this.getActivity();
		
		main.filterCompanies();
	    super.onDestroyView();
		
	}
	
	

}
