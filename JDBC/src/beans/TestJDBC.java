package beans;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestJDBC {
	
	/* La liste qui contiendra tous les résultats de nos essais */
	private List<String> messages = new ArrayList<String>();
	
	public List<String> executerTests(HttpServletRequest request){
		/* Ici nous placerons le code de nos manipulations */ 
		/* Chargement du driver JDBC pour MYSQL */
		try {
			messages.add("Chargement du driver...");
			Class.forName("con.mysql.jdbc.Driver");
			messages.add("Driver chargé !");
		} catch (ClassNotFoundException e) {
			messages.add("Erreur lors du chargement : le driver n'est pa été trouvé  dans la classepath ! </br>"+e.getMessage());
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/work";
		String utilisateur = "root";
		String motDepasse ="";
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			messages.add("Connexion à la base de données...");
			connexion=(Connection) DriverManager.getConnection(url, utilisateur, motDepasse);
			messages.add("Connexion réussie !");
			
			/* Création de l'objet gérant les requêtes */
			statement = (Statement) connexion.createStatement();
			messages.add("Objet requête crée !");
			resultat = statement.executeQuery("SELECT id,email,mot_de_passe,nom FROM Utilisateur;");
			messages.add("Requête \"SELECT id,email,mot_de_passe,nom FROM Utilisateur;\" effectuée !");
			
			/* Récupération des données du résultat de la requête de lecture */ 
			while (resultat.next()) {
				int idUtilisateur = resultat.getInt("id");
				String emailUtilisateur = resultat.getString("email");
				String motDePasseUtilisateur = resultat.getString("mot_de_passe");
				String nomUtilisateur = resultat.getString("nom");
				messages.add("Données retournées par la requête : id = " + idUtilisateur + ",email = " + emailUtilisateur + ",motdepasse = " + motDePasseUtilisateur + ",nom = " + nomUtilisateur + ".");
			}
			} catch (SQLException e){
				messages.add("Erreur lors de la connexion : <br/>"+e.getMessage());
			} finally {
				messages.add("Fermeture de l'objet ResultSet.");
				if(resultat!=null) {
					try {
						resultat.close();
						
					} catch (SQLException ignore) {
						
					}
				}
				
				messages.add("Fermeture de l'objet  Connection.");
				if(connexion!=null) {
					try {
						connexion.close();
					} catch (SQLException ignore) {
						
					}
				}
		}
		
		return messages;
	}
}
