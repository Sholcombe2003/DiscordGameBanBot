import java.security.AllPermission;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class BotStartup {
	public static void main(String [] args) throws LoginException {
		JDABuilder jda = JDABuilder.createDefault("API Token goes Here");
	jda.setActivity(Activity.playing("Watching"));
	jda.setStatus(OnlineStatus.ONLINE);
	jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
	jda.enableIntents(GatewayIntent.GUILD_MESSAGES);
	jda.enableIntents(GatewayIntent.GUILD_PRESENCES);
	jda.setMemberCachePolicy(MemberCachePolicy.ALL);
	jda.enableCache(CacheFlag.ACTIVITY);
	jda.addEventListeners(new Commands());
	jda.build();
	System.out.println("Bot Started!");
	}
}
