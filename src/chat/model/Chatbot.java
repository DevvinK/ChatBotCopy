package chat.model;

import java.util.ArrayList;

public class Chatbot 
{
	private ArrayList<String> myMemes;
	private ArrayList<String> myColors;
	private ArrayList<String> myRandomList;
	private ArrayList<String> myState;
	private ArrayList<String> conversationList;
	
	
	public Chatbot()
	{
		myMemes = new ArrayList<String>();
		myColors = new ArrayList<String>();
		myRandomList = new ArrayList<String>();
		myState = new ArrayList<String>();
		conversationList = new ArrayList<String>();
		
		fillTheStateList();
		fillTheMemeList();
		fillTheColorList();
		fillTheRandomList();
		fillTheConversationList();
	}
	
	private void fillTheStateList()
	{
		myState.add("Alabama");
		myState.add("Alaska");
		myState.add("Arizona");
		myState.add("Arkansas");
		myState.add("California");
		myState.add("Colorado");
		myState.add("Connecticut");
		myState.add("Delaware");
		myState.add("Florida");
		myState.add("Georgia");
		myState.add("Hawaii");
		myState.add("Idaho");
		myState.add("Illinois");
		myState.add("Indiana");
		myState.add("Iowa");
		myState.add("Kansas");
		myState.add("Kentucky");
		myState.add("Louisiana");
		myState.add("Maine");
		myState.add("Maryland");
		myState.add("Massachusetts");
		myState.add("Michigan");
		myState.add("Minnesota");
		myState.add("Mississippi");
		myState.add("Missouri");
		myState.add("Montana");
		myState.add("Nebraska");
		myState.add("Nevada");
		myState.add("New Hampshire  ");
		myState.add("New Jersey");
		myState.add("New Mexico");
		myState.add("New York");
		myState.add("North Carolina");
		myState.add("North Dakota");
		myState.add("Ohio");
		myState.add("Oklahoma");
		myState.add("Oregon");
		myState.add("Pennsylvania");
		myState.add("Rhode Island");
		myState.add("South Carolina");
		myState.add("South Dakota");
		myState.add("Tennessee");
		myState.add("Texas");
		myState.add("Utah");
		myState.add("Vermont");
		myState.add("Virginia");
		myState.add("Washington");
		myState.add("West Virginia");
		myState.add("Wisconsin");
		myState.add("Wyoming");
	}
	
	private void fillTheRandomList()
	{
		myRandomList.add("Penguins");
		myRandomList.add("I have to say something random?");
		myRandomList.add("You don't want that?");
		myRandomList.add("Cat");
	}
	
	private void fillTheColorList()
	{
		myColors.add("red");
		myColors.add("blue");
		myColors.add("green");
		myColors.add("purple");
		myColors.add("yellow");
		myColors.add("orange");
		myColors.add("pink");
		myColors.add("white");
		myColors.add("black");
		myColors.add("brown");
		myColors.add("cyan");
		myColors.add("gray");
	}
	
	private void fillTheMemeList()
	{
		myMemes.add("My jammies are rustled");
		myMemes.add("Cats");
		myMemes.add("What does the fox say?");
		myMemes.add("Philosoraptor");
		myMemes.add("iamdisappoint");		
	}
	
	private void fillTheConversationList()
	{
		conversationList.add("I was wondering, do you like Klondike Bars?");
		conversationList.add("I like Klondike Bars a lot. You're probably wondering what I would do for one then?");
		conversationList.add("I don't know about you but I would do some hardcore parkore to get to the store, maybe some break dancing moves, and even steal a bike too.");
		conversationList.add("That is, until I get to the store and see the price for it, then you can forget about it. :D");
	}
	
	public String getRandomTopic()
	{
		String randomTopic = "";
		
		double myRandomNumber = Math.random();
		int myMemePosition = (int)(myRandomNumber * myMemes.size());
		randomTopic = myMemes.get(myMemePosition);
		
		return randomTopic;
	}
	
	public boolean colorChecker(String currentPhrase)
	{
		boolean isColor = false; 
		
		if(currentPhrase != null)
		{
			for (String currentColor : myColors)
			{
				if(currentPhrase.equalsIgnoreCase(currentColor))
				{
					isColor = true;
				}
			}
		}
		return isColor;
	}
	
	public boolean memeChecker(String currentPhrase)
	{
		boolean isMeme = false; 
		
		if(currentPhrase != null)
		{
			for (String currentMeme : myMemes)
			{
				if(currentPhrase.equalsIgnoreCase(currentMeme))
				{
					isMeme = true;
				}
			}
		}
		return isMeme;
	}
	
	public boolean stateChecker(String currentPhrase)
	{
		boolean isState = false; 
		
		if(currentPhrase != null)
		{
			for (String currentState : myState)
			{
				if(currentPhrase.equalsIgnoreCase(currentState))
				{
					isState = true;
				}
			}
		}
		return isState;
	}
	 
	public String usesContent(String current)
	{
		String processedString = "";
		
		if(current.contains("boo"))
		{
			processedString = "Woo scary";
		}
		else
		{
			processedString = "Boooooooooooooooooing";
		}
		
		return processedString;
	}
	
	public String putNameInAlphabeticalOrder(String first, String middle, String last)
	{
		String sortedName = "";
		
		if(first.compareTo(middle) < 0)
		{
			if(first.compareTo(last) < 0)
			{
				if(middle.compareTo(last) < 0)
				{
					sortedName = first + ", " + middle + ", " + last;
				}
				else
				{
					sortedName = first + ", " + middle + ", " + last;
				}
			}
			
			else
			{
				sortedName = last + ", " + first + ", " + middle;
			}
		}
		
		else
		{
			if(middle.compareTo(last) < 0)
			{
				if (last.compareTo(first) < 0)
				{
					sortedName = middle + ", " + last + ", " + first;
					
				}
				else
				{
					sortedName = middle +", " + first + ", " + last;
				}
			}
			else
			{
				sortedName = last + ", " + middle + ", " + first;
			}
		}
		
		return sortedName;
	}	
	
	public ArrayList<String> conversationPiece()
	{
		return conversationList;
	}
}
