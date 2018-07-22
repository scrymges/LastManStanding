import java.util.*;
import java.io.*;

public class Format {
    private static String[] WordSet1 = new String[]{"ah","aim","air","airs","am","arch","arcs","as","cam","cars","chaos","char","charm","charms","chasm","choir","coma","cor","corm","corms","cosh","cram","crash","fair","fairs","farm","farms","firm","firms","firs","foam","foci","form","forms","from","frosh","ha","hair","ham","harm","hi","him","his","hm","is","ma","macho","macs","marsh","mi","mica","micro","micros","mics","mocha","mohair","oaf","oafs","oars","och","of","oh","ohms","oi","rash","rich","roach","roam","sac","sari","scam","scarf","scram","sham","sofa","soh"};
    private static String[] WordSet2 = new String[]{"aim","am","as","at","ate","atom","atoms","awe","awes","emits","is","item","its","ma","matzo","maws","maze","me","meat","meats","meows","met","mews","mi","miaows","mist","mite","moat","moats","moist","most","mote","mow","mows","oats","oi","omit","owe","owes","sea","seam","seat","semi","set","sew","site","steam","stew","stow","swami","swat","swim","swiz","swot","tame","tames","tea","team","teas","ti","ties","times","to","toes","tomes","two","twos","wait","waits","was","waste","we","wets","wit","zits"};
    private static String[] WordSet3 = new String[]{"ail","aisle","aloes","also","apex","apse","as","asp","ax","axis","axles","ex","expo","fix","fixes","flaps","fleas","flies","flip","floes","flops","foal","foe","foil","fop","fops","fox","foxes","is","lap","laps","lax","leaf","leap","lexis","lie","lies","lo","loaf","lope","lopes","lops","lose","lox","oaf","oafs","of","oi","opals","pails","peals","peas","peso","pies","pilafs","pixel","plea","pleas","plies","pose","safe","sail","sap","sea","silo","six","slope","soap","sofa","soil","sop","sox","spa","spiel","spoil"};
    private static String[] WordSet4 = new String[]{"ages","ago","am","amuse","as","at","ate","atom","atoms","auto","ego","emus","gamut" ,"gate","gates", "gems","gets","goat" ,"goes" ,"guest", "gum" ,"gut","guts","ma" ,"me" ,"meat" ,"meats" ,"mega" ,"memo","memos" ,"met" ,"moat" ,"moats" ,"most", "mote" ,"mug" ,"mugs" ,"mum" ,"mute", "oats", "omega","oust" ,"out","outages","outs" ,"sag" ,"saute" ,"sea" ,"seam" ,"seat", "set" ,"smug" ,"sou", "stag","steam", "tags","tame" ,"tames" ,"tea" ,"team" ,"teas" ,"to","toes","tog","togas","togs","tomes","tug","tum","tums","um","us","usage","use"};
    private static String[] WordSet5 = new String[]{"air","airs","apse","are","arise","ark","as","ask","asp","ayes","ear", "ears","easy", "era", "eras" ,"irks", "is" ,"kip" ,"pare" ,"park", "parks", "pay" ,"payers","pays", "peak", "peaky" ,"peas" ,"perks" ,"pier" ,"pies", "pikes" ,"pray" ,"prey","pry" ,"pyres" ,"rape", "rapes" ,"raps", "rasp" ,"ray", "rays" ,"reap" ,"rep" ,"rip","rise" ,"risk", "risky" ,"rye", "sake", "sap", "sari" ,"sarky" ,"say" ,"sea", "sire","ska", "ski", "skier", "sky", "spa" ,"spake" ,"spar", "sparky", "spay", "speak","spear", "spik" ,"spire" ,"spray" ,"spry" ,"yaks", "yap","yea", "year" ,"yer"};
    private static String[] WordSet6 = new String[]{"cine","clef","climes","clone","clones","close","coil","coin","coins", "cols","come", "cone", "cones", "conies" ,"cosine" ,"elfin", "elm" ,"eons", "fen" ,"fens" ,"fine" ,"fines" ,"fins", "flies", "floes", "foci", "foe", "foil" ,"ice" ,"ices", "inclose", "incomes" ,"info" ,"insole" ,"ions", "is" ,"lemon" ,"lesion", "lice","lie", "lien" ,"lies" ,"limes" ,"limos" ,"line" ,"lines", "lions", "lo", "lone", "lose", "me", "melons", "mi", "mics", "miles" ,"minces" ,"mine", "monies", "no" ,"noes", "noise", "of", "oi", "oilmen" ,"omen" ,"on" ,"one", "scone", "semi" ,"silo", "sin" ,"slice", "slim", "soil", "solemn"};
    private static String[] WordSet7 = new String[]{"ad","ads","ah","ahem","am","amps","amuse","aped","apse","as","asp","dam", "dame" ,"dams", "deems" ,"dues" ,"dump" ,"eased" ,"eh" ,"emus" ,"ha" ,"ham" ,"he" ,"heads" ,"heaped", "heaps" ,"heed" ,"heeds" ,"hemp" ,"hm", "hues" ,"humped" ,"hums" ,"ma", "maps" ,"mashed", "me" ,"meshed", "mud" ,"mused" ,"mush" ,"pad", "pads" ,"pause" ,"peas" ,"peed" ,"pees", "phased" ,"pseud", "pud" ,"puds" ,"puma" ,"pus" ,"sadhu" ,"sap" ,"sea" ,"seam", "seamed" ,"see" ,"seem" ,"shade" ,"sham" ,"shamed" ,"shaped" ,"she" ,"spa" ,"spade" ,"sped", "speed" ,"sued" ,"sump" ,"um" ,"ump" ,"up" ,"us","use"};
    private static String[] WordSet8 = new String[]{"agates","agent","ages","an","anew","angst","ant","antes", "ants" ,"any" ,"as" ,"at", "ate" ,"awe", "awes", "ayes", "easy" ,"gate", "gates" ,"gateways","gent" ,"gents", "getaway" ,"gets" ,"gnats" ,"gnaws" ,"nags" ,"nay", "net" ,"news" ,"newsy" ,"newts", "sag" ,"sang", "satay" ,"say" ,"sea", "seat" ,"set" ,"sew" ,"snag", "stag" ,"stagy", "stew" ,"sty" ,"swat", "sway" ,"sweaty", "tags", "tan", "tang" ,"tangs" ,"tans", "tea", "teas" ,"tens", "twang" ,"wag" ,"wags" ,"wan" ,"wants" ,"was", "waste" ,"way", "we" ,"weans", "wets" ,"yawn", "yaws", "yea", "yeast" ,"yens", "yet" ,"yews"};
    private static String[] WordSet9 = new String[]{"aah","abase","aces","ache","aches","acres","ah","arch", "arches", "arcs" ,"are" ,"areas", "as", "aware", "awash", "awe", "awes", "baa", "bar" ,"bars" ,"baser" ,"beach" ,"bear" ,"bears", "bra", "brae" ,"bras" ,"brew" ,"caber", "care" ,"cars", "cashew" ,"caws" ,"char" ,"chase" ,"chaser", "chews", "crash" ,"crew" ,"each" ,"ear" ,"ears" ,"eh", "era", "eras", "ha" ,"hawser", "he" ,"hears" ,"her" ,"hew" ,"hews" ,"races" ,"rash" ,"reach" ,"rehab" ,"sabre", "sac", "scab", "scarab" ,"screw", "sea" ,"search", "sew", "she", "shear" ,"swear", "war", "wars", "was", "washer", "we", "wear" ,"wears"};
    private static String[] WordSet10 = new String[]{"deems","demon","demos","dens","dent","do","doe","dome" ,"domes" ,"done", "dons", "dose" ,"dost" ,"dote", "dotes", "emend", "emoted", "end" ,"eons", "ex" ,"extend", "me", "meet", "mends", "met" ,"meted" ,"mode" ,"modest" ,"mods" ,"most" ,"mote", "nee" ,"needs" ,"nested", "net", "no" ,"nod", "node", "nods" ,"noes", "not", "note", "ode", "omen", "on", "one" ,"onset" ,"oxen", "see" ,"seem", "seen", "set" ,"sexed" ,"sexton", "snot", "sod", "sox" ,"steno" ,"stoned" ,"ted", "teds" ,"teed" ,"teem", "teen", "tees", "tend" ,"tens", "tensed" ,"to" ,"toed", "toes", "tomes", "ton" ,"toned" ,"tones", "tons"};
    private static String[] WordSet11 = new String[]{"ah","aim","air","airs","am","amps","an","anus","as" ,"asp", "ha" ,"hair", "ham" ,"harm", "harps", "hi", "him" ,"hip", "hips" ,"his", "hm" ,"human" ,"hums", "imp" ,"imps" ,"is" ,"ma", "mains" ,"man" ,"mans" ,"maps" ,"marsh", "mi", "mush" ,"nap", "pan", "parish", "prams" ,"puma" ,"pun", "puns" ,"purism" ,"pus", "ramps" ,"ran" ,"rani", "raps", "rash", "rasp", "rip", "ruins", "rum" ,"rump" ,"rums", "sap", "sari" ,"sham", "shin" ,"shrimp" ,"shun", "sin" ,"spa", "spar" ,"spin" ,"spun" ,"spur" ,"spurn" ,"sump", "sun" ,"um" ,"ump", "unis", "up", "urn", "us"};
    private static String[] WordSet12 = new String[]{"abase","abate","abet","abreast","am","are","areas","arts","as","at" ,"ate", "ax" ,"baa", "bar" ,"barest","bars" ,"baser" ,"baste" ,"bat", "beams" ,"bear" ,"bears" ,"beat" ,"beats","beta" ,"bets", "bra", "brae" ,"bras", "brats", "breast", "ear", "ears", "era", "eras", "ex", "exams" ,"ma" ,"mares" ,"mart", "marts" ,"master" ,"maters", "me" ,"meat", "meats" ,"met", "rat", "rate", "reams" ,"resat", "rest", "sabre" ,"sea" ,"seam", "seat", "set" ,"smear" ,"star", "steam", "tab" ,"tabs" ,"tame", "tamer" ,"tames" ,"tar", "tars", "tax" ,"taxes", "tea", "team", "teas", "tram" ,"tsar"};
    private static String[] WordSet13 = new String[]{"aeons","ah","an","anew","anise","as","awe","awes","ban","bane","banish" ,"bans" ,"bins", "bison" ,"boa" ,"bones", "bonsai" ,"bows" ,"eh" ,"eons" ,"ha" ,"he", "hen" ,"hew" ,"hews" ,"hi", "hies" ,"his" ,"hob" ,"hobs" ,"hoe" ,"hose" ,"ions" ,"is", "nab" ,"news" ,"nibs" ,"no", "nobs", "noes", "noise", "now", "oh", "oi" ,"on", "one", "owe" ,"owes", "own", "owns", "sea", "sew" ,"she", "shin", "shoe", "shone", "show", "sin" ,"snow" ,"soh" ,"sown", "swain" ,"swine" ,"wan" ,"was", "we" ,"weans" ,"when", "whoa", "wines", "wino", "wins" ,"wish" ,"won"};
    private static String[] WordSet14 = new String[]{"ah","apse","are","as","asp","awe","awes","ear","ears","eh","era","eras" ,"ha", "harps", "hawser" ,"haze" ,"hazes" ,"he", "heaps", "hears" ,"her" ,"hew", "hews" ,"hues" ,"pare" ,"pause" ,"paw", "peas", "pew" ,"phrase", "purse", "pus", "pusher" ,"rape" ,"rapes" ,"raps" ,"rash" ,"rasp" ,"reap" ,"rep", "rue", "rues", "sap", "sea" ,"seraph" ,"sew", "she", "shear", "spa", "spar", "spear", "spew" ,"spur", "super" ,"sure" ,"swap" ,"swear", "up", "us", "use" ,"user" ,"war" ,"warp" ,"warps" ,"wars" ,"was" ,"washer", "we", "wear", "wears", "whups" ,"wrap", "wraps" ,"zap", "zaps"};
    private static String[] WordSet15 = new String[]{"ail","aim","air","airs","also","am","amours","arcs","as","calms", "cam" ,"carol", "cars", "claims" ,"clamor" ,"clamors", "coil" ,"cola" ,"cols", "coma", "cor", "corals" ,"corm", "corms", "cram" ,"cum" ,"curio" ,"curs" ,"is", "lairs", "liars", "limos" ,"lo", "loam", "locums" ,"lour" ,"ma", "macs" ,"mail", "mails", "mauls" ,"mi" ,"mica", "micro" ,"micros", "mics" ,"molar" ,"murals", "music", "oars" ,"oi" ,"ours" ,"rail" ,"roam" ,"roils", "rum" ,"rums" ,"sac", "sail" ,"sari", "scam" ,"scour" ,"scram", "scrum", "silo", "slam" ,"slim" ,"soil" ,"solar", "sou", "soul" ,"sour", "um", "uric" ,"us"};
    private static String[] WordSet16 = new String[]{"ad","ah","an","anode","ant","at","ate","atone","attuned","aunt", "auto", "daunt", "dean" ,"death" ,"dent", "do", "doe", "donate", "done" ,"dote", "dune", "eh" ,"end", "ha" ,"hand", "handout", "hat" ,"hated" ,"haunt" ,"he" ,"hen" ,"hod", "hoe" ,"honed", "hot" ,"hunted" ,"hut", "net", "nett" ,"no", "nod" ,"node" ,"not" ,"note" ,"nut" ,"nutted" ,"ode" ,"oh" ,"on","one" ,"out" ,"tan", "taunted" ,"taut", "tea" ,"teat", "ted" ,"tend", "tent" ,"than" ,"the" ,"then" ,"thou", "thud" ,"to", "toed", "ton" ,"toned" ,"tot" ,"toted" ,"touted" ,"tuned" ,"tut" ,"undo", "unto"};


