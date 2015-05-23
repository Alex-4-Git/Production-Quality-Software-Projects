package edu.nyu.cs.pqs.connect4;

import edu.nyu.cs.pqs.connect4Model.*;
import edu.nyu.cs.pqs.connect4View.*;

public class Connect4App { 
	
	private void go(){
		Connect4Controller connect4Controller = new Connect4Controller();
		Connect4View connect4View = new Connect4View(connect4Controller);
		Connect4Logger connect4Logger = new Connect4Logger(connect4Controller);
	}

	
	public static void main(String[] args) {
		new Connect4App().go();
	}
} 