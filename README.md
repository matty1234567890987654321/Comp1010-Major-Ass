# Comp1010-Major-Ass
What problem your application solves
The problem that our group was hired to solve was to put a music library management system into stormtrooper helmets so they can listen to music while in space combat  using voice controls. The problem consisted of creating a music library, making a functional search system, and creating a song navigation system which includes the ability to go backwards and forwards on songs as well as shuffle play. 

Design process 
The design process began with selecting Topic 2: Music Library Management. The next stage involved analysing the prompt to outline specific tasks. It was decided to implement five primary classes: Artist, Song, Album, Library, PlayQueue, and Main. After defining these classes and their constructors, Library.java was selected to host the user interaction code, allowing users to query the library for specific songs via the start() function. User input handling was integrated, with validation to re-prompt users in cases of invalid input or when no songs were available in the library. The next focus was on enhancing playback functionality, enabling users to skip to the next song, return to the previous one, or activate shuffle play. Code formatting, including commenting and indentation, was standardised throughout the project for clarity and consistency. Finally, test cases were developed and executed to identify and resolve any errors, ensuring the program’s functionality aligned with the initial specifications.

description 
Our program consists of five classes, five tests and this document. 

+------------------+
|      Artist      |
+------------------+
| - name: String   |
| - songs: Songs[] |
| - songCount: int |
+------------------+
| + getName(): String |
| + addSong(song: Songs): void |
| + getSongs(): Songs[] |
| + toString(): String |
+------------------+

+------------------+
|      Songs       |
+------------------+
| - title: String  |
| - duration: String|
| - artist: Artist  |
| - album: String   |
+------------------+
| + getTitle(): String |
| + getDuration(): String |
| + getArtist(): Artist |
| + getAlbum(): String |
| + toString(): String |
+------------------+

+------------------+
|      Album       |
+------------------+
| - albumTitle: String |
| - artist: Artist      |
| - songsArray: Songs[] |
| - songCount: int      |
| - currentSongIndex: int |
+------------------+
| + addSong(song: Songs): void |
| + removeSong(title: String): void |
| + nextSong(): Songs |
| + previousSong(): Songs |
| + getAlbumTitle(): String |
| + getArtist(): Artist |
| + getSongsArray(): Songs[] |
| + shuffleSongs(): void |
| + getCurrentSong(): Songs |
| + getSongCount(): int |
+------------------+

+------------------+
|      Library     |
+------------------+
| - librarySongs: ArrayList<Songs> |
| - scanner: Scanner |
+------------------+
| + start(): void |
| + displayAllSongs(): void |
| + userSearch(): void |
| + searchByArtist(artistName: String): ArrayList<Songs> |
| + saveLibrary(filename: String): void |
| + loadLibrary(filename: String): void
| + PlayQueue (int currentIndex, ArrayList<Songs> songList)|
+------------------+

+------------------+
|      Main        |
+------------------+
| + main(args: String[]): void |
+------------------+


 Album.java the class begins with the class constructor to initialise the songs. This is followed by numerous methods pertaining to the Album class like addSong, removeSong which allows the album to be modified. The Song navigation aspect of the program exists in the Album class with methods nextSong skipping to the next song in the album, and previous song navigating to the last played song. Shuffle play is also featured in the program in the Album Class that plays a random song in the album you are listening to. The class also contains the method to retrieve the current song and display that to the user.

Artist.Java’s fundamental purpose is to function as a constructor allowing other classes to call it to display a specific artist of search for that artist. 

Library. Java is the User Interface of the program. The class begins with the constructor and then queries the user through a series of methods. In the function Start conditionals are used to interpret the user's inputs. The method displays all songs using a for loop to display all the songs in the library. Methods from the Album and Artist class are used to search and display the songs when searching the songs Album, or Artist. 

Main.Java is where all the song, artist and album objects are stored. It is also where the Library is initialised and the program begins. 

Songs.java contains a constructor for the class that initialises all the attributes: title, duration, artist and album. 

Tests 
For unit testing, we employed the junit.jupiter.api.BeforeEach, org.junit.jupiter.api.Test, and static org.junit.jupiter.api.Assertions.* imports alongside a test runner to systematically validate core functionalities of the music library system, focusing on album, artist, song, and library management.The tests encompass several key areas, General Imports: JUnit annotations and assertions manage setup and validate test outcomes.Album Tests: Confirm functionality for adding, removing, navigating (next/previous), and shuffling songs, as well as verifying album details (title and artist).Artist Tests: Assess setting artist names, adding songs within defined limits, and enforcing capacity constraints.Library Tests: Ensure correct search functionality for songs by artist, accurate display of all songs, identification of unique albums, and iteration through a song queue.Main Tests: Cover the addition and removal of songs from albums, song navigation, and library search functions. Song Tests: Validate song creation, attribute retrieval (title, duration, artist), and string representation.
Task allocation 
Matthew La 30%

Component A
Functionality (3 marks)
Search 
Playing songs 
Shuffle play 
Skips 
Scope (5 marks)
Objects ( artists)
Arraylist (songs)
Recursion (searchSong)
Component B
Delegation
Class Design

Alan Kim 20%
Component A
Unit testing (2 marks)
scope(5 marks)
Objects (artists)
Arraylist (songs)
Component B
Class design 
Delegation 
Commenting
Indentation 

Sonya Kim 20%
Component A
scope(5 marks)
Objects (artists)
Arraylist (songs)
File I/O
Component B
Delegation
Class Design
Indentation 

Tom Kilburn 20%
Component A
scope(5 marks)
Objects (artists)
Arraylist (songs)
Component B
Class Design
Providing README.md file 
What problem your application solves
A description of the structure of your program
instructions on how to run the project

How to run the program

Download the Program zip 
Extract the folder 
Open VS code 
Open folder in the workspace 
Run the program
Open the terminal 
(from this step follow the choice tree)
[Start Program]
       ↓
[Display Main Menu]
       ↓
[Choose Option]
       ├───────────────┐
       │               │
       ↓               ↓
[1. Display All Songs]  [2. Search by Artist]
       ↓                       ↓
[Show All Songs]       [Enter Artist Name]
       ↓                       ↓
[Select Song to Play]   [Display Matching Songs]
       ↓                       ↓
[Play Selected Song]     [Select Song to Play]
       ↓                       ↓
[Return to Main Menu]   [Return to Main Menu]
       ↓                       ↓
[5. Create PlayQueue]    [8. Exit Program]
       ↓                       ↓
[Select Songs for Queue]  [End Program]
       ↓                       ↓
[Start Playback]          
       ↓                       ↓
[Return to Main Menu]                      
[8. Exit Program]
 [End Program]
