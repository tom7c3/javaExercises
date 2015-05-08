package com.capgemini.pokerHands;

public class Card 
{
	enum eCardType
	{
		CARD2,
		CARD3,
		CARD4,
		CARD5,
		CARD6,
		CARD7,
		CARD8,
		CARD9,
		CARDT,
		CARDJ,
		CARDQ,
		CARDK,
		CARDA
	};
	
	public Card( String s ) throws Exception
	{
		if ( s.length() != 2 )
		{
			throw new Exception();
		}
		else
		{
			mCard = s.charAt(0);
			mSuit = s.charAt(1);
			
			switch ( mCard )
			{
				case '2':
					mCardType = eCardType.CARD2;
					mPower = 2;
					break;
				case '3':
					mCardType = eCardType.CARD3;
					mPower = 3;
					break;
				case '4':
					mCardType = eCardType.CARD4;
					mPower = 4;
					break;
				case '5':
					mCardType = eCardType.CARD5;
					mPower = 5;
					break;
				case '6':
					mCardType = eCardType.CARD6;
					mPower = 6;
					break;
				case '7':
					mCardType = eCardType.CARD7;
					mPower = 7;
					break;
				case '8':
					mCardType = eCardType.CARD8;
					mPower = 8;
					break;
				case '9':
					mCardType = eCardType.CARD9;
					mPower = 9;
					break;
				case 'T':
					mCardType = eCardType.CARDT;
					mPower = 10;
					break;
				case 'J':
					mCardType = eCardType.CARDJ;
					mPower = 11;
					break;
				case 'Q':
					mCardType = eCardType.CARDQ;
					mPower = 12;
					break;
				case 'K':
					mCardType = eCardType.CARDK;
					mPower = 13;
					break;
				case 'A':
					mCardType = eCardType.CARDA;
					mPower = 14;
					break;
				default:
					throw new Exception();
			}
			
//			if ( mCard >= '2' || mCard <= '9' )
//			{
//				mCardType = eCardType.values()[mCard - 50];
//				mPower = mCard - 48; // '2' == 2 -> '9' == 9 //
//			}
//			else
//			{
//				switch ( mCard )
//				{
//					case 'T':
//						mCardType = eCardType.CARDT;
//						mPower = 10;
//						break;
//					case 'J':
//						mCardType = eCardType.CARDJ;
//						mPower = 11;
//						break;
//					case 'Q':
//						mCardType = eCardType.CARDQ;
//						mPower = 12;
//						break;
//					case 'K':
//						mCardType = eCardType.CARDK;
//						mPower = 13;
//						break;
//					case 'A':
//						mCardType = eCardType.CARDA;
//						mPower = 14;
//						break;
//				}
//			}
			
//			System.out.print(mCard);
//			System.out.print(mSuit);
//			System.out.println();
		}
	}
	
	public boolean isTen() { return mCard == 'T'; }
	public boolean isJack() { return mCard == 'J'; }
	public boolean isQueen() { return mCard == 'Q'; }
	public boolean isKing() { return mCard == 'K'; }
	public boolean isAce() { return mCard == 'A'; }
	
	public char getCard() { return mCard; }
	public char getSuit() { return mSuit; }
	
	public int getPower() { return mPower; }
	public eCardType getType() { return mCardType; }
	
	private char mCard;
	private char mSuit;
	
	private int mPower;
	private eCardType mCardType;
}











