
package chat.controller;

import java.util.ArrayList;

import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatController {
	
	private ChatFrame chatFrame;
	private Chatbot appBot;
	
	
	public ChatFrame getChatFrame() {
		return chatFrame;
	}
	public void setChatFrame(ChatFrame chatFrame) {
		this.chatFrame = chatFrame;
	}
	public Chatbot getAppBot() {
		return appBot;
	}
	public void setAppBot(Chatbot appBot) {
		this.appBot = appBot;
	}
	
	
	
	public ChatController()
	{
		appBot = new Chatbot();
	}
	
	public void start()
	{
		chatFrame = new ChatFrame(this);
	}
	
	public String memeValidation(String currentInput)
	{
		String memeReaction = "Why aren't you talking about the memems?";
		
		if(appBot.memeChecker(currentInput))
		{
			memeReaction = currentInput + " is he coolest meme huh?";
		}
		
		return memeReaction;
	}
	
	public String stateValidation(String currentInput)
	{
		String stateReaction = "Why aren't you talking about the States?";
		
		if(appBot.memeChecker(currentInput))
		{
			stateReaction = currentInput + " is the coolest state huh?";
		}
		
		return stateReaction;
	}
	
	public String colorValidation(String currentInput)
	{
		String colorReaction = "Why aren't you talking about colores?";
		
		if(appBot.memeChecker(currentInput))
		{
			colorReaction = currentInput + " is the coolest colore huh?";
		}
		
		return colorReaction;
	}
	
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentPhrase = "";
		
		if(currentList.size() > 0)
		{
			currentPhrase = currentList.remove(0);
		}
		
		return currentPhrase;
	}
	
	public String dominateTheConversation()
	{
		String currentConversationPiece = "";
		
		currentConversationPiece = conversationHelper(appBot.conversationPiece());
		
		return currentConversationPiece;
	}
	
	public String processUserInput(String currentInput)
	{
		String response = "";
		
		if (appBot.memeChecker(currentInput))
		{
			response = "Memes!";
		}
		
		else if(true)
		{
			
		}
		
		return response;
	}
}
