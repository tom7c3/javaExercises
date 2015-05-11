package com.capgemini.pokerHands;

import java.util.ArrayList;

import com.capgemini.pokerHands.Card.eCardType;

public class Hand
{
	public class FourOfAKind
	{
		public void setFourOfKindPower(int power) { mFourOfKindPower = power; }
		public void setFifthPower( int power ) { mFifthPower = power; }
		
		public int getFourOfKindPower() { return mFourOfKindPower; }
		public int getPairPower() { return mFifthPower; }
		
		private int mFourOfKindPower = 0;
		private int mFifthPower = 0;
	}
	
	public class FullHouse
	{
		public void setThreeOfKindPower(int power) { mThreeOfKindPower = power; }
		public void setPairPower( int power ) { mPairPower = power; }
		
		public int getThreeOfKindPower() { return mThreeOfKindPower; }
		public int getPairPower() { return mPairPower; }
		
		private int mThreeOfKindPower = 0;
		private int mPairPower = 0;
	}
	
	public class ThreeOfAKind
	{
		public void setThreeOfKindPower(int power) { mThreeOfKindPower = power; }
		public void setFourthPower( int power ) { mFourthPower = power; }
		public void setFifthPower( int power ) { mFifthPower = power; }
		
		public int getThreeOfKindPower() { return mThreeOfKindPower; }
		public int getFourthPower() { return mFourthPower; }
		public int getFifthPower() { return mFifthPower; }
		
		private int mThreeOfKindPower = 0;
		private int mFourthPower = 0;
		private int mFifthPower = 0;
	}
	
	public class TwoPair
	{
		public void setFirstPairPower(int power) { mFirstPairPower = power; }
		public void setSecondPairPower( int power ) { mSecondPairPower = power; }
		public void setFifthPower( int power ) { mFifthPower = power; }
		
		public int getFirstPairPower() { return mFirstPairPower; }
		public int getSecondPairPower() { return mSecondPairPower; }
		public int getFifthPower() { return mFifthPower; }
		
		private int mFirstPairPower = 0;
		private int mSecondPairPower = 0;
		private int mFifthPower = 0;
	}
	
	public class OnePair
	{
		public void setPairPower(int power) { mPairPower = power; }
		public void setThirdPower( int power ) { mThirdPower = power; }
		public void setFourthPower( int power ) { mFourthPower = power; }
		public void setFifthPower( int power ) { mFifthPower = power; }
		
		public int getPairPower() { return mPairPower; }
		public int getThirdPower() { return mThirdPower; }
		public int getFourthPower() { return mFourthPower; }
		public int getFifthPower() { return mFifthPower; }
		
		private int mPairPower = 0;
		private int mThirdPower = 0;
		private int mFourthPower = 0;
		private int mFifthPower = 0;
	}
	
	public Hand()
	{
		mCards = new ArrayList<Card>();
	}
	
	public void addCard( Card card ) throws Exception
	{
		if ( mCards.size() >= 5 )
		{
			throw new Exception("Player could have only 5 cards");
		}
		
		mCards.add(card);
		
//		System.out.print(card.getCard());
//		System.out.print(card.getSuit());
//		System.out.println();
	}
	
	public Card getBestCard()
	{
		Card card = mCards.get(0);
		
		for ( Card c : mCards )
		{
			if ( c.getPower() > card.getPower() )
				card = c;
		}
		
		return card;
	}
	
	public int getBestCardPower( int next )
	{
		int n = 0;
		int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		loadPowers( amount );
		
		for ( int i = amount.length - 1; i >= 0; --i )
		{
//			if ( amount[i] == 1 )
			if ( amount[i] > 0 )	
			{
				if ( ++n == next )
					return i;
			}
		}
		
		return 0;
	}
	
	public Card getWorseCard()
	{
		Card card = mCards.get(0);
		
		for ( Card c : mCards )
		{
			if ( c.getPower() < card.getPower() )
				card = c;
		}
		
		return card;
	}
	
	public boolean checkSameSuit()
	{
		char suit = mCards.get(0).getSuit();
		
//		System.out.print(suit);
		
		for ( int i = 1; i < mCards.size(); ++i )
		{
			if ( mCards.get(i).getSuit() != suit )
				return false;
		}
		
//		System.out.print( mCards.size() );
//		
//		for ( int i = 0; i < mCards.size(); ++i )
//		{
//			System.out.print( mCards.get(i).getCard());
//			System.out.print( mCards.get(i).getSuit());
//			System.out.print(" ");
//		}
//		
//		System.out.println();
		
		return true;
	}
	
	public boolean hasCard( eCardType type )
	{
		for ( Card c : mCards )
		{
			if ( c.getType() == type )
				return true;
		}
		
		return false;
	}
	
	public boolean hasCard( int power )
	{
		for ( Card c : mCards )
		{
			if ( c.getPower() == power )
				return true;
		}
		
		return false;
	}
	
