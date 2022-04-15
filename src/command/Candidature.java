package command;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Candidature extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] args = e.getMessage().getContentRaw().split(" ");
		if (args[0].equalsIgnoreCase("!candidature")) {
			if (args.length <= 1)
				e.getAuthor().openPrivateChannel().flatMap(channel -> channel
						.sendMessage("Hey !, pour envoyer une candidature tu dois utiliser la syntaxe suivante :"))
						.queue();
			e.getMessage().delete().queue();
			if (args.length > 1) {
				String candid = " ";
				for (int i = 1; i < args.length; i++) {
					candid += args[i] + " ";
				}
				e.getMessage().delete().queue();
				Candid(e.getGuild().getTextChannelById("862079388970909696"), e.getMember(), candid);
			}
		}

	}

	public void Candid(TextChannel channel, Member member, String candid) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setAuthor(member.getEffectiveName(),
				"https://media.discordapp.net/attachments/861751870007803924/862144410183139349/dr_trans.png?width=473&height=473",
				member.getUser().getAvatarUrl());
		builder.addField("Candidature", candid, false);
		builder.setColor(Color.GREEN);
		channel.sendMessageEmbeds(builder.build()).queue();

	}
}