    private static String[] WordSetEx1 = new String[]{"ah","aim","air","airs","am","arch","arcs","as","cam","cars","chaos","char","charm","charms","chasm","choir","coma","cor","corm","corms","cosh","cram","crash","fair","fairs","farm","farms","firm","firms","firs","foam","foci","form","forms","from","frosh","ha","hair","ham","harm","hi","him","his","hm","is","ma","macho","macs","marsh","mi","mica","micro","micros","mics","mocha","mohair","oaf","oafs","oars","och","of","oh","ohms","oi","rash","rich","roach","roam","sac","sari","scam","scarf","scram","sham","sofa","soh","or","so","arm","arc","car","far","fir","for","has","ram","rim","aims","cash","fish","mars","mash","oar","rams","scar","chair","hairs","harms","chairs","choirs","fiasco","mosaic","racism","mohairs","if","sir","ash","im","soar","hams","ho"};
    private static String[] WordSetEx2 = new String[]{"aim","am","as","at","ate","atom","atoms","awe","awes","emits","is","item","its","ma","matzo","maws","maze","me","meat","meats","meows","met","mews","mi","miaows","mist","mite","moat","moats","moist","most","mote","mow","mows","oats","oi","omit","owe","owes","sea","seam","seat","semi","set","sew","site","steam","stew","stow","swami","swat","swim","swiz","swot","tame","tames","tea","team","teas","ti","ties","times","to","toes","tomes","two","twos","wait","waits","was","waste","we","wets","wit","zits","it","so","eat","mat","maw","oat","sat","saw","sit","tow","wet","zit","aims","east","eats","emit","mast","mate","mats","meta","same","size","some","stem","swam","time","west","wise","zest","woe","smite","tows","toe","tome","tie","meow","mates","mit","sow","maize","tom","mit","mits","im"};
    private static String[] WordSetEx3 = new String[]{"ail","aisle","aloes","also","apex","apse","as","asp","ax","axis","axles","ex","expo","fix","fixes","flaps","fleas","flies","flip","floes","flops","foal","foe","foil","fop","fops","fox","foxes","is","lap","laps","lax","leaf","leap","lexis","lie","lies","lo","loaf","lope","lopes","lops","lose","lox","oaf","oafs","of","oi","opals","pails","peals","peas","peso","pies","pilafs","pixel","plea","pleas","plies","pose","safe","sail","sap","sea","silo","six","slope","soap","sofa","soil","sop","sox","spa","spiel","spoil","if","so","ale","ape","elf","oil","pea","pie","sex","sip","ales","alps","axel","fail","file","flap","flea","flop","isle","life","lips","lisp","oils","pale","peal","pile","pole","seal","self","slap","slip","sole","fails","false","fax","faxes","flips","lapse","leafs","pales","piles","poise","poles","spoil","pixels","lip","pal","pix","pail","sale","files","pox","pax","sil","flex","axe","axes","leaps","slop"};
    private static String[] WordSetEx4 = new String[]{"ages","ago","am","amuse","as","at","ate","atom","atoms","auto","ego","emus","gamut" ,"gate","gates", "gems","gets","goat" ,"goes" ,"guest", "gum" ,"gut","guts","ma" ,"me" ,"meat" ,"meats" ,"mega" ,"memo","memos" ,"met" ,"moat" ,"moats" ,"most", "mote" ,"mug" ,"mugs" ,"mum" ,"mute", "oats", "omega","oust" ,"out","outages","outs" ,"sag" ,"saute" ,"sea" ,"seam" ,"seat", "set" ,"smug" ,"sou", "stag","steam", "tags","tame" ,"tames" ,"tea" ,"team" ,"teas" ,"to","toes","tog","togas","togs","tomes","tug","tum","tums","um","us","usage","use","go","so","ages","eat","gas","gem","get","got","mat","oat","sat","sue","sum","tab","tag","east","eats","egos","game","gout","gums","gust","mast","mate","mats","mums","muse","must","sage","same","smog","smut","some","stem","sumo","tugs","games","magot","mouse","mutes","stage","teams","toe","goats","mates","tome","age","mom","gast","tom"};
    private static String[] WordSetEx5 = new String[]{"air","airs","apse","are","arise","ark","as","ask","asp","ayes","ear", "ears","easy", "era", "eras" ,"irks", "is" ,"kip" ,"pare" ,"park", "parks", "pay" ,"payers","pays", "peak", "peaky" ,"peas" ,"perks" ,"pier" ,"pies", "pikes" ,"pray" ,"prey","pry" ,"pyres" ,"rape", "rapes" ,"raps", "rasp" ,"ray", "rays" ,"reap" ,"rep" ,"rip","rise" ,"risk", "risky" ,"rye", "sake", "sap", "sari" ,"sarky" ,"say" ,"sea", "sire","ska", "ski", "skier", "sky", "spa" ,"spake" ,"spar", "sparky", "spay", "speak","spear", "spik" ,"spire" ,"spray" ,"spry" ,"yaks", "yap","yea", "year" ,"yer","ape","irk","key","par","pea","per","pie","rap","sip","sir","spy","yak","yip","arks","arse","bars","bra","bar","pair","pars","pear","perk","pike","rake","ripe","skip","pairs","payer","peaks","pears","perky","piers","prays","prise","raise","rakes","reaps","repay","spare","spike","years","kaiser","praise","repays","yes","keys","sear","yikes","apes","aye","rase","yipe","yaps","yips","kips"};
    private static String[] WordSetEx6 = new String[]{"cine","clef","climes","clone","clones","close","coil","coin","coins", "cols","come", "cone", "cones", "conies" ,"cosine" ,"elfin", "elm" ,"eons", "fen" ,"fens" ,"fine" ,"fines" ,"fins", "flies", "floes", "foci", "foe", "foil" ,"ice" ,"ices", "inclose", "incomes" ,"info" ,"insole" ,"ions", "is" ,"lemon" ,"lesion", "lice","lie", "lien" ,"lies" ,"limes" ,"limos" ,"line" ,"lines", "lions", "lo", "lone", "lose", "me", "melons", "mi", "mics", "miles" ,"minces" ,"mine", "monies", "no" ,"noes", "noise", "of", "oi", "oilmen" ,"omen" ,"on" ,"one", "scone", "semi" ,"silo", "sin" ,"slice", "slim", "soil", "solemn","if","in","so","con","ion","men","nil","oil","son","cons","file","film","foes","icon","isle","life","lime","limo","lino","lion","mice","mile","mole","nice","noel","nose","oils","once","ones","self","slob","coils","comes","files","films","foils","icons","limos","melon","mince","moles","omens","since","smile","sonic","lemons","income","some","cole","sole","sil","im"};
    private static String[] WordSetEx7 = new String[]{"ad","ads","ah","ahem","am","amps","amuse","aped","apse","as","asp","dam", "dame" ,"dams", "deems" ,"dues" ,"dump" ,"eased" ,"eh" ,"emus" ,"ha" ,"ham" ,"he" ,"heads" ,"heaped", "heaps" ,"heed" ,"heeds" ,"hemp" ,"hm", "hues" ,"humped" ,"hums" ,"ma", "maps" ,"mashed", "me" ,"meshed", "mud" ,"mused" ,"mush" ,"pad", "pads" ,"pause" ,"peas" ,"peed" ,"pees", "phased" ,"pseud", "pud" ,"puds" ,"puma" ,"pus" ,"sadhu" ,"sap" ,"sea" ,"seam", "seamed" ,"see" ,"seem" ,"shade" ,"sham" ,"shamed" ,"shaped" ,"she" ,"spa" ,"spade" ,"sped", "speed" ,"sued" ,"sump" ,"um" ,"ump" ,"up" ,"us","use","amp","ape","ash","had","has","hue","hum","map","pea","pee","sad","sue","sum","sup","apes","damp","dash","deem","deep","dupe","ease","heap","head","hump","made","mash","muse","push","same","seed","seep","seem","shed","used","dumps","humps","phase","shame","shape","sheep","spued","suede","amused","paused","pushed","mad","mead","due","dee","spam","hem","dames","muds","heep","mesh"};
    private static String[] WordSetEx8 = new String[]{"agates","agent","ages","an","anew","angst","ant","antes", "ants" ,"any" ,"as" ,"at", "ate" ,"awe", "awes", "ayes", "easy" ,"gate", "gates" ,"gateways","gent" ,"gents", "getaway" ,"gets" ,"gnats" ,"gnaws" ,"nags" ,"nay", "net" ,"news" ,"newsy" ,"newts", "sag" ,"sang", "satay" ,"say" ,"sea", "seat" ,"set" ,"sew" ,"snag", "stag" ,"stagy", "stew" ,"sty" ,"swat", "sway" ,"sweaty", "tags", "tan", "tang" ,"tangs" ,"tans", "tea", "teas" ,"tens", "twang" ,"wag" ,"wags" ,"wan" ,"wants" ,"was", "waste" ,"way", "we" ,"weans", "wets" ,"yawn", "yaws", "yea", "yeast" ,"yens", "yet" ,"yews","age","eat","gas","gay","get","nag","new","sat","saw","tag","ten","way","wet","yen","yes","away","east","eats","gays","gnaw","gnat","neat","nest","nets","newt","saga","sage","sang","sawn","sent","sewn","stay","wage","wane","want","ways","went","west","nasty","stage","wages","wanes","agents","gateway","wastage","gateways","getaways","swan","sane","wasnt","tee","sate","yew","yaw"};
    private static String[] WordSetEx9 = new String[]{"aah","abase","aces","ache","aches","acres","ah","arch", "arches", "arcs" ,"are" ,"areas", "as", "aware", "awash", "awe", "awes", "baa", "bar" ,"bars" ,"baser" ,"beach" ,"bear" ,"bears", "bra", "brae" ,"bras" ,"brew" ,"caber", "care" ,"cars", "cashew" ,"caws" ,"char" ,"chase" ,"chaser", "chews", "crash" ,"crew" ,"each" ,"ear" ,"ears" ,"eh", "era", "eras", "ha" ,"hawser", "he" ,"hears" ,"her" ,"hew" ,"hews" ,"races" ,"rash" ,"reach" ,"rehab" ,"sabre", "sac", "scab", "scarab" ,"screw", "sea" ,"search", "sew", "she", "shear" ,"swear", "war", "wars", "was", "washer", "we", "wear" ,"wears","be","abs","ace","arc","ash","cab","car","has","raw","saw","web","area","arse","bare","base","bash","cabs","cash","chew","crab","hare","hear","herb","hers","race","wash","carwash","rehabs","breach","bares","brace","brash","cares","crabs","hares","herbs","sawer","scare","sewar","haw","case","share","sear","ware","wares","rase","brews","caw"};
    private static String[] WordSetEx10 = new String[]{"deems","demon","demos","dens","dent","do","doe","dome" ,"domes" ,"done", "dons", "dose" ,"dost" ,"dote", "dotes", "emend", "emoted", "end" ,"eons", "ex" ,"extend", "me", "meet", "mends", "met" ,"meted" ,"mode" ,"modest" ,"mods" ,"most" ,"mote", "nee" ,"needs" ,"nested", "net", "no" ,"nod", "node", "nods" ,"noes", "not", "note", "ode", "omen", "on", "one" ,"onset" ,"oxen", "see" ,"seem", "seen", "set" ,"sexed" ,"sexton", "snot", "sod", "sox" ,"steno" ,"stoned" ,"ted", "teds" ,"teed" ,"teem", "teen", "tees", "tend" ,"tens", "tensed" ,"to" ,"toed", "toes", "tomes", "ton" ,"toned" ,"tones", "tons","so","den","dot","men","sex","son","ten","deem","does","ends","mend","need","nest","nets","next","nose","ones","seed","sent","some","stem","dense","meets","modes","nodes","noted","notes","omens","semen","stone","teens","tends","demons","demote","denote","demotes","denotes","detoxes","extends","tod","tee","ned","don","ox","toe","tone","mod","dots","detox","steed","send","dont","sot","teems","tom"};
    private static String[] WordSetEx11 = new String[]{"ah","aim","air","airs","am","amps","an","anus","as" ,"asp", "ha" ,"hair", "ham" ,"harm", "harps", "hi", "him" ,"hip", "hips" ,"his", "hm" ,"human" ,"hums", "imp" ,"imps" ,"is" ,"ma", "mains" ,"man" ,"mans" ,"maps" ,"marsh", "mi", "mush" ,"nap", "pan", "parish", "prams" ,"puma" ,"pun", "puns" ,"purism" ,"pus", "ramps" ,"ran" ,"rani", "raps", "rash", "rasp", "rip", "ruins", "rum" ,"rump" ,"rums", "sap", "sari" ,"sham", "shin" ,"shrimp" ,"shun", "sin" ,"spa", "spar" ,"spin" ,"spun" ,"spur" ,"spurn" ,"sump", "sun" ,"um" ,"ump", "unis", "up", "urn", "us","in","amp","arm","ash","has","hum","map","nip","par","pin","ram","rap","rim","run","sip","sir","sum","aims","arms","harp","hump","main","mars","mash","naps","pain","pair","pins","pish","pram","push","rain","ramp","rams","rims","rips","ruin","rush","snap","snip","hairs","harms","humps","minus","pains","pairs","prism","pumas","rains","ramps","rumps","sharp","humans","mishap","punish","shipman","hun","huns","ship","spam","pars","sup","im","nips","mar","hap","nah"};
    private static String[] WordSetEx12 = new String[]{"abase","abate","abet","abreast","am","are","areas","arts","as","at" ,"ate", "ax" ,"baa", "bar" ,"barest","bars" ,"baser" ,"baste" ,"bat", "beams" ,"bear" ,"bears" ,"beat" ,"beats","beta" ,"bets", "bra", "brae" ,"bras", "brats", "breast", "ear", "ears", "era", "eras", "ex", "exams" ,"ma" ,"mares" ,"mart", "marts" ,"master" ,"maters", "me" ,"meat", "meats" ,"met", "rat", "rate", "reams" ,"resat", "rest", "sabre" ,"sea" ,"seam", "seat", "set" ,"smear" ,"star", "steam", "tab" ,"tabs" ,"tame", "tamer" ,"tames" ,"tar", "tars", "tax" ,"taxes", "tea", "team", "teas", "tram" ,"tsar","be","arm","art","axe","bet","eat","mat","max","ram","sat","sex","area","arms","arse","axes","bare","base","bate","bats","beam","best","brat","exam","mast","mate","mars","mats","rams","rats","ream","same","stab","stem","tear","term","bares","beast","extra","mates","rates","smart","stare","teams","terms","trams","extras","stream","tamers","bream","tears","mar","bates","sear"};
    private static String[] WordSetEx13 = new String[]{"aeons","ah","an","anew","anise","as","awe","awes","ban","bane","banish" ,"bans" ,"bins", "bison" ,"boa" ,"bones", "bonsai" ,"bows" ,"eh" ,"eons" ,"ha" ,"he", "hen" ,"hew" ,"hews" ,"hi", "hies" ,"his" ,"hob" ,"hobs" ,"hoe" ,"hose" ,"ions" ,"is", "nab" ,"news" ,"nibs" ,"no", "nobs", "noes", "noise", "now", "oh", "oi" ,"on", "one", "owe" ,"owes", "own", "owns", "sea", "sew" ,"she", "shin", "shoe", "shone", "show", "sin" ,"snow" ,"soh" ,"sown", "swain" ,"swine" ,"wan" ,"was", "we" ,"weans" ,"when", "whoa", "wines", "wino", "wins" ,"wish" ,"won","be","in","so","ash","bin","bow","has","how","ion","nob","saw","sob","son","web","who","win","base","bash","bean","bias","bone","hens","nose","ones","sane","sawn","sewn","snib","snob","wane","wine","wise","woes","banes","basin","beans","shine","shown","wanes","whose","banshie","wishbone","woe","new","nib","whine","wash","sine","wean","hone"};
    private static String[] WordSetEx14 = new String[]{"ah","apse","are","as","asp","awe","awes","ear","ears","eh","era","eras" ,"ha", "harps", "hawser" ,"haze" ,"hazes" ,"he", "heaps", "hears" ,"her" ,"hew", "hews" ,"hues" ,"pare" ,"pause" ,"paw", "peas", "pew" ,"phrase", "purse", "pus", "pusher" ,"rape" ,"rapes" ,"raps" ,"rash" ,"rasp" ,"reap" ,"rep", "rue", "rues", "sap", "sea" ,"seraph" ,"sew", "she", "shear", "spa", "spar", "spear", "spew" ,"spur", "super" ,"sure" ,"swap" ,"swear", "up", "us", "use" ,"user" ,"war" ,"warp" ,"warps" ,"wars" ,"was" ,"washer", "we", "wear", "wears", "whups" ,"wrap", "wraps" ,"zap", "zaps","ape","ash","has","hue","par","pea","pur","rap","raw","saw","arse","hare","harp","heap","hear","hers","paws","pear","pure","purs","push","rush","wash","wasp","hares","parse","pears","reaps","sewar","shape","share","sharp","spare","usher","washup","pars","raze","sear","sue","ware","phase","pews","wares"};
    private static String[] WordSetEx15 = new String[]{"ail","aim","air","airs","also","am","amours","arcs","as","calms", "cam" ,"carol", "cars", "claims" ,"clamor" ,"clamors", "coil" ,"cola" ,"cols", "coma", "cor", "corals" ,"corm", "corms", "cram" ,"cum" ,"curio" ,"curs" ,"is", "lairs", "liars", "limos" ,"lo", "loam", "locums" ,"lour" ,"ma", "macs" ,"mail", "mails", "mauls" ,"mi" ,"mica", "micro" ,"micros", "mics" ,"molar" ,"murals", "music", "oars" ,"oi" ,"ours" ,"rail" ,"roam" ,"roils", "rum" ,"rums" ,"sac", "sail" ,"sari", "scam" ,"scour" ,"scram", "scrum", "silo", "slam" ,"slim" ,"soil" ,"solar", "sou", "soul" ,"sour", "um", "uric" ,"us","or","so","arc","arm","car","oar","oil","our","rim","sir","sum","aims","also","arms","calm","clam","curl","liar","lair","lima","limo","mars","oils","oral","rims","sumo","claim","clams","coils","comas","coral","curls","locus","moral","rails","roams","molars","morals","mosiac","racism","sailor","social","musical","ram","rams","slum","scar","sil","soar","mar","moa"};
    private static String[] WordSetEx16 = new String[]{"ad","ah","an","anode","ant","at","ate","atone","attuned","aunt", "auto", "daunt", "dean" ,"death" ,"dent", "do", "doe", "donate", "done" ,"dote", "dune", "eh" ,"end", "ha" ,"hand", "handout", "hat" ,"hated" ,"haunt" ,"he" ,"hen" ,"hod", "hoe" ,"honed", "hot" ,"hunted" ,"hut", "net", "nett" ,"no", "nod" ,"node" ,"not" ,"note" ,"nut" ,"nutted" ,"ode" ,"oh" ,"on","one" ,"out" ,"tan", "taunted" ,"taut", "tea" ,"teat", "ted" ,"tend", "tent" ,"than" ,"the" ,"then" ,"thou", "thud" ,"to", "toed", "ton" ,"toned" ,"tot" ,"toted" ,"touted" ,"tuned" ,"tut" ,"undo", "unto","and","den","dot","duo","eat","had","hue","oat","ode","tad","ten","date","dunt","hate","head","heat","hone","hunt","neat","nude","oath","that","toad","tone","tote","tout","tuna","donut","hound","noted","outed","taunt","tenth","attend","attune","hotted","notate","haunted","notated","outdate","ned","dane","dont","doth","tod","tune","toe","don","hun"};

