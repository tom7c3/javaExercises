package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capgemini.pokerHands.Hand.FourOfAKind;
import com.capgemini.pokerHands.Hand.FullHouse;
import com.capgemini.pokerHands.Hand.OnePair;
import com.capgemini.pokerHands.Hand.ThreeOfAKind;
import com.capgemini.pokerHands.Hand.TwoPair;

public class Poker 
{
	public static int checkRoyalFlush( Hand p1, Hand p2 )
	{
		if ( p1.checkRoyalFlush() )
			return 1;
		else if ( p2.checkRoyalFlush() )
			return 2;

		return 0;
	}
	
	public static int checkStraightFlush( Hand p1, Hand p2 )
	{
		if ( p1.checkStraightFlush() )
			return 1;
		else if ( p2.checkStraightFlush() )
			return 2;
	
		return 0;
	}
	
	public static int getFourOfAKindWinner( Hand p1, Hand p2 )
	{
		FourOfAKind p1FOAK = p1.getFourOfAKind();
		FourOfAKind p2FOAK = p2.getFourOfAKind();
		
		if ( p1FOAK != null && p2FOAK != null )
		{
			int power1 = p1FOAK.getFourOfKindPower();
			int power2 = p2FOAK.getFourOfKindPower();
			
			if ( power1 == power2 )
			{
				int fifthPower1 = p1FOAK.getPairPower();
				int fifthPower2 = p2FOAK.getPairPower();
				
				if ( fifthPower1 == fifthPower2 )
				{
					// no winner //
				}
				else if ( fifthPower1 > fifthPower2 )
					return 1;
				else if ( fifthPower2 > fifthPower1 )
					return 2;
			}
			else if ( power1 > power2 )
				return 1;
			else if ( power2 > power1 )
				return 2;
		}
		else if ( p1FOAK != null )
			return 1;
		else if ( p2FOAK != null )
			return 2;
		
		return 0;
	}
	
	public static int getFullHouseWinner( Hand p1, Hand p2 )
	{
		FullHouse p1FullHouse = p1.getFullHouse();
		FullHouse p2FullHouse = p2.getFullHouse();
		
		if ( p1FullHouse != null && p2FullHouse != null )
		{
			int power1 = p1FullHouse.getThreeOfKindPower();
			int power2 = p2FullHouse.getThreeOfKindPower();
			
			if ( power1 == power2 )
			{
				int pairPower1 = p1FullHouse.getPairPower();
				int pairPower2 = p2FullHouse.getPairPower();
				
				if ( pairPower1 == pairPower2 )
				{
					// no winner //
				}
				else if ( pairPower1 > pairPower2 )
					return 1;
				else if ( pairPower2 > pairPower1 )
					return 2;
			}
			else if ( power1 > power2 )
				return 1;
			else if ( power2 > power1 )
				return 2;
		}
		else if ( p1FullHouse != null )
			return 1;
		else if ( p2FullHouse != null )
			return 2;
		
		return 0;
	}
	
	public static int getFlushWinner( Hand p1, Hand p2 )
	{
		if ( p1.checkSameSuit() && p2.checkSameSuit() )
		{
			// no winner //
		}
		else if ( p1.checkSameSuit() )
			return 1;
		else if ( p2.checkSameSuit() )
			return 2;
	
		return 0;
	}
	
	public static int getStrightWinner( Hand p1, Hand p2 )
	{
		if ( p1.checkSameSuit() && p2.checkSameSuit() )
		{
			// no winner //
		}
		else if ( p1.checkSameSuit() )
			return 1;
		else if ( p2.checkSameSuit() )
			return 2;
	
		return 0;
	}
	
	public static int getThreeOfAKindWinner( Hand p1, Hand p2 )
	{
		ThreeOfAKind p1TOAK = p1.getThreeOfAKind();
		ThreeOfAKind p2TOAK = p2.getThreeOfAKind();
		
		if ( p1TOAK != null && p2TOAK != null )
		{
			int power1 = p1TOAK.getThreeOfKindPower();
			int power2 = p2TOAK.getThreeOfKindPower();
			
			if ( power1 == power2 )
			{
				int fourthPower1 = p1TOAK.getFourthPower();
				int fourthPower2 = p2TOAK.getFourthPower();
				
				if ( fourthPower1 == fourthPower2 )
				{
					int fifthPower1 = p1TOAK.getFifthPower();
					int fifthPower2 = p2TOAK.getFifthPower();
					
					if ( fifthPower1 == fifthPower2 )
					{
						// no winner //
					}
					else if ( fifthPower1 > fifthPower2 )
						return 1;
					else if ( fifthPower2 > fifthPower1 )
						return 2;
				}
				else if ( fourthPower1 > fourthPower2 )
					return 1;
				else if ( fourthPower2 > fourthPower1 )
					return 2;
			}
			else if ( power1 > power2 )
				return 1;
			else if ( power2 > power1 )
				return 2;
		}
		else if ( p1TOAK != null )
			return 1;
		else if ( p2TOAK != null )
			return 2;
		
		return 0;
	}
	
