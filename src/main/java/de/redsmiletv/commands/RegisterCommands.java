package de.redsmiletv.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class RegisterCommands extends ListenerAdapter {
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();

        // /ping
        commandData.add(Commands.slash("ping", "Replies with pong!"));

        // /roll [maxDiceSide]
        OptionData rollOption = new OptionData(OptionType.INTEGER, "sides", "How many sides the dice should have", true);
        commandData.add(Commands.slash("roll", "Rolls a random number in a given range").addOptions(rollOption));

        // /redsmile
        commandData.add(Commands.slash("redsmile", "Displays redsmile in emojis"));

        // /say [input]
        OptionData sayInput = new OptionData(OptionType.STRING, "say", "What the bot should say", true);
        commandData.add(Commands.slash("say", "Let the bot say something").addOptions(sayInput));

        // /play [url/title]

        OptionData query = new OptionData(OptionType.STRING, "query", "The url or the title of the song you want to play", true);
        commandData.add(Commands.slash("play", "Plays the song you request into the vc you are in").addOptions(query));

        // /stop
        commandData.add(Commands.slash("stop", "Stops the song and leaves the vc"));

        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
