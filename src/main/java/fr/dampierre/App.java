package fr.dampierre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        // launch();
        connexionBDD();
    }

    public static void connexionBDD() {

        String dbURL = "jdbc:mysql://localhost:3306/sample";
        String nomUtilisateur = "monid";
        String mdp = "monmotdepassefort";

        try {
            // Connexion en passant les informations spécifiées précédemment
            Connection conn = DriverManager.getConnection(dbURL, nomUtilisateur, mdp);
            // Si on est bien connecté à la DB
            if (conn != null) {
                // On affiche un petit message sur le terminal
                System.out.println("Connexion réussie !");
            }
        } catch (SQLException ex) {
            // Code de traitement d'erreur
            ex.printStackTrace();
        }

        String sql = "SELECT nom, email FROM utilisateurs";

        Statement requete = conn.createStatement();

        ResultSet res = requete.executeQuery(sql);

        int compteur = 0;

        while (res.next()) {
            compteur++;
            String nom = res.getString("nom");
            String email = res.getString("email");
            String sortie = "Utilisateur no. " + compteur + " : " + nom + " (" + email + ")";
            System.out.println(sortie);
        }
    }
}