	public static int getTwoPairWinner( Hand p1, Hand p2 )
	{
		TwoPair p1TP = p1.getTwoPair();
		TwoPair p2TP = p2.getTwoPair();
		
		if ( p1TP != null && p2TP != null )
		{
			int powerFirst1 = p1TP.getFirstPairPower();
			int powerFirst2 = p2TP.getFirstPairPower();
			
			if ( powerFirst1 == powerFirst2 )
			{
				int powerSecond1 = p1TP.getSecondPairPower();
				int powerSecond2 = p2TP.getSecondPairPower();
				
				if ( powerSecond1 == powerSecond2 )
				{
					int fifthPower1 = p1TP.getFifthPower();
					int fifthPower2 = p2TP.getFifthPower();
					
					if ( fifthPower1 == fifthPower2 )
					{
						// no winner //
					}
					else if ( fifthPower1 > fifthPower2 )
						return 1;
					else if ( fifthPower2 > fifthPower1 )
						return 2;
				}
				else if ( powerSecond1 > powerSecond2 )
					return 1;
				else if ( powerSecond2 > powerSecond1 )
					return 2;
			}
			else if ( powerFirst1 > powerFirst2 )
				return 1;
			else if ( powerFirst2 > powerFirst1 )
				return 2;
		}
		else if ( p1TP != null )
			return 1;
		else if ( p2TP != null )
			return 2;
		
		return 0;
	}
	
	public static int getOnePairWinner( Hand p1, Hand p2 )
	{
		OnePair p1OP = p1.getOnePair();
		OnePair p2OP = p2.getOnePair();
		
		if ( p1OP != null && p2OP != null )
		{
			int powerPair1 = p1OP.getPairPower();
			int powerPair2 = p2OP.getPairPower();
			
			if ( powerPair1 == powerPair2 )
			{
				int powerThird1 = p1OP.getThirdPower();
				int powerThird2 = p2OP.getThirdPower();
				
				if ( powerThird1 == powerThird2 )
				{
					int powerFourth1 = p1OP.getFourthPower();
					int powerFourth2 = p2OP.getFourthPower();
					
					if ( powerFourth1 == powerFourth2 )
					{
						int fifthPower1 = p1OP.getFifthPower();
						int fifthPower2 = p2OP.getFifthPower();
						
						if ( fifthPower1 == fifthPower2 )
						{
							// no winner //
						}
						else if ( fifthPower1 > fifthPower2 )
							return 1;
						else if ( fifthPower2 > fifthPower1 )
							return 2;
					}
					else if ( powerFourth1 > powerFourth2 )
						return 1;
					else if ( powerFourth2 > powerFourth1 )
						return 2;
				}
				else if ( powerThird1 > powerThird2 )
					return 1;
				else if ( powerThird2 > powerThird1 )
					return 2;
			}
			else if ( powerPair1 > powerPair2 )
				return 1;
			else if ( powerPair2 > powerPair1 )
				return 2;
		}
		else if ( p1OP != null )
			return 1;
		else if ( p2OP != null )
			return 2;
		
		return 0;
	}
	
	public static int getHighestCardWinner( Hand p1, Hand p2 )
	{
		int high11 = p1.getBestCardPower(1);
		int high12 = p2.getBestCardPower(1);
		
		if ( high11 == high12 )
		{
			int high21 = p1.getBestCardPower(2);
			int high22 = p2.getBestCardPower(2);
			
			if ( high21 == high22 )
			{
				int high31 = p1.getBestCardPower(3);
				int high32 = p2.getBestCardPower(3);
				
				if ( high31 == high32 )
				{
					int high41 = p1.getBestCardPower(4);
					int high42 = p2.getBestCardPower(4);
					
					if ( high41 == high42 )
					{
						// no winner - should never be here//
					}
				}
				else if ( high31 > high32 )
					return 1;
				else
					return 2;
			}
			else if ( high21 > high22 )
				return 1;
			else
				return 2;
		}
		else if ( high11 > high12 )
			return 1;
		else
			return 2;
		
		return 0;	// should never be here //
	}
	
