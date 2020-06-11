package pro.sandiao.plugin.numbertochinese;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
public class NumberToChinese extends JavaPlugin{
@Override
public void onEnable(){
if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI")!=null){
getLogger().info("我们找到了PAPI插件");
if(new PAPIhook().registerPlaceholder()){getLogger().info("我们成功的hook了");
getLogger().info("你可以使用%NumberToChinese%和%NumberToChinese_traditional%占位符了");
getLogger().info("例: %NumberToChinese_1% = \"一\"");
getLogger().info("例: %NumberToChinese_Traditional_1% = \"壹\"");
getLogger().info("例: %NumberToChinese_Roman_10% = \"X\"");
getLogger().info("我们允许你使用其它占位符 不需要加任何符号");
getLogger().info("例: %NumberToChinese_player_ping% = 当前延迟的中文化");}else{
getLogger().info("我们hook失败了");}
}else{getLogger().info("我们需要PlaceholderAPI插件作为前置");}}}