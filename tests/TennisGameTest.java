import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);
		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act

		// This statement should cause an exception
		game.player1Scored();
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act

		// This statement should cause an exception
		game.player2Scored();
	}
	
	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		//player 1 wins 4 - 2
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		
		String score = game.getScore() ;
		assertEquals("Game score incorrect", "player1 wins", score);

	}
	
	@Test
	public void testTennisGame_Player2Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		//player 2 wins 4 - 2
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Game score incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1Advantage() throws TennisGameException {
		// 4 - 5
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
		assertEquals("Game score incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player1Advantage2() throws TennisGameException {
		// 3 - 4
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
		assertEquals("Game score incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2Advantage() throws TennisGameException {
		//4 - 3
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Game score incorrect", "player2 has advantage", score);
	}
	@Test
	public void testTennisGame_Deuce_3pointsForBoth () throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Game score incorrect", "deuce", score);
	}
	
	@Test
	public void allPointsPlayer1() throws TennisGameException{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);
		
		game.player1Scored();
		score = game.getScore() ;
		assertEquals("Score incorrect", "love - 15", score);
		game.player2Scored();
		score = game.getScore() ;
		assertEquals("Score incorrect", "15 - 15", score);
		game.player1Scored();
		score = game.getScore() ;
		assertEquals("Score incorrect", "15 - 30", score);
		game.player2Scored();
		score = game.getScore() ;
		assertEquals("Score incorrect", "30 - 30", score);
		game.player1Scored();
		score = game.getScore() ;
		assertEquals("Score incorrect", "30 - 40", score);
		game.player2Scored();
		score = game.getScore() ;
		assertEquals("Score incorrect", "deuce", score);
	}
}
	
