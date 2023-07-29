package de.redsmiletv.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class SayCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("say")) {
            return;
        }

        OptionMapping input = event.getOption("say");

        if (input == null) {
            return;
        }

        event.reply(input.getAsString()).queue();
    }
}
