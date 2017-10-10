public class MailBox{
	private MessageQueue newMessage;
	private MessageQueue oldMessage;
	private MessageQueue newName;
	private MessageQueue oldName;
	public MailBox(){
		newMessage = new MessageQueue();
		oldMessage = new MessageQueue();
		newName = new MessageQueue();
		oldName = new MessageQueue();
	}
	
	public void addMessage(String name, String mess){
		Message mes = new Message(mess);
		Message nam = new Message(name);
		newMessage.add(mes);
		newName.add(nam);
	}
	
	public String getMessage(){
		return newMessage.peek().getText();
	}
	public String getName(){
		if(newName.size()!=0)
		return newName.peek().getText();
		else{
			return null;
		}
	}
    public void keep(){
    	Message nem = newName.peek();
    	Message mes = newMessage.peek();
    	newMessage.remove();
    	newName.remove();	
    	oldMessage.add(mes);
    	oldName.add(nem);
    }
    
    public void erase(){
    	newMessage.remove();
    	newName.remove();
    }

    
}