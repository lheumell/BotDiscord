package botozor ;


import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.sql.Timestamp;
import java.util.Date;

import java.util.stream.Collectors;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/*
import net.dv8tion.jda.api.entities.Message;

import org.json.*;
import java.awt.Color;*/

public class MyListener extends ListenerAdapter {
    final String BOT_PREFIX = "/34";

    

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println(event);
        if (event.getAuthor().isBot())
            return;

       
        String content = event.getMessage().getContentDisplay();
        System.out.println(content);

      
                 /******PING*******/
        if (content.equals(BOT_PREFIX + " ping")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong " + event.getMember().getAsMention() + " !").queue();
        }

                 /******DICE*******/
       if (content.equals(BOT_PREFIX + " dice")) {
            MessageChannel channel = event.getChannel();
            String[] tab = content.split(" ");
            int number;
            if (tab.length == 2) {
                number = (int)(Math.random()*6);
            } else {
                number = (int)(Math.random()*(Integer.valueOf(tab[2])));
            }
            channel.sendMessage(event.getMember().getAsMention() + ", " + number + " !").queue();
        }

                 /******CAT*******/
        if (content.contains(BOT_PREFIX + " cat")) {
            MessageChannel channel = event.getChannel();

            if(content.contains("text")){
                String text = "" ;

                try {
                    URL url = new URL("https://cataas.com/cat/cat/says/" + text +"?color=red");
                    BufferedImage img = ImageIO.read(url);
                    File file = new File("temp.jpg");
                    ImageIO.write(img, "jpg", file);
                    event.getChannel().sendFile(file).queue();
                } catch (Exception e) {
                    event.getChannel().sendMessage("Probleme").queue();
                }
            }
                try {
                    URL url = new URL("https://cataas.com/cat");
                    BufferedImage img = ImageIO.read(url);
                    File file = new File("temp.jpg");
                    ImageIO.write(img, "jpg", file);
                    event.getChannel().sendFile(file).queue();
                } catch (Exception e) {
                    event.getChannel().sendMessage("Probleme").queue();
                }
              
        }
    }
}