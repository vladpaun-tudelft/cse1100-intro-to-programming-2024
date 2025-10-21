import java.util.List;

public class TestDB {

    static final Song missAmericana = new Song("Miss Americana & the Heartbreak Prince", 3*60+54);
    static final Song cruelSummer = new Song("Cruel Summer", 2*60+58);
    static final Song theMan = new Song("The Man", 3*60+10);
    static final Song youNeedToCalmDown = new Song("You Need to Calm Down", 2*60+51);
    static final Song lover = new Song("Lover", 3*60+41);
    static final Song theArcher = new Song("Archer", 3*60+31);
    static final Song fearless = new Song("Fearless", 4*60+1);
    static final Song youBelongWithMe = new Song("You Belong With Me", 3*60+51);
    static final Song loveStory = new Song("Love Story", 3*60+55);
    static final Song tisTheDamnSeason = new Song("'tis the damn season", 3*60+49);
    static final Song noBodyNoCrime = new Song("no body, no crime", 3*60+35);
    static final Song willow = new Song("willow", 3*60+34);
    static final Song marjorie = new Song("marjorie", 4*60+17);
    static final Song champagneProblems = new Song("champagne problems", 4*60+4);
    static final Song tolerateIt = new Song("tolerate it", 3*60+49);
    static final Song readyForIt = new Song("...Ready for it?", 3*60+28);
    static final Song delicate = new Song("Delicate", 3*60+52);
    static final Song dontBlameMe = new Song("Don't Blame Me", 3*60+56);
    static final Song lookWhatYouMadeMeDo = new Song("Look What You Made Me Do", 3*60+31);
    static final Song enchanted = new Song("Enchanted", 5*60+53);
    static final Song longLive = new Song("Long Live", 5*60+17);
    static final Song twentyTwo = new Song("22", 3*60+50);
    static final Song weAreNeverEverGettingBackTogether = new Song("We Are Never Ever Getting Back Together", 3*60+13);
    static final Song iKnewYouWereTrouble = new Song("I Knew You Were Trouble", 3*60+39);
    static final Song nothingNew = new Song("Nothing New", 4*60+18);
    static final Song allTooWell = new Song("All Too Well", 5*60+29);
    static final Song seven = new Song("seven", 3*60+28);
    static final Song the1 = new Song("the 1", 3*60+30);
    static final Song betty = new Song("betty", 4*60+54);
    static final Song theLastGreatAmericanDynasty = new Song("the last great american dynasty", 3*60+50);
    static final Song august = new Song("august", 4*60+21);
    static final Song illicitAffairs = new Song("illicit affairs", 3*60+10);
    static final Song myTearsRicochet = new Song("my tears ricochet", 4*60+15);
    static final Song cardigan = new Song("cardigan", 3*60+59);
    static final Song style = new Song("Style", 3*60+51);
    static final Song blankSpace = new Song("Blank Space", 3*60+51);
    static final Song shakeItOff = new Song("Shake It Off", 3*60+39);
    static final Song wildestDreams = new Song("Wildest Dreams", 3*60+40);
    static final Song badBlood = new Song("Bad Blood", 3*60+31);
    static final Song lavenderHaze = new Song("Lavender Haze", 3*60+22);
    static final Song antiHero = new Song("Anti-Hero", 3*60+20);
    static final Song midnightRain = new Song("Midnight Rain", 2*60+54);
    static final Song vigilanteShit = new Song("Vigilante Shit", 2*60+44);
    static final Song bejeweled = new Song("Bejeweled", 3*60+14);
    static final Song mastermind = new Song("Mastermind", 3*60+11);
    static final Song karma = new Song("Karma", 3*60+24);

    static final Tour eras = new Tour("Taylor Swift", List.of(
        missAmericana,
        cruelSummer,
        theMan,
        youNeedToCalmDown,
        lover,
        theArcher,
        fearless,
        youBelongWithMe,
        loveStory,
        tisTheDamnSeason,
        noBodyNoCrime,
        willow,
        marjorie,
        champagneProblems,
        tolerateIt,
        readyForIt,
        delicate,
        dontBlameMe,
        lookWhatYouMadeMeDo,
        enchanted,
        longLive,
        twentyTwo,
        weAreNeverEverGettingBackTogether,
        iKnewYouWereTrouble,
        nothingNew,
        allTooWell,
        seven,
        the1,
        betty,
        theLastGreatAmericanDynasty,
        august,
        illicitAffairs,
        myTearsRicochet,
        cardigan,
        style,
        blankSpace,
        shakeItOff,
        wildestDreams,
        badBlood,
        lavenderHaze,
        antiHero,
        midnightRain,
        vigilanteShit,
        bejeweled,
        mastermind,
        karma
    ));

    static final Song dress = new Song("Dress", 3*60+50);
    static final Song exile = new Song("Exile", 4*60+45);
    static final Song corneliaStreet = new Song("Cornelia Street", 4*60+47);
    static final Song youreOnYourOwnKid = new Song("You're On Your Own, Kid", 3*60+14);

    static final Concert concertLA = new Concert(eras, "Los Angeles", List.of(dress, exile));
    static final Concert concertMX = new Concert(eras, "Mexico City", List.of(corneliaStreet, youreOnYourOwnKid));
    static final Concert concertAMS = new Concert(eras, "Amsterdam", List.of(/*???*/));

}