    private static Scanner s = new Scanner(System.in);
    private static Scanner s2;
    private static Formatter f;

    public static boolean isWordThere(String Word,String[] WordSet) {
	for(int i=0; i<WordSet.length; i++) {
	    if (WordSet[i].equalsIgnoreCase(Word)) {
		return true;
	    }
	}
	return false;
    }
    public static boolean checkWord(String Word, int LetterSetNum) {
	switch (LetterSetNum) {
	case 1:
	    return isWordThere(Word,WordSet1);
	case 2:
	    return isWordThere(Word,WordSet2);
	case 3:
	    return isWordThere(Word,WordSet3);
	case 4:
	    return isWordThere(Word,WordSet4);
	case 5:
	    return isWordThere(Word,WordSet5);
	case 6:
	    return isWordThere(Word,WordSet6);
	case 7:
	    return isWordThere(Word,WordSet7);
	case 8:
	    return isWordThere(Word,WordSet8);
	case 9:
	    return isWordThere(Word,WordSet9);
	case 10:
	    return isWordThere(Word,WordSet10);
	case 11:
	    return isWordThere(Word,WordSet11);
	case 12:
	    return isWordThere(Word,WordSet12);
	case 13:
	    return isWordThere(Word,WordSet13);
	case 14:
	    return isWordThere(Word,WordSet14);
	case 15:
	    return isWordThere(Word,WordSet15);
	case 16:
	    return isWordThere(Word,WordSet16);
	default:
	    return false;
	}
    }  

