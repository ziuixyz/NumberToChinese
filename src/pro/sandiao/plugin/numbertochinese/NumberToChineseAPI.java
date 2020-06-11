package pro.sandiao.plugin.numbertochinese;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
public class NumberToChineseAPI{
private String[]chnNumChar,chnUnitChar,chnUnitSection;
private String point,negative;
public NumberToChineseAPI(int SimplifiedOrTraditional){
if(SimplifiedOrTraditional==0){
chnNumChar=new String[]{"零","一","二","三","四","五","六","七","八","九"};
chnUnitChar=new String[]{"","十","百","千"};
chnUnitSection=new String[]{"","万","亿","亿万","亿亿","亿亿万","亿亿亿"};
point="点";negative="负";
}else{
chnNumChar=new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
chnUnitChar=new String[]{"","拾","佰","仟"};
chnUnitSection=new String[]{"","萬","億","億萬","億億","億億萬","億億億"};
point="點";negative="負";
}}
//Number To Chinese
public String getNumberToChinese(String number){
if(Pattern.compile("^(-?\\d+)(\\.\\d+)?$").matcher(number).matches()){
String symbol="";
if(number.contains("-")){symbol=negative;number=number.substring(1);}
String integer,decimal;
if(number.contains(".")){String[]numbers=number.split("\\.");
integer=numbers[0].toString();decimal=numbers[1].toString();
for(int i=0;i<chnNumChar.length;i++){
decimal=decimal.replace(String.valueOf(i),chnNumChar[i]);}
decimal=point+decimal;}else{integer=number;decimal="";}
if(integer.equals("0")){return symbol+"零"+decimal;};
integer=new StringBuffer(integer).reverse().toString();
while(integer.length()%4!=0){integer=integer+" ";}
String[]integers=new String[integer.length()/4];
for(int i=0;i<integer.length()/4;i++){integers[i]=integer.substring(i*4,i*4+4);}
integers[integers.length-1]=integers[integers.length-1].replace(" ","");
for(int i=0;i<integers.length;i++){String[]bit=integers[i].split("");
for(int x=0;x<bit.length;x++){if(bit[x].equals("0")){
bit[x]="零";}else{bit[x]=chnUnitChar[x]+chnNumChar[Integer.parseInt(bit[x])];};}
integers[i]=StringUtils.join(bit).replaceAll("零+","零");
if(integers[i].startsWith("零")){integers[i]=integers[i].substring(1);}
integers[i]=chnUnitSection[i]+integers[i];
if(Pattern.compile("^["+chnUnitSection[3]+"]+$").matcher(integers[i]).matches()){
integers[i]="零";}}
integer=StringUtils.join(integers).replaceAll("零+","零");
if(integer.substring(0,1).equals("零")){integer=integer.substring(1);}
integer=new StringBuffer(integer).reverse().toString();
if(integer.substring(0,1).equals("零")){integer=integer.substring(1);}
return symbol+integer+decimal;}
return number+" is Not Number";}
//Number To Roman
public String getNumberToRoman(String number){
if(Pattern.compile("^\\d+$").matcher(number).matches()){
int num = Integer.parseInt(number);if(0<num&&num<4000){
String[][]n= {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},{"","M","MM","MMM"}};
StringBuffer roman = new StringBuffer();roman.append(n[3][num / 1000 % 10]);
roman.append(n[2][num / 100 % 10]);roman.append(n[1][num / 10 % 10]);
roman.append(n[0][num % 10]);return roman.toString();}}
return number+" is Not Number (int 1-3999)";}}