	public static int getWinner( Hand p1, Hand p2 )
	{
		int winner;
		if ( (winner = checkRoyalFlush( p1, p2 )) > 0 )
		{
			System.out.print("RoyalFlush: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = checkStraightFlush( p1, p2 )) > 0 )
		{
			System.out.print("StraightFlush: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = getFourOfAKindWinner( p1, p2 )) > 0 )
		{
			System.out.print("FourOfAKind: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = getFullHouseWinner( p1, p2 )) > 0 )
		{
			System.out.print("FullHouse: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = getFlushWinner( p1, p2 )) > 0 )
		{
			System.out.print("Flush: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = getStrightWinner( p1, p2 )) > 0 )
		{
			System.out.print("Stright: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = getThreeOfAKindWinner( p1, p2 )) > 0 )
		{
			System.out.print("ThreeOfAKind: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = getTwoPairWinner( p1, p2 )) > 0 )
		{
			System.out.print("TwoPair: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		if ( (winner = getOnePairWinner( p1, p2 )) > 0 )
		{
			System.out.print("OnePair: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");;
			return winner;
		}
		
		if ( (winner = getHighestCardWinner( p1, p2 )) > 0 )
		{
			System.out.print("HighestCard: P" + winner + " (");
			p1.printHand();
			System.out.print(" : ");
			p2.printHand();
			System.out.println(")");
			return winner;
		}
		
		return 0;
	}
	
//	@Test
//	public void test()
//	{
//		System.out.println("THIS IS TEST");
//		try
//		{
//			Card card = new Card("ADE");
//			assertEquals("ASDASD", true, card.isAce());
//			card = new Card("5D");
//			assertEquals("ASDASD", false, card.isAce());
//		}
//		catch( Exception e )
//		{
//			System.out.println(e);
//		}
//	}
	
	public static int getPlayer1Wins( String fileName ) throws Exception
	{
		int player1Wins = 0;
		int player2Wins = 0;
		
		File file = new File(fileName);
		FileInputStream fstream = new FileInputStream( file.getAbsolutePath() );
		BufferedReader reader = new BufferedReader(new InputStreamReader(fstream, "UTF-8"));
		try 
		{
			while (true)
			{
				Hand player1 = new Hand();
				Hand player2 = new Hand();
				
				String line = reader.readLine();
				if (line == null) break;
				String[] fields = line.split(" ");
				
				if ( fields.length != 10 )
				{
					throw new Exception("More than 10 cards");
//					System.out.println("ERROR");
				}
				
				try
				{
					for ( int i = 0; i < 5; ++i )
						player1.addCard( new Card(fields[i]) );
					for ( int i = 5; i < 10; ++i )
						player2.addCard( new Card(fields[i]) );
				}
				catch ( Exception e )
				{
					throw e;
				}
				
				int winner = getWinner( player1, player2 );
				if ( winner == 1 )
					++player1Wins;
				else if ( winner == 2 )
					++player2Wins;
				else
				{
					// ERROR //
					
				}
			}
		} 
		finally 
		{
		  reader.close();
		}
		
//    	System.out.println( player1Wins + " : " + player2Wins );
    	return player1Wins;
	}
	
	public static void main(String[] args) throws Exception
	{		
		System.out.println( getPlayer1Wins("poker.txt") );
	}

	@Test
	public void shouldReturn3()
	{
		try
		{
			assertEquals(3, getPlayer1Wins("test1.txt") );
		}
		catch ( Exception e )
		{
			fail(e.getMessage());
		}
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void shouldThrowUnknownCardSuit() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("Unknown card suit");
	    
	    getPlayer1Wins("test2.txt");
	}
	
	@Test
	public void shouldThrowUnknownCardType() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("Unknown card type");
	    
	    getPlayer1Wins("test3.txt");
	}
	
	@Test
	public void shouldThrowMoreThan10Cards() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("More than 10 cards");
	    
	    getPlayer1Wins("test4.txt");
	}
	
	@Test
	public void shouldThrowBadCardName() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("bad card name");
	    
	    getPlayer1Wins("test5.txt");
	}
	
	@Test
	public void shouldThrowFileNotFound() throws Exception
	{
		exception.expect(FileNotFoundException.class);
	    //exception.expectMessage("bad card name");
	    
	    getPlayer1Wins("notFoundFile");
	}
	
	
}





















