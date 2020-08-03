package botozor;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
/*
import net.dv8tion.jda.api.hooks.EventListener;
*/
public class Bot {
    public static void main(String[] args) throws LoginException {
        System.out.println("Launching Botozor...");
        try {
            JDA jda = new JDABuilder("Njk0MTQ3MDg5NDMyNTc2MDEw.XqWjzw.duy64xVE5gmrWYB2BAKsJh-ZwiY").build();
            jda.addEventListener(new MyListener());
            System.out.println("Botozor is online ! ;)");
        } catch (Exception e) {
            System.out.println("Erreur lors du démarrage de Botozor : " + e);
        }
    }
}