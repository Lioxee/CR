package bot;

import javax.security.auth.login.LoginException;

import command.Ban;
import command.Candidature;
import command.Help;
import command.Mute;
import command.Suggest;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	
	public static void main(String[]  args) {
		JDABuilder jdabuilder = JDABuilder.createDefault("ODYxODM5NDQ4MzUzOTMxMjY0.YOPoiA.sdCURrmr3YDCw4pqw_fZ34WDqK8");
		JDA jda;
		Help help = new Help();
		jdabuilder.addEventListeners(help);
		jdabuilder.setActivity(Activity.watching("Création de DreamRP"));
jdabuilder.addEventListeners(new Candidature());
		jdabuilder.addEventListeners(new Mute());
		jdabuilder.addEventListeners(new Suggest());
		jdabuilder.addEventListeners(new Ban());
		try {
			jda = jdabuilder.build(); }
				catch (LoginException e) {
					e.printStackTrace();
					
					
					
				}
			}
			
			
		
		
	}


