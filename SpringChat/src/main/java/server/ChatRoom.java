package server;

import java.io.PrintStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import javax.security.auth.login.FailedLoginException;

import client.user.IChatUser;




public class ChatRoom extends UnicastRemoteObject implements IChatRoom {

	private static final long serialVersionUID = 1L;

	private Hashtable<String, IChatUser> users = new Hashtable<String, IChatUser>();

	private Hashtable<String, char[]> alloweduser = new Hashtable<String, char[]>();
	
	private static PrintStream serverPrintStream;

	// configurable option
	private boolean debug = false;

	public ChatRoom() throws RemoteException {
		super();
		alloweduser.put("toto", "passtoto".toCharArray());
		alloweduser.put("titi", "passtiti".toCharArray());
		alloweduser.put("testUser", "testPassword".toCharArray());

	}

	public void subscribe(IChatUser user, String pseudo) throws RemoteException {
		String message = "Connexion de " + pseudo;
		this.postMessage("ChatRoom", message);
		this.users.put(pseudo, user);
	}

	public void unsubscribe(String pseudo) throws RemoteException {
		String message = "Deconnexion de " + pseudo;
		this.users.remove(pseudo);
		this.postMessage("ChatRoom", message);
	}

	public void postMessage(String pseudo, String message) throws RemoteException {
		String fullMessage = pseudo + " >> " + message;
		for (IChatUser user : users.values()) {
			user.displayMessage(fullMessage);
		}
	}

	public boolean authentification(String username, char[] password) throws FailedLoginException, RemoteException {
		// verify the username/password
		boolean usernameCorrect = false;
		//boolean passwordCorrect = false;
		if (this.alloweduser.containsKey(username)) {
			usernameCorrect = true;
			if (password.length == this.alloweduser.get(username).length && testPassword(this.alloweduser.get(username), password)) {
				// authentication succeeded!!!
				//passwordCorrect = true;
				if (debug) {
					System.out.println("\t\t[SampleLoginModule] "
							+ "authentication succeeded");
				}					
				return true;
			}

		}
		// authentication failed -- clean out state
		if (debug) {
			System.out.println("\t\t[SampleLoginModule] "
					+ "authentication failed");
		}			
		for (int i = 0; i < password.length; i++) {
			password[i] = ' ';
		}
		if (!usernameCorrect) {
			throw new FailedLoginException("User Name Incorrect");
		} else {
			throw new FailedLoginException("Password Incorrect");
		}
	}

	private boolean testPassword(char[] cs, char[] password) {
		boolean result = true;
		int i = 0;
		while (i < cs.length && result) {
			if (cs[i] != password[i])
				result = false;
			i++;
		}
		return result;
	}
	
	public void logOnServer(String msg) throws RemoteException {
		serverPrintStream.println(msg);
	}

	public static void main(String[] args) throws Exception {
		serverPrintStream = System.err;
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			System.err.println("Il y a deja un registre de lancer");
		}

		ChatRoom room = new ChatRoom();
		Naming.rebind("ChatRoom", room);
	}
}
