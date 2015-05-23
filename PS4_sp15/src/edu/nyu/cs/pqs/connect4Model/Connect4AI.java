package edu.nyu.cs.pqs.connect4Model;

import java.util.ArrayList;
import java.util.Random;



public class Connect4AI {
	private Connect4Model model;
	
	public Connect4AI(Connect4Model model){
		this.model=model.copy();
	}

	
	//return the column number of best move
	public int makeBestMove(){
		
		// save all legal option
		ArrayList<Integer> columns = new ArrayList<>();
		for(int j=0;j<Connect4Constant.COLUMN;j++){
			int i=model.tryColumn(Connect4Constant.AI, j);
			if(i==-1){
				continue;
			}else if(model.checkHasWon(i, j)){
				return j;
			}else{
				columns.add(j);
				model.undoMove(i, j);
			}
		}
		
		for(int j=0;j<Connect4Constant.COLUMN;j++){
			int i=model.tryColumn(Connect4Constant.PLAYER1, j);
			if(model.checkHasWon(i, j)){
				return j;
			}else{
				model.undoMove(i, j);
			}
		}
		
		// no winning move so return a random move.
		int size=columns.size();
		Random random = new Random();
		int randomNumber= random.nextInt(size);
		return columns.get(randomNumber);
	}

}
