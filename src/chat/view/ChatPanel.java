package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatController;
import chat.model.Chatbot;

public class ChatPanel extends JPanel 
{
	private ChatController baseController;
	private Chatbot appBot;
	
	private SpringLayout baseLayout;
	private JButton submitChatButton;
	private JTextField userTextField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private int clickCount;
	
	/**
	 * Creates a ChatbotPanel with a liked ChatbotController object.
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getAppBot();
		submitChatButton = new JButton("Click here to type to the chatbot!");
		baseLayout = new SpringLayout();
		userTextField = new JTextField(30);
		chatArea = new JTextArea(10, 30);
		chatPane = new JScrollPane(chatArea);
		
		clickCount = 0;


		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		setupChat();
	}
	
	/**
	 * Starts the Chatbot chat screen with a topic.
	 */
	private void setupChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}
	
	/**
	 * Loads all components into the panel and sets the layout manager in color.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(submitChatButton);
		this.add(userTextField);
		this.add(chatPane);
		
		
		
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		
	}
	
	/**
	 * Creates listeners for all user-interactive objects in the panel.
	 */
	private void setupListeners()
	{
		submitChatButton.addActionListener(new ActionListener()
		{
			/**
			 * Do this when the submitChatButton is clicked!
			 */
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String userInput = userTextField.getText();
				
				if(clickCount % 7 == 0)
				{
					String currentPhrase = baseController.dominateTheConversation();
					if(currentPhrase.length() != 0)
					{
						chatArea.append("\n" + currentPhrase);
						clickCount--;	
					}
					else if(clickCount % 5 == 0)
					{
						chatArea.append(baseController.memeValidation(userInput));
					}
					else if(clickCount % 3 == 0)
					{
						chatArea.append(baseController.stateValidation(userInput));
					}
					else if(clickCount % 9 == 0)
					{
						chatArea.append(baseController.colorValidation(userInput));
					}
					else
					{
						chatArea.append("\n" + userInput);
						
						String processedInput = baseController.processUserInput(userInput);
						chatArea.append(processedInput);
						
						userTextField.setText("");
						chatArea.append("\n" + appBot.getRandomTopic());
						
//						This should be a method in the controller that would be returned as a string to place in the chatArea.
						String me, you, other;
						me = "Cody";
						you = "Ryan";
						other = "Devvin";
						chatArea.append(appBot.putNameInAlphabeticalOrder(me, you, other));
					}
				}
			}
		});
	}
	
	/**
	 * Places all objects with the computer generated code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, submitChatButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 269, SpringLayout.WEST, submitChatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, submitChatButton, 248, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitChatButton, 128, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, userTextField, 142, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, userTextField, -69, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, userTextField, 308, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 102, SpringLayout.WEST, this);
	}
}
