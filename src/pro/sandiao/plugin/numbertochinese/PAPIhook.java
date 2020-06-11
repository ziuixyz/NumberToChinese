package pro.sandiao.plugin.numbertochinese;
import org.bukkit.entity.Player;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;
public class PAPIhook extends PlaceholderHook{
public boolean registerPlaceholder(){
return PlaceholderAPI.registerPlaceholderHook("NumberToChinese", this);}
@Override
public String onPlaceholderRequest(Player player,String string){
string=string.toLowerCase();int t;
if(string.length()>12&&string.substring(0,12).equals("traditional_")){
string=string.substring(12);t=1;}
else if(string.length()>6&&string.substring(0,6).equals("roman_")){
string=string.substring(6);
return new NumberToChineseAPI(0).getNumberToRoman(string);
}else{t=0;} NumberToChineseAPI ntc=new NumberToChineseAPI(t);
String parse=PlaceholderAPI.setPlaceholders(player,"%"+string+"%");
if(parse.equals("%"+string+"%")){
return ntc.getNumberToChinese(string);
}else{return ntc.getNumberToChinese(parse);}}}