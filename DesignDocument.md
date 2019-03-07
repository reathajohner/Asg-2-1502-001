# Asignment 1
## The Public Interface
The public interface will allow the user to add new players, list their roster information, list their stats, record shots, record goals and assits, record powerplay goals and assists, as well as relating that information in relation to a goalie, recording minutes played by a goalie, and recording shutouts with minutes played.

_Definitions For Terms Used:_ 
* Common Variables - includes all roster information (name, position, jersey number, date of birth, home town, weight, height)
* Skater Unique Variables - includes goals, assists, powerplay goals, powerplay assists, and shots on net.
* Goalie Unique Variables - includes shots against, goals against, shutouts, minutes.

Read more about the classes below in the order of Player, Goalie, Skater, PlayerList, TeamReader, TeamWriter, TableFactory, Table, RosterTable, SkaterStatTable,  and GoalieStatTable.

### Player, Skater, and Goalie
Class Description - The Player abstract superclass has 2 subclasses, Skater and Goalie. Both a Skater and a Goalie have the "Is A" relationship to Player.

Methods - The methods of this class includes:
* Accessors for all common variables. Accepts nothing. Returns the related variable.
* Mutators for all common variables. Accepts the type (Strings & Enum) to change the related variable. Returns nothing.
* A constructor that sets up all information common to both classes. Accepts all common variables. Returns nothing.


#### Skater
Class Description - This class manages Skaters. Skaters are players that can score goals, thus have related goal scoring stats.
They also have positions that do not include the goalie (G) position. These include right wing, left wing, center, and defence.

Methods - The methods of this class includes:
* A constructor that makes use of the Player constructor. 
* A constructor that creates a Skater with existing stats. Accepts all Skater Unique Variables as well as goals, assists, powerplay goals, powerplay assists, and shots on net.
* Accessors for all Skater Unique Variables as well as goals, assists, powerplay goals, powerplay assists, shots on net, points, powerplay points, and shooting percentage.
* Mutators for all Skater unique variables 
* `calcShotsPer` to calculate successful shots percentage. Accepts nothing. Returns nothing.
* `calcPoints`to calculate non powerplay points. Accepts nothing. Returns nothing.
* `calcPPPoints`to calculate  powerplay points. Accepts nothing. Returns nothing.


#### Goalie
Class Description -  This class manages Goalies. Goalies are players that CANNOT score goals. Instead they have stats including shots against, goals against, shutouts, minutes played, goals against averages, and save percentages.
They have the position of goalie (G). This is important because they can be identified by this trait.

Methods - The methods of this class includes:
* A constructor that makes use of the Player constructor (no stats). 
* A constructor that creates a Goalie with existing stats. Accepts all common variables as well as int shots against, int goals against, int shutouts, and int minutes. Returns nothing.
* Accessors for all Goalie unique variables. Accepts nothing. Returns the related goalie unique variable.
* Mutators for all Goalie unique variables. Accepts nothing. Returns nothing.
* Mutator `getSavePer` to calculate successful save percentage. Accepts nothing. Returns save percentage.
* Mutator `getGAA` to calculate goals against average. Accepts nothing. Returns nothing.
* Mutator `recordMinutes` to records minutes played. Accepts int of minutes played. Returns nothing. 


### Player List
Class Description - The Player List class manages, adding Players to an Array List and making changes to that Array List (including adding and removing players). 

Method Descriptions - The methods of this class includes:
* A constructor to create an ArrayList. Accepts nothing. Returns nothing
* Mutator for the ArrayList to add a player. Accepts a Player. Returns nothing.
* Accessor to get stored players. Accepts nothing. Returns a the ArrayList.
* Accessor to retrieve player by number. Accepts a String for the player number. Returns a player.
* Accessor to retrieve Skaters. Accepts nothing. Returns a String of all players that are not goalies from the ArrayList.
* Accessor to retrieve Goalies. Accepts nothing. Returns a String of all goalies from the ArrayList.

