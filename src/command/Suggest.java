package command;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Suggest extends ListenerAdapter {
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] args = e.getMessage().getContentRaw().split(" ");
		if (args[0].equalsIgnoreCase("!suggest")) {
			if (args.length <= 1)
				SuggestError(e.getChannel());

			if (args.length > 1) {
				String raison = " ";
				for(int i = 1; i < args.length; i++) {
					raison += args[i] + " ";
					
				}
				e.getMessage().delete().queue();
				Ticket(e.getGuild().getTextChannelById("861833287751958548"), e.getMember(), raison);
				

					}
				
				}

			}
		

	

	public void SuggestError(TextChannel channel) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("Utilisation Incorrect !");
		builder.setThumbnail(
				"https://media.discordapp.net/attachments/861751870007803924/862144410183139349/dr_trans.png?width=473&height=473");
		builder.setDescription("!suggest (suggestion...)");
		builder.setColor(Color.RED);
		channel.sendMessageEmbeds(builder.build()).queue();

	}

	public void Ticket(TextChannel channel, Member sender, String raison) {
		EmbedBuilder builder = new EmbedBuilder();
		
		builder.setAuthor(sender.getEffectiveName(),
				"https://media.discordapp.net/attachments/861751870007803924/862144410183139349/dr_trans.png?width=473&height=473 ",
				sender.getUser().getAvatarUrl());
		builder.addField("Suggestion: ", raison, false);
		builder.setColor(Color.BLUE);
		

		channel.sendMessageEmbeds(builder.build()).queue(message -> {
			  message.addReaction("✅").queue();
			  message.addReaction("❌").queue();
			  
		});

	}
}
