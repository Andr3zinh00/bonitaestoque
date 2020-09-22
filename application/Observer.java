package application;

import java.util.ArrayList;

public class Observer {
private static ArrayList<OnChangeScreen> listener = new ArrayList<>();
	
	public static interface OnChangeScreen{
		void onScreenChanged(Object userData);
	}
	
	public static void addOnChangeScreenLister(OnChangeScreen newListener) {
		listener.add(newListener);
	}
	
	public static void notifyAllListeners(Object userData) {
		for(OnChangeScreen l : listener) {
			System.out.println(userData.toString());
			l.onScreenChanged(userData);
			}
	}	
}
