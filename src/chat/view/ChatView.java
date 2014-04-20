package chat.view;

import javax.swing.JOptionPane;

import chat.model.Chatbot;

public class ChatView 
{
private Chatbot myChatBot;
	
	
	
	public ChatView()
	{
		myChatBot = new Chatbot();
	}
	
	public void showChatController()
	{
		String input = "keep going";
		
		while(input == null || !input.equals("no"))
		{
			JOptionPane.showMessageDialog(null, myChatBot.getRandomTopic());
			input = getInput();
			useInput(input);
		}
		
		myChatBot.conversationPiece();
	}
	
	private String getInput()
	{
		String input = "";
		
		input = JOptionPane.showInputDialog("Would you like to talk with me?");
		
		return input;
	}
	
	private void useInput (String userInput)
	{
		if(myChatBot.memeChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "you knew that " + userInput + " is a meme!!!");
		}
		
		else if(myChatBot.colorChecker(userInput));
		{
			JOptionPane.showMessageDialog(null, "I can tell that " + userInput + "is a color!");
		}
		
		JOptionPane.showMessageDialog(null, "Wow that is so interestion that you want to talk with me about " +  userInput);
	}

}
