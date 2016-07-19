package testpackage;

import kr.co.tvhub.platform.TermModel;

public class Main {

	public static void main(String[] args) {
		
		TermModel t = new TermModel() {
			
			@Override
			protected void loadProperty() {
				
			}
		};
		
		
		t.PrintPath();
	}
}
