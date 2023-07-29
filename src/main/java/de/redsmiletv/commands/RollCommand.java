package de.redsmiletv.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.Random;

public class RollCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (!event.getName().equals("roll")) {
            return;
        }
        OptionMapping maxDiceOption = event.getOption("sides");
        int maxDice = maxDiceOption.getAsInt();

        if (maxDice >= 1) {
            int diceOut = new Random().nextInt(maxDice) + 1;
            event.reply(String.valueOf(diceOut)).queue();
        }
        else
            event.reply("Please enter a valid number!").queue();
    }
}
