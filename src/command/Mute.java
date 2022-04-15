package command;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Mute extends ListenerAdapter {

	@Override

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] args = e.getMessage().getContentRaw().split(" ");

		if (args[0].equalsIgnoreCase("!mute")) {
			if (args.length <= 1) {
				ErrorMessage(e.getChannel(), e.getMember());
			} else {
				Member target = e.getMessage().getMentionedMembers().get(0);

				Role muted = e.getGuild().getRoleById("862012851790151680");

				e.getGuild().addRoleToMember(target, muted).queue();

				if (args.length >= 3) {
					String raison = " ";
					for (int i = 2; i < args.length; i++) {
						raison += args[i] + " ";

					}
					log(target, e.getMember(), raison, e.getGuild().getTextChannelById("861872771256680488"));
				} else {
					log(target, e.getMember(), "", e.getGuild().getTextChannelById("861872771256680488"));

				}
			}
		}

	}

	public void ErrorMessage(TextChannel channel, Member member) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("Utilisation Invalide!");
		builder.setColor(Color.RED);
		builder.setDescription("{} = Obligatoire, [] = Optionel");
		builder.addField("Bonne utilisation: !mute {@user} [raison]", "", false);
		builder.setThumbnail("https://media.discordapp.net/attachments/861751870007803924/862144410183139349/dr_trans.png?width=473&height=473");
		channel.sendMessageEmbeds(builder.build()).queue();
	}

	public void log(Member muted, Member muter, String raison, TextChannel channel) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("Utilisateur Mute !");
		builder.setColor(Color.RED);
		builder.addField("Utilisateur Mute: ", muted.getAsMention(), false);
		builder.addField("Par: ", muter.getAsMention(), false);
		builder.addField("Raison:", raison, false);
		builder.addField("Date", sdf.format(date), false);
		builder.addField("Heure", stf.format(date), false);
		builder.setThumbnail("https://media.discordapp.net/attachments/861751870007803924/862144410183139349/dr_trans.png?width=473&height=473");
		channel.sendMessageEmbeds(builder.build()).queue();
	}
}
