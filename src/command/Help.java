package command;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		if (e.getMessage().getContentRaw().equals("!help")) {
			helpEmbed(e.getTextChannel());

		}

	}

	public void helpEmbed(TextChannel channel) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("**Liste des Commandes Éxécutable**");
		builder.setColor(Color.BLUE);
		builder.addField("!mute  :  Permet de mute un compte sur les cannaux textuel", "", false);
		builder.addField("!ban  :   Permet de bannir un compte du serveur", "", false);
		builder.addField("!suggest : Permet de faire des suggestions pour améliorer le serveur", "", false);
		builder.setThumbnail("https://media.discordapp.net/attachments/861751870007803924/862144410183139349/dr_trans.png?width=473&height=473");
		channel.sendMessageEmbeds(builder.build()).queue();

	}
}
