import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.update.GenericUserPresenceEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateActivitiesEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    
    
    //mainly used for debug to see if bot is working simple ping and pong setup with hi and hello
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){
        String[] MessageSent = event.getMessage().getContentRaw().split(" ");
        if (MessageSent[0].equalsIgnoreCase("hello") && !event.getAuthor().isBot())
            event.getChannel().sendMessage("HI").queue();
        }
    


        //Uses event listeners to determine if a user is playing a certain game and if they are they get banned with a custom message
        @Override
        public void onUserUpdateActivities(UserUpdateActivitiesEvent event){
            List<Activity> game = event.getNewValue();
            System.out.println(event.getNewValue());
            System.out.println(event.getMember().getId());
            if ( game.toString().contains("Genshin"))
            {
                String j = event.getMember().getAsMention();
                event.getGuild().getTextChannelById("888266443467145308").sendMessage(j + " was playing Genshin").queue();
                event.getMember().ban(0, "Not allowed!").queue();
            }
        }
    
    
    }
		
	

