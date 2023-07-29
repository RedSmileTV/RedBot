package de.redsmiletv;

import de.redsmiletv.commands.*;

import de.redsmiletv.music.MusicBot;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        File configFile = new File("redbot.properties");
        File srcFile = new File("src/main/resources/example.properties");

        if (!configFile.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(configFile));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        }

        FileInputStream input = new FileInputStream(configFile);
        Properties prop = new Properties();
        prop.load(input);

        String token = prop.getProperty("token");

        if (token.isEmpty() || token.equals("YOUR_BOT_TOKEN")) {
            System.out.println("Enter a valid bot token in the redbot.properties file!!!");
            return;
        }

        String activity = prop.getProperty("activity");
        String activityName = prop.getProperty("activity.name");
        String streamName = prop.getProperty("stream.name");
        String streamLink = prop.getProperty("stream.link");
        String ytAPI = prop.getProperty("yt.api");

        JDABuilder bot = JDABuilder.createDefault(token);
        bot.addEventListeners(new RegisterCommands(), new PingCommand(), new RollCommand(), new RedSmileCommand(),
                new SayCommand(), new MusicBot());


        switch (activity) {
            case "streaming":
                bot.setActivity(Activity.streaming(streamName, streamLink));
                break;

            case "playing":
                bot.setActivity(Activity.playing(activityName));
                break;

            case "watching":
                bot.setActivity(Activity.watching(activityName));
                break;

            case "listening":
                bot.setActivity(Activity.listening(activityName));
                break;

            case "competing":
                bot.setActivity(Activity.competing(activityName));
                break;

            default:
                bot.setActivity(Activity.streaming("RedSmileTV", "https://twitch.tv/redsmiletv"));
        }
        bot.build();
    }
}