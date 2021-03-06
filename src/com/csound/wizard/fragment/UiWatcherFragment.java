package com.csound.wizard.fragment;

import com.csound.wizard.App;

import android.app.Fragment;

public class UiWatcherFragment extends Fragment {
	private String trackName;
	
	@Override
	public void onStart() {
		super.onStart();
		
		App app = (App) getActivity().getApplication();		
		trackName = app.getModel().getCurrentTrack().getName();		
	}	
		
	@Override
	public void onStop() {
		super.onStop();
		
		App app = (App) getActivity().getApplication();
		app.saveStateFromView(trackName, getView());
	}
}