  public static int Length(int LetterSetNum) {
	switch (LetterSetNum) {
	case 1:
	    return WordSet1.length;
	case 2:
	    return WordSet2.length;
	case 3:
	    return WordSet3.length;
	case 4:
	    return WordSet4.length;
	case 5:
	    return WordSet5.length;
	case 6:
	    return WordSet6.length;
	case 7:
	    return WordSet7.length;
	case 8:
	    return WordSet8.length;
	case 9:
	    return WordSet9.length;
	case 10:
	    return WordSet10.length;
	case 11:
	    return WordSet11.length;
	case 12:
	    return WordSet12.length;
	case 13:
	    return WordSet13.length;
	case 14:
	    return WordSet14.length;
	case 15:
	    return WordSet15.length;
	case 16:
	    return WordSet16.length;
	default:
	    return 0;
	}
    }

 public static int LengthEx(int LetterSetNum) {
	switch (LetterSetNum) {
	case 1:
	    return WordSetEx1.length;
	case 2:
	    return WordSetEx2.length;
	case 3:
	    return WordSetEx3.length;
	case 4:
	    return WordSetEx4.length;
	case 5:
	    return WordSetEx5.length;
	case 6:
	    return WordSetEx6.length;
	case 7:
	    return WordSetEx7.length;
	case 8:
	    return WordSetEx8.length;
	case 9:
	    return WordSetEx9.length;
	case 10:
	    return WordSetEx10.length;
	case 11:
	    return WordSetEx11.length;
	case 12:
	    return WordSetEx12.length;
	case 13:
	    return WordSetEx13.length;
	case 14:
	    return WordSetEx14.length;
	case 15:
	    return WordSetEx15.length;
	case 16:
	    return WordSetEx16.length;
	default:
	    return 0;
	}
    }

public static boolean checkWordEx(String Word, int LetterSetNum) {
	switch (LetterSetNum) {
	case 1:
	    return isWordThere(Word,WordSetEx1);
	case 2:
	    return isWordThere(Word,WordSetEx2);
	case 3:
	    return isWordThere(Word,WordSetEx3);
	case 4:
	    return isWordThere(Word,WordSetEx4);
	case 5:
	    return isWordThere(Word,WordSetEx5);
	case 6:
	    return isWordThere(Word,WordSetEx6);
	case 7:
	    return isWordThere(Word,WordSetEx7);
	case 8:
	    return isWordThere(Word,WordSetEx8);
	case 9:
	    return isWordThere(Word,WordSetEx9);
	case 10:
	    return isWordThere(Word,WordSetEx10);
	case 11:
	    return isWordThere(Word,WordSetEx11);
	case 12:
	    return isWordThere(Word,WordSetEx12);
	case 13:
	    return isWordThere(Word,WordSetEx13);
	case 14:
	    return isWordThere(Word,WordSetEx14);
	case 15:
	    return isWordThere(Word,WordSetEx15);
	case 16:
	    return isWordThere(Word,WordSetEx16);
	default:
	    return false;
	}
    }
    public static void main(String[] args) {
	try {
	    System.out.println("Enter file ID you want to format");
	    String ID = s.next();
	    s2 = new Scanner(new File(ID+".txt"));
	    f = new Formatter(ID+"X.txt");
	    s2.next();
	    int correctCount=0,incorrectCount = 0,correctCountEx=0,incorrectCountEx =0;
	    String Outputs=("ColourCondition LetterSet CorrectWords IncorrectWords TotalWords "+System.getProperty("line.separator"));
	    f.format("%s",Outputs);
	    while (s2.hasNext()) {
		correctCount=0;
		incorrectCount=0;
		correctCountEx=0;
		incorrectCountEx=0;
		s2.next(); //ID number
		s2.next();
		s2.next(); //ExpNum
		s2.next();
		String ColourNum = s2.next(); // Colour condition number
		s2.next();
		int LetterSetNum = s2.nextInt(); // LetterSet Number
		s2.next();
		s2.next();
		boolean contin = true;
		String Word;
		do {
		    if (s2.hasNext()) {
			Word = s2.next();
			if(Word.equals("ID")) {
			    contin = false;
			}
			else {
			    if (checkWord(Word,LetterSetNum)) {
				correctCount++;
			    }
			    else {
				incorrectCount++;
			    }
			    if(checkWordEx(Word,LetterSetNum)) {
				correctCountEx++;
			    }
			    else {
				System.out.println("IncorrectWordEx is - "+Word + " LetterSet- "+LetterSetNum);
				incorrectCountEx++;
			    }
			}
		    }
		    else {
			contin = false;
		    }
		}
		while (contin);
		int totalwords = Length(LetterSetNum);
		int totalwordsEx = LengthEx(LetterSetNum);
		//String[] Outputs = {ColourNum+ " "+ LetterSetNum + " " +correctCount + " "+ incorrectCount+ " "+ totalwords + " " + correctCountEx + " " + incorrectCountEx + " " + totalwordsEx + System.getProperty("line.separator")};
		Outputs = (ColourNum+ " "+ LetterSetNum + " " + correctCountEx + " " + incorrectCountEx + " " + totalwordsEx + System.getProperty("line.separator"));
		f.format("%s",Outputs);
	    }
	    f.close();
	}
	catch(Exception e) {e.printStackTrace();}
    }
}