### Menu
Class Description - The Menu class is what the user most directly interacts with. It calls the other classes to fulfill its functions.
To list roster information, list player statistics, record goals, record shots, and record shut outs it calls the Player class and its subclasses. To add players it calls the related Player class as well as the PlayerList class to add them to the ArrayList. To imput player information files it calls the TeamReader class and the TableFactory class. To output files it calls the TeamWriter class and the TableFactory class.

Method Descriptions - 
* Main method runs the entire program. Accepts no arguments. Void and returns nothing.
* `printMenu` prints out the menu. Accepts nothing. Returns nothing.
* `doMenu` menu option switch. Accepts String input and PlayerList list. Returns boolean.
* `listRoster` prints out all players roster. Accepts PlayerList list. Retruns nothing.
* `listStats` prints out all players and their stats. Accepts PlayerList list. Retruns nothing.
* `addPlayer` adds player information. Accepts PlayerList list. Retruns nothing. Calls player constructor based on position. Calls addPlayer in PlayerList.
* `recordShot` reccords a shot for a Skater. Accepts PlayerList list and a String player number. Returns nothing.
* `recordGoal` reccords a goal for a Skater and up to 2 assists. Accepts PlayerList list, String input, and boolean powerplay. Returns nothing.
* `recordShutout`records a shutout for a Goalie. Accepts PlayerList list, and a String player number. Returns nothing.

### TableFactory & Table
Class Description - A superclass that contains 3 subclasses(`RosterTable``SkaterStatTable``GoalieStatTable`)Allows for the user to pass in a PlayerList and get back a String. This can be used to print. A roster information list of all players, print a list of all skaters and stats, and print a list of all goalies and stats.

Subclasses Descriptions - 
* `RosterTable` prints roster info for all players. Accepts a PlayerList. Returns a String.
* `SkaterStatTable` prints all Skater and stats info. Accepts a PlayerList. Returns a String.
* `GoalieStattable.` prints all Goalie and stats info. Accepts a PlayerList. Returns a String.

### TeamReader
Class Description - Allows for the user to pass in a File and get back a PlayerList loaded from that file.

Methods -
* `teamReader` reads a .txt file and calls Player constructors and the addPlayer method of PlayerList to create a team. Accepts a String filename. Returns nothing.

### TeamWriter
Class Description - Allows for the user to pass in a File and a PlayerList and the PlayerList will be written to the file.

Methods - 
* `teamWriter` prints out all the Players from the ArrayList into a .txt file. Accepts a String filename. Returns nothing.

## Implementation Details
Provides a full description of the internal state of the class and for all methods there is a plan for implementation or an algorithm provided.

### Skater
Player needs to store:
* name - String
* birth - String
* homeTown - String
* weight - String
* height - String
* pNum - String
* position - Enum
* goals - int
* assists - int
* ppGoals - int
* ppAssists - int
* shots - int
* shotsPer - double
* points - int
* ppPoints - int

#### Important Methods
* `ppPoints` Calculates the total points ppGoals + ppAssist
* `shotPer` Calculates the shots percentage by dividing (goals + ppGoals) by shots. 
* `points` Calculates total points goals + assists

### Goalie
Player List needs to store:
* name - String
* birth - String
* homeTown - String
* weight - String
* height - String
* pNum - String
* position - Enum
* shotsAgainst - int
* goalsAgainst - int
* shutouts - int
* minutes - int
* gAA - double
* savePer - double

#### Important Methods
* `gAA` Goals against * 60 minutes / minutes played
* `savePer` 1 - (goals against / shots against).

### Menu
Menu needs to store:
* A variable - type
* A variable - type 

#### Important Methods
* `method name` Method description
* `method name` Method description

### TableFactory & Table
Menu needs to store:
* A variable - type
* A variable - type 

#### Important Methods
* `method name` Method description
* `method name` Method description

### TeamReader
Menu needs to store:
* A variable - type
* A variable - type 

#### Important Methods
* `method name` Method description
* `method name` Method description

### TeamWriter
Menu needs to store:
* A variable - type
* A variable - type 

#### Important Methods
* `method name` Method description
* `method name` Method description