	public boolean checkRoyalFlush()
	{
		if ( checkSameSuit() )
		{
			return hasCard( eCardType.CARDT) && hasCard( eCardType.CARDQ) && 
				   hasCard( eCardType.CARDK) && hasCard( eCardType.CARDA);
		}
		
		return false;
	}
	
	public boolean checkStraightFlush()
	{
		if ( checkSameSuit() )
			return hasStraight();
		
		return false;
	}
	
	public void loadPowers( int[] table )
	{
		for ( int i = 0; i < 5; ++i )
		{
			++table[ mCards.get(i).getPower() - 2 ];
		}
	}
	
	public FourOfAKind getFourOfAKind()
	{
		FourOfAKind foak = null;
		int four = 0;
		int one = 0;
		
		int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		loadPowers( amount );
		
		four = getNextPower(amount, amount.length - 1, 4);
		one = getNextPower(amount, amount.length - 1, 1);
		
		if ( four >= 0 && one >= 0 )
		{
			foak = new FourOfAKind();
			foak.setFourOfKindPower(four + 2);
			foak.setFifthPower(one + 2);
		}
		
		return foak;
	}
	
	public FullHouse getFullHouse()
	{
		FullHouse fh = null;
		int three = 0;
		int two = 0;
		
		int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		loadPowers( amount );
		
		three = getNextPower(amount, amount.length - 1, 3);
		two = getNextPower(amount, amount.length - 1, 2);
		
		if ( three >= 0 && two >= 0 )
		{
			fh = new FullHouse();
			fh.setThreeOfKindPower(three + 2);
			fh.setPairPower(two + 2);
		}
		
		return fh;
	}
	
	public boolean hasStraight()
	{
		Card bestCard = getBestCard();
		Card worseCard = getWorseCard();
		
		if ( bestCard.getType() == eCardType.CARDA && worseCard.getType() == eCardType.CARD2 )
		{
			// there is chance for A2345 //
			return hasCard( eCardType.CARD3 ) && hasCard( eCardType.CARD4 ) && hasCard( eCardType.CARD5 );
		}
		else
		{
			int power = worseCard.getPower();
			for ( int i = 0; i < 5; ++i )
			{
				if ( !hasCard( ++power ) )
					return false;
			}
			
			return true;
		}	
	}
	
	public ThreeOfAKind getThreeOfAKind()
	{
		ThreeOfAKind toak = null;
		int three = 0;
		int fourth = 0;
		int fifth = 0;
			
		int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		loadPowers( amount );
		
		three = getNextPower( amount, amount.length - 1, 3 );
		int i = amount.length - 1;
		i = getNextPower( amount, i, 1 );
		fourth = i;
		i = getNextPower( amount, i - 1, 1 );
		fifth = i;
		
		if ( three >= 0 && fourth >= 0 && fifth >= 0 )
		{
			toak = new ThreeOfAKind();
			toak.setThreeOfKindPower(three + 2);
			toak.setFourthPower(fourth + 2);
			toak.setFifthPower(fifth + 2);
		}
		
		return toak;
	}
	
	public TwoPair getTwoPair()
	{
		TwoPair tp = null;
		int first = 0;
		int second = 0;
		int fifth = 0;
		
		int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		loadPowers( amount );
		
		int i = amount.length - 1;
		i = getNextPower( amount, i, 2 );
		first = i;
		i = getNextPower( amount, i - 1, 2 );
		second = i;
		i = getNextPower( amount, amount.length - 1, 1 );
		fifth = i;
		
		if ( first >= 0 && second >= 0 && fifth >= 0 )
		{
			tp = new TwoPair();
			tp.setFirstPairPower(first + 2);
			tp.setSecondPairPower(second + 2);
			tp.setFifthPower(fifth + 2);
		}
		
		return tp;
	}
	
	public int getNextPower( int[] table, int i, int amount )
	{
		for ( ; i >= 0; --i )
			if ( table[i] == amount )
				return i;
	
		return -1;
	}
	
	public OnePair getOnePair()
	{
		OnePair op = null;
		int pair = 0;
		int third = 0;
		int fourth = 0;
		int fifth = 0;
		
		int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		loadPowers( amount );
		
		pair = getNextPower( amount, amount.length - 1, 2 );
		int i = amount.length - 1;
		i = getNextPower( amount, i, 1 );
		third = i;
		i = getNextPower( amount, i - 1, 1 );
		fourth = i;
		i = getNextPower( amount, i - 1, 1 );
		fifth = i;
		
		if ( pair >= 0 && third >= 0 && fourth >= 0 && fifth >= 0 )
		{
			op = new OnePair();
			op.setPairPower(pair + 2);
			op.setThirdPower(third + 2);
			op.setFourthPower(fourth + 2);
			op.setFifthPower(fifth + 2);
		}
		
		return op;
	}
	
	public void printHand()
	{
		for ( Card c : mCards )
		{
			System.out.print(c.getCard());
			System.out.print(c.getSuit());
			System.out.print(" ");
		}
		//System.out.println();
	}
	
	ArrayList<Card> mCards;
	//Card[] mCards;
	//private eRank
}













