package de.redsmiletv.music;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class MusicBot extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        Member member = event.getMember();

        if (!member.getVoiceState().inAudioChannel()) {
            event.reply("You are not in a Voicechannel!").queue();
            return;
        }

        VoiceChannel voiceChannel = member.getVoiceState().getChannel().asVoiceChannel();
        PlayerManager playerManager = PlayerManager.get();

        switch (event.getName()) {
            case "play":
                connect(voiceChannel);
                OptionMapping query = event.getOption("query");
                String queryStr = query.getAsString();
                playerManager.play(event.getGuild(), queryStr, event);
                event.reply("Now playing " + queryStr).queue();
                break;

            case "stop":
                playerManager.stop(event.getGuild());
                event.reply("Bot has left the Channel").queue();
                break;
        }
    }
    public void connect(VoiceChannel vc) {
        vc.getGuild().getAudioManager().openAudioConnection(vc);
    }
}
