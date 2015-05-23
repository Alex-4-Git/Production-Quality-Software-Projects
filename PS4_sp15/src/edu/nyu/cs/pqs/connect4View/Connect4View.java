package edu.nyu.cs.pqs.connect4View;

import edu.nyu.cs.pqs.connect4Model.Connect4Constant;
import edu.nyu.cs.pqs.connect4Model.Connect4Controller;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Connect4View implements Connect4Listener {
	Connect4Controller connect4Controller;

	private JFrame frame;
	// Base panel
	private JPanel jPanel;

	// Info panel, positions at the top of the base panel.
	// Contains 3 text fields to display the two players name and the current player name.
	private JPanel infoPanel;

	// Main panel, positions at the middle of the base panel.
	// Contains the operation panel (for game operation) and board panel (display the game board)..
	private JPanel mainPanel;
	private JPanel operationPanel;
	private JButton[] buttons;
	private JPanel boardPanel;
	private JLabel[][] cells;

	// Bottom panel, positions at the bottom of the base panel.
	// Contains a game mode panel (for choosing game mode) and message panel (display message and
	// a reset or replay button)
	private JPanel bottomPanel;

	private JButton vsPlayerButton;
	private JButton aiButton;


	private JLabel messageField;
	private JButton newGameButton;

	public Connect4View(final Connect4Controller connect4Controller) {
		this.connect4Controller = connect4Controller;
		connect4Controller.addListener(this);
		
		frame = new JFrame("Welcome to Connect 4");
		jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		frame.setSize(700, 700);


		//info panel
		infoPanel = new JPanel();
//		infoPanel.setSize(100,200);
		messageField = new JLabel();
//		messageField.setBounds(10,10,150,50);
//		messageField.setSize(100,200);
//		messageField.setFont(new Font("Serif", Font.PLAIN, 14));

		messageField.setText("Please choose a mode first!");
		infoPanel.add(messageField);
		
		
		//main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		operationPanel = new JPanel();
		boardPanel = new JPanel();
		boardPanel.setBackground(Color.BLACK);
		buttons = new JButton[Connect4Constant.COLUMN];
		cells = new JLabel[Connect4Constant.ROW][Connect4Constant.COLUMN];
		operationPanel.setLayout(new GridLayout(1, Connect4Constant.COLUMN));
		boardPanel.setLayout(new GridLayout(Connect4Constant.ROW, Connect4Constant.COLUMN));
		mainPanel.add(operationPanel, BorderLayout.NORTH);
		mainPanel.add(boardPanel, BorderLayout.CENTER);


		for (int i = 0; i < Connect4Constant.COLUMN; i++) {
			buttons[i] = new JButton(i + "");
			final int finalI = i;
			buttons[i].setEnabled(false);
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					connect4Controller.placeNextPiece(finalI);
				}
			});
			operationPanel.add(buttons[i]);
		}

		for (int i = 0; i < Connect4Constant.ROW; i++) {
			for (int j = 0; j < Connect4Constant.COLUMN; j++) {
				cells[i][j] = new JLabel();
				cells[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
//				cells[i][j].setBackground(java.awt.Color.gray);
				boardPanel.add(cells[i][j]);
			}
		}
		
		
		//bottom panel
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));
		vsPlayerButton = new JButton("2 Players");
		newGameButton = new JButton("New Game");

		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect4Controller.start();
				boardPanel.setBackground(Color.ORANGE);
				initialize();
			}
		});

		vsPlayerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect4Controller.setMode(Connect4Constant.MODE.PLAYER);
				connect4Controller.start();
				boardPanel.setBackground(Color.pink);
				initialize();
			}
		});
		
		aiButton = new JButton("Single Player");
		aiButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				connect4Controller.setMode(Connect4Constant.MODE.AI);
				connect4Controller.start();
				boardPanel.setBackground(Color.yellow);
				initialize();
			}
		});
		
		bottomPanel.add(vsPlayerButton);
		bottomPanel.add(aiButton);
		bottomPanel.add(newGameButton);


		jPanel.add(infoPanel, BorderLayout.NORTH);
		jPanel.add(mainPanel, BorderLayout.CENTER);
		jPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.add(jPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Initialize the game. Set all button enabled and initialize the game board.
	 */
	public void initialize() {
		for (int i = 0; i < Connect4Constant.COLUMN; i++) {
			buttons[i].setEnabled(true);
		}

		for (int i = 0; i < Connect4Constant.ROW; i++) {
			for (int j = 0; j < Connect4Constant.COLUMN; j++) {
//				cells[i][j].setOpaque(true);
//				cells[i][j].setBackground(java.awt.Color.red);				
				cells[i][j].setIcon(null);
			}
		}
	}

	/**
	 * Disable all the buttons.
	 */
	public void disableButtons() {
		for (int i = 0; i < Connect4Constant.COLUMN; i++) {
			buttons[i].setEnabled(false);
		}
	}

	/**
	 * Update the info box.
	 *
	 * @param message the new message which will be updated in the info box.
	 */
	@Override
	public void updateMessage(String message) {
		messageField.setText(message);
	}

	/**
	 * Update the current player info.
	 *
	 * @param playerID the current playerID which will be updated int the current player box.
	 */
	@Override
	public void updateCurrentPlayer(int playerID) {
		switch (playerID) {
			case Connect4Constant.PLAYER1:
				messageField.setText("Player " + playerID);
				break;
			case Connect4Constant.AI:
				messageField.setText("AI");
				break;
			case Connect4Constant.PLAYER2:
				messageField.setText("Player " + playerID);
				break;
			default:
				throw new IllegalArgumentException("Illegal player ID");
		}

	}


	@Override
	public void updatePlayers(int[] playerIDs) {

	}

	/**
	 * Update the game board.
	 *
	 * @param color the color which is going to be updated for the cell.
	 * @param row   the row of the cell which will be updated.
	 * @param col   the column of the cell which will be updated.
	 */
	@Override
	public void updateBoard(Connect4Constant.COLOR color, int row, int col) {
		ImageIcon icon=null;
		try {
			icon = ImageLoader.getImageIcon(color);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cells[row][col].setIcon(icon);
		
	}
}
