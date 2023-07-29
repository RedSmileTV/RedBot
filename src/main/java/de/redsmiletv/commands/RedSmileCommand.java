package de.redsmiletv.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RedSmileCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (!event.getName().equals("redsmile")) {
            return;
        }
        event.reply(":red_square::red_square::red_square::red_square::red_square::red_square::red_square::red_square:\n" +
                ":red_square::red_square::red_square::red_square::red_square::red_square::red_square::red_square:\n" +
                ":red_square::red_square::red_square::red_square::red_square::red_square::red_square::red_square:\n" +
                ":red_square::red_square::black_large_square::red_square::red_square::black_large_square::red_square::red_square:\n" +
                ":red_square::red_square::red_square::red_square::red_square::red_square::red_square::red_square:\n" +
                ":red_square::red_square::black_large_square::red_square::red_square::black_large_square::red_square::red_square:\n" +
                ":red_square::red_square::black_large_square::black_large_square::black_large_square::black_large_square::red_square::red_square:\n" +
                ":red_square::red_square::red_square::red_square::red_square::red_square::red_square::red_square:").queue();
    }
}
