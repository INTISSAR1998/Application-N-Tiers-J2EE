package Beans;

public class Client {
	
	private int NumCompte ;
	private String Nom;
	private double Solde;
	private String Login;
	private String Password;
	
	public int getNumCompte() {
		return NumCompte;
	}
	
	public void setNumCompte(int numCompte) {
		NumCompte = numCompte;
	}
	
	public String getNom() {
		return Nom;
	}
	
	public void setNom(String nom) {
		Nom = nom;
	}
	
	public double getSolde() {
		return Solde;
	}
	
	public void setSolde(double solde) {
		Solde = solde;
	}
	
	public String getLogin() {
		return Login;
	}
	
	public void setLogin(String login) {
		Login = login;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public Client() {
		
	}

	public Client(String login, String password) {
		super();
		Login = login;
		Password = password;
	}
	
	public Client(int numCompte) {
		super();
		NumCompte = numCompte;
	}

	public boolean Authentification(Client c) {
		if (c.getLogin().equals("admin") && c.getPassword().equals("admin") ) {
			return true;}
		else { return false; }
	}
	
	public float Transaction(float montant,String operation) {
		 if(operation =="virement") {
			 if (montant>0){
					Solde=Solde+montant;
					System.out.println("Virement réussi ! Nouveau Solde : "+Solde);
					return((float) Solde);
			}	
			else{
				System.out.println("Virement echoué !");
				return (0);	
			} 
		 }
		 
		 else if(operation =="retrait") {
			 if (montant>0 && montant<Solde){
			     	Solde=Solde-montant;
					System.out.println("Retrait réussi ! Nouveau Solde : +Solde");
					return((float)Solde);
				}
				else{
					System.out.println("Retrait echoué !");
					return (0);
				}
		 }
		 
		 else 
			 return 0;
	}
	
